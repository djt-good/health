package com.itheima.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.Page;
import com.itheima.constant.MessageConstant;
import com.itheima.constant.QueryPageBean;
import com.itheima.entity.PageResult;
import com.itheima.entity.Result;
import com.itheima.pojo.CheckGroup;
import com.itheima.service.CheckGroupService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/checkgroup")
public class CheckGroupController {
    @Reference
    CheckGroupService checkGroupService;
    @RequestMapping("/add")
    public Result add(@RequestBody CheckGroup checkGroup, Integer [] checkitemIds){
        try {
            checkGroupService.add(checkGroup,checkitemIds);
        }catch (Exception e){
            //新增失败
            return new Result(false, MessageConstant.ADD_CHECKGROUP_FAIL);
        }
        //新增成功
        return new Result(true, MessageConstant.ADD_CHECKGROUP_SUCCESS);
    }
     @RequestMapping("/findpage")
    public PageResult findpage(@RequestBody QueryPageBean queryPageBean){
         PageResult findpage = checkGroupService.findpage(queryPageBean);
         return findpage;
     }
     @RequestMapping("/findByid")
    public Result findByid(Integer id){
         CheckGroup checkGroup = checkGroupService.findByid(id);
         if (checkGroup != null){
             Result result = new Result(true, MessageConstant.QUERY_CHECKGROUP_SUCCESS);
             result.setData(checkGroup);
             return result;
         }
         return new Result(false,MessageConstant.QUERY_CHECKGROUP_FAIL);
     }
    @RequestMapping("/findCheckItemIdsByCheckGroupId")
    public Result findcheckids(Integer id){
        try {
            List<Integer> checkitemIds = checkGroupService.findcheckids(id);

            Result result = new Result(true, MessageConstant.QUERY_CHECKITEM_SUCCESS, checkitemIds);
                          result.setData(checkitemIds);
                          return result;
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_CHECKITEM_FAIL);
        }
        }

    @RequestMapping("/edit")
    public Result edit(@RequestBody CheckGroup checkGroup,Integer[] checkitemIds){
        try {
            checkGroupService.edit(checkGroup,checkitemIds);
        }catch (Exception e){
            return new Result(false,MessageConstant.EDIT_CHECKGROUP_FAIL);
        }
            return new Result(true,MessageConstant.EDIT_CHECKGROUP_SUCCESS);
    }
    @RequestMapping("/delete")
    public Result delete(Integer id){

            checkGroupService.delete(id);

        return new Result(true,MessageConstant.DELETE_CHECKGROUP_SUCCESS);
    }
    @RequestMapping("/finAll")
    public Result finAll(){
        List<CheckGroup> all;
        try {
            all = checkGroupService.findAll();
        }catch (Exception e){
            return new Result(false,MessageConstant.QUERY_CHECKGROUP_FAIL);
        }
        return new Result(true,MessageConstant.QUERY_CHECKGROUP_SUCCESS,all);
    }
}

