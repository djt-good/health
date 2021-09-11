package com.itheima.service;

import com.itheima.constant.QueryPageBean;
import com.itheima.entity.PageResult;
import com.itheima.pojo.Setmeal;

public interface SetmealService {
    public void add(Setmeal setmeal, Integer[] checkgroupIds);

    PageResult findpage(QueryPageBean queryPageBean);
}
