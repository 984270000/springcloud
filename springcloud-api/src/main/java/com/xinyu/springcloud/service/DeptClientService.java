package com.xinyu.springcloud.service;
/*
Created by IntelliJ IDEA.
  Author: Xy Zhang
  Date: 2020 2020/11/11
  Time: 16:49
*/

import com.xinyu.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Component
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT")
public interface DeptClientService {

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept);

    @GetMapping("/dept/get/{deptNo}")
    public Dept queryDeptById(@PathVariable("deptNo") Long deptNo);

    @GetMapping("/dept/list")
    public List<Dept> queryAll();
}
