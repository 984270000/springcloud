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

    //配置负载均衡实现RestTemplate
    // IRULE
    // RoundRobinRule 磨人的，轮训策略
    // AvailabilityFilteringRule : 回先过滤掉，跳闸，访问故障的服务，对剩下的进行轮训
    // RandomRule 随机
    // RetryRule 重试 ，还是轮询，如果失败会重试
    @Bean
    @LoadBalanced//配置负载均衡实现RestTeamplate Ribbon的作用
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
