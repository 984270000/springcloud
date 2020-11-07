package com.xinyu.springcloud.config;
/*
Created by IntelliJ IDEA.
  Author: Xy Zhang
  Date: 2020 2020/11/6
  Time: 15:26
*/

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {//Configuration -- spring  applicationContext.xml

    @Bean
    @LoadBalanced//配置负载均衡实现RestTeamplate Ribbon的作用
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
