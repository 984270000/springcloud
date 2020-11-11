package com.xinyu.springcloud.controller;/*
Created by IntelliJ IDEA.
  Author: Xy Zhang
  Date: 2020 2020/11/6
  Time: 15:20
*/

import com.xinyu.springcloud.pojo.Dept;
import com.xinyu.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptConsumerController {

    @Autowired
    private DeptClientService deptClientService = null;

    @RequestMapping(value = "/consumer/dept/add", method = RequestMethod.POST)
    public boolean addDept(@RequestBody Dept dept) {
        return this.deptClientService.addDept(dept);
    }

    @RequestMapping("/consumer/dept/get/{deptNo}")
    public Dept get(@PathVariable("deptNo") Long deptNo) {
        return this.deptClientService.queryDeptById(deptNo);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> queryAll() {
        return this.deptClientService.queryAll();
    }
}
