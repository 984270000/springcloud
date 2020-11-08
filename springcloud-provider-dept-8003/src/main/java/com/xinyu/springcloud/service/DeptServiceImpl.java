package com.xinyu.springcloud.service;
/*
Created by IntelliJ IDEA.
  Author: Xy Zhang
  Date: 2020 2020/11/6
  Time: 14:09
*/

import com.xinyu.springcloud.dao.DeptDao;
import com.xinyu.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept queryDeptById(Long deptNo) {
        return deptDao.queryDeptById(deptNo);
    }

    @Override
    public List<Dept> queryAll() {
        return deptDao.queryAll();
    }
}
