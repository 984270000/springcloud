package com.xinyu.springcloud.service;
/*
Created by IntelliJ IDEA.
  Author: Xy Zhang
  Date: 2020 2020/11/12
  Time: 17:03
*/

import com.xinyu.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;


//降级~
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {

    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean addDept(Dept dept) {
                return false;
            }

            @Override
            public Dept queryDeptById(Long deptNo) {
                System.err.println("服务降级~");
                return new Dept().setDeptNo(deptNo).setdName("deptNo => " + deptNo +  "没有对应的消息,客户端提供了降级的信息，这个服务现在已经被关闭~").setDb_source("no this database in MYSQL !");
            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }
        };
    }
}
