package com.xinyu.springcloud.controller;/*
Created by IntelliJ IDEA.
  Author: Xy Zhang
  Date: 2020 2020/11/16
  Time: 0:19
*/

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServer;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/config")
    public String getConfig(){
        return "applicationName = " + applicationName + "、eurekaServer = " + eurekaServer + "、port" + port;
    }

}
