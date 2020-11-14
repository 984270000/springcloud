package com.xinyu.springcloud;/*
Created by IntelliJ IDEA.
  Author: Xy Zhang
  Date: 2020 2020/11/6
  Time: 14:26
*/

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

//启动类
@SpringBootApplication
@EnableEurekaClient//cs架构 配置之后可以吧客户端的东西自动注册到我们的eureka服务端中！
@EnableDiscoveryClient//服务发现自己
@EnableCircuitBreaker//添加对熔断的支持
public class DeptProviderHystrix_8001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProviderHystrix_8001.class, args);
    }

    //固定代码放进监控
    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet(){
        ServletRegistrationBean registrationBean =  new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        return registrationBean;
    }

}
