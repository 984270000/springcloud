package com.xinyu.springcloud;/*
Created by IntelliJ IDEA.
  Author: Xy Zhang
  Date: 2020 2020/11/6
  Time: 15:50
*/

import com.xinyu.myrule.XinYuRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.xinyu.springcloud"})
//在微服务启动的时候就能去自动加载我们的自定义Ribbon类
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT",configuration = XinYuRule.class)
public class DeptConsumer_feign {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_feign.class, args);
    }
}
