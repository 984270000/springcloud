package com.xinyu.springcloud;/*
Created by IntelliJ IDEA.
  Author: Xy Zhang
  Date: 2020 2020/11/7
  Time: 01:03
*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//启动之后访问 http://localhost:7003/
@SpringBootApplication
@EnableEurekaServer//EnableEurekaServer 服务端的启动类，可以接受别人注册进来
public class EurekaServer_7003 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_7003.class, args);
    }
}
