package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.pojo.CheckItem;

public interface CheckItemDao {
    public void add(CheckItem checkItem);
    Page<CheckItem> selectBycondiction(String queryString);
    long selectBychectimId(Integer id);
    void  deleteBychectimId(Integer id);
    CheckItem findByid(Integer id);
    public void edit(CheckItem checkItem);
}
