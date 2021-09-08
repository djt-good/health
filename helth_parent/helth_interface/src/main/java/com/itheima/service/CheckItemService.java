package com.itheima.service;

import com.github.pagehelper.Page;
import com.itheima.entity.PageResult;
import com.itheima.pojo.CheckItem;

import java.util.List;

public interface CheckItemService {

  public void add(CheckItem checkItem);
  public PageResult pageQuery(Integer currentPage,Integer pageSize,
                        String queryString);

  public   void delete(Integer id);

  CheckItem findByid(Integer id);

  void edit(CheckItem checkItem);

    List<CheckItem> finAll();
}
