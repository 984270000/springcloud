package com.xinyu.myrule;/*
Created by IntelliJ IDEA.
  Author: Xy Zhang
  Date: 2020 2020/11/11
  Time: 15:10
*/

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class XinYuRule {

    @Bean
    public IRule myRule(){
        return new XinYuRandomRule();//默认是轮询，现在我们定义为  XinYuRandomRule
    }
}
