package com.itheima.dao;

import com.itheima.pojo.CheckGroup;

import java.util.Map;

public interface CheckGroupDao {
    void add(CheckGroup checkGroup);
    void setCheckGroupAndCheckItem(Map map);
}
