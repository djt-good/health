package com.itheima.service;

import com.github.pagehelper.Page;
import com.itheima.constant.QueryPageBean;
import com.itheima.entity.PageResult;
import com.itheima.pojo.CheckGroup;

import java.util.List;

public interface CheckGroupService {
    void add(CheckGroup checkGroup, Integer[] checkitemIds);

    PageResult findpage(QueryPageBean queryPageBean);

    CheckGroup findByid(Integer id);

   List<Integer> findcheckids(Integer id);

    void edit(CheckGroup checkGroup, Integer[] checkitemIds);

    void delete(Integer id);

    List<CheckGroup> findAll();

}
