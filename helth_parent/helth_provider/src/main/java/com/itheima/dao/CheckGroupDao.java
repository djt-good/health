package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.pojo.CheckGroup;
import com.itheima.pojo.CheckItem;

import java.util.List;
import java.util.Map;

public interface CheckGroupDao {
    void add(CheckGroup checkGroup);
    void setCheckGroupAndCheckItem(Map map);
    Page<CheckGroup> selectBycondiction(String queryString);
    CheckGroup findByid(Integer id);

    List<Integer> findcheckids(Integer id);

    void deleteAssociation(Integer id);
    void edit(CheckGroup checkGroup);
    void  delete(Integer id);
}
