package com.xinyu.springcloud.controller;/*
Created by IntelliJ IDEA.
  Author: Xy Zhang
  Date: 2020 2020/11/6
  Time: 14:14
*/

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xinyu.springcloud.pojo.Dept;
import com.xinyu.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//提供Restful服务！
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    //获取一些配置的信息，得到具体的微服务
    @Autowired
    private DiscoveryClient client;


    @PostMapping("/dept/add")
    public boolean addDept(@RequestBody Dept dept) {
        return deptService.addDept(dept);
    }


    @GetMapping("/dept/get/{deptNo}")
    @HystrixCommand(fallbackMethod = "getHystrix")
    public Dept get(@PathVariable("deptNo") Long deptNo) {
        Dept dept = deptService.queryDeptById(deptNo);
        if(dept == null){
            throw new RuntimeException("deptNo ==> " + deptNo + "， 不存在该用户，或者信息无法找到~");
        }
        return dept;
    }


    @GetMapping("/dept/list")
    public List<Dept> queryAll() {
        return deptService.queryAll();
    }

    //注册进来的微服务，获取一些消息
    @GetMapping("/dept/discovery")
    public Object discovery() {
        //获得微服务列表的清单
        List<String> services = client.getServices();
        System.out.println("discovery=>services:" + services);

        //得到一个具体的微服务信息,通过具体的微服务id，applicationName
       List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost() + "\t"+
                    instance.getPort() + "\t"+
                    instance.getUri() + "\t"+
                    instance.getServiceId() + "\t"
            );
        }
        return this.client;
    }

    /**
     * 下面是备选方法
     */
    public Dept getHystrix(@PathVariable("deptNo") Long deptNo) {
        System.err.println("getHystrix服务熔断！");
        return new Dept().setDeptNo(deptNo).setdName("没有对应的消息，null--@Hystrix").setDb_source("no this database in MYSQL !");
    }

}
