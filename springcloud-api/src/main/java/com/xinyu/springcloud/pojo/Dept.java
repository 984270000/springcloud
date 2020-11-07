package com.xinyu.springcloud.pojo;/*
Created by IntelliJ IDEA.
  Author: Xy Zhang
  Date: 2020 2020/11/6
  Time: 11:11
*/


import lombok.experimental.Accessors;

import java.io.Serializable;

//@Data
//@NoArgsConstructor
@Accessors(chain = true)//链式写法
//Dept 实体类 ， orm类表关系映射
public class Dept implements Serializable {

    private long deptNo;//主键

    private String dName;

    public Dept(){}

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public long getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(long deptNo) {
        this.deptNo = deptNo;
    }

    public String getDb_source() {
        return db_source;
    }

    public void setDb_source(String db_source) {
        this.db_source = db_source;
    }

    //这个数据库是在哪个数据库的字段 微服务架构一个服务可以对应一个数据库，同一个信息可能存在不同的数据库
    private String db_source;


    public Dept(String dName) {
        this.dName = dName;
    }

    /**
     * 链式写法
     * Dept dept = new Dept();
     * dept.setDName("XXX").setDeptNo(11).setDb_source(123);
     */
}
