package com.itheima.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.itheima.dao.CheckGroupDao;
import com.itheima.pojo.CheckGroup;
import com.itheima.service.CheckGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service(interfaceClass = CheckGroupService.class)
//@Transactional
public class CheckGroupServiceImpl implements CheckGroupService {
    @Autowired
    CheckGroupDao checkGroupDao;
    @Override
    public void add(CheckGroup checkGroup, Integer[] checkitemIds) {
               checkGroupDao.add(checkGroup);
        Integer groupid = checkGroup.getId();
        System.out.println(groupid);
        if (checkitemIds !=null && checkitemIds.length >0){
            for (Integer checkid : checkitemIds){
                Map<String,Integer> map = new HashMap<>();
                map.put("checkgroup_id",groupid);
                map.put("checkitem_id",checkid);
                checkGroupDao.setCheckGroupAndCheckItem(map);
            }
        }
    }
}
