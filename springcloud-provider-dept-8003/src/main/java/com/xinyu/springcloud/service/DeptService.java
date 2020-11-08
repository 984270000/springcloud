package com.xinyu.springcloud.service;/*
Created by IntelliJ IDEA.
  Author: Xy Zhang
  Date: 2020 2020/11/6
  Time: 14:12
*/

import com.xinyu.springcloud.pojo.Dept;

import java.util.List;

public interface DeptService {

    public boolean addDept(Dept dept);

    public Dept queryDeptById(Long deptNo);

    public List<Dept> queryAll();
}
