package com.xinyu.springcloud.dao;/*
Created by IntelliJ IDEA.
  Author: Xy Zhang
  Date: 2020 2020/11/6
  Time: 13:59
*/

import com.xinyu.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptDao {

    public boolean addDept(Dept dept);

    public Dept queryDeptById(Long deptNo);

    public List<Dept> queryAll();
}
