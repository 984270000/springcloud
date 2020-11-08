package com.xinyu.springcloud.controller;/*
Created by IntelliJ IDEA.
  Author: Xy Zhang
  Date: 2020 2020/11/6
  Time: 15:20
*/

import com.xinyu.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {
    //理解：消费者不应该有service层~
    //RestTemplate ... 供我们直接调用！注册到spring中
    //三个参数 String url, Class<T> responseType, Map<String,?> uriVaribles
    @Autowired
    private RestTemplate restTemplate;//提供多种便捷访问远程http服务的方法，简单的restful服务模板

    //http://localhost:8001/dept/get/{deptNo}
//    private static final String REST_URL_PREFIX = "http://localhost:8001";
    //通过Ribbon实现客户端负载均衡时候要写成id
    // Ribbon整合Eureka之后就不用写域名+端口号了，直接写id就好了（Application）
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    @RequestMapping(value = "/consumer/dept/add", method = RequestMethod.POST)
    public boolean addDept(@RequestBody Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, boolean.class);
    }

    @RequestMapping("/consumer/dept/get/{deptNo}")
    public Dept get(@PathVariable("deptNo") Long deptNo) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + deptNo, Dept.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> queryAll() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }
}
