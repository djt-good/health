package com.itheima.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.constant.QueryPageBean;
import com.itheima.dao.CheckGroupDao;
import com.itheima.entity.PageResult;
import com.itheima.pojo.CheckGroup;
import com.itheima.service.CheckGroupService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(interfaceClass = CheckGroupService.class)
//@Transactional、、
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

    @Override
    public PageResult findpage(QueryPageBean queryPageBean) {
//        private Integer currentPage;//页码
//        private Integer pageSize;//每页记录数
//        private String queryString;//查询条件
        Integer currentPage1 = queryPageBean.getCurrentPage();
        Integer pageSize1 = queryPageBean.getPageSize();
        String queryString1 = queryPageBean.getQueryString();
        PageHelper.startPage(currentPage1,pageSize1);
        Page<CheckGroup> checkGroups = checkGroupDao.selectBycondiction(queryString1);
        return new PageResult(checkGroups.getTotal(),checkGroups.getResult());
    }

    @Override
    public CheckGroup findByid(Integer id) {
        CheckGroup byid = checkGroupDao.findByid(id);
        return byid;
    }

    @Override
    public List<Integer> findcheckids(Integer id) {
        List<Integer> findcheckids = checkGroupDao.findcheckids(id);
        return findcheckids;
    }

    @Override
    public void edit(CheckGroup checkGroup, Integer[] checkitemIds) {
        Integer checkGroupId = checkGroup.getId();
        checkGroupDao.deleteAssociation(checkGroupId);
        if (checkitemIds != null && checkitemIds.length > 0) {
            for (Integer checkid : checkitemIds) {
                Map<String, Integer> map = new HashMap<>();
                map.put("checkgroup_id", checkGroupId);
                map.put("checkitem_id", checkid);
                checkGroupDao.setCheckGroupAndCheckItem(map);
                checkGroupDao.edit(checkGroup);

            }
        }
        checkGroupDao.edit(checkGroup);
    }

    @Override
    public void delete(Integer id) {
        checkGroupDao.delete(id);
        checkGroupDao.deleteAssociation(id);


    }
}