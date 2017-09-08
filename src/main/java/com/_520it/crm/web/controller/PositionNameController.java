package com._520it.crm.web.controller;

import com._520it.crm.domain.PositionName;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.service.IPositionNameService;
import com._520it.crm.util.AjaxResult;
import com._520it.crm.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2017/8/26.
 */
@Controller
public class PositionNameController {
    @Autowired
    private IPositionNameService service;
    //职位页面
    @RequestMapping("/positionName")
    @RequiresPermissions("positionName:view")
    @PermissionName("职位首页")
    public String index(){
        return "positionName";
    }



    @RequestMapping("/positionName_list")
    @ResponseBody
    //@RequiresPermissions("positionName:list")
    //@PermissionName("职位列表")
    public PageResult list(QueryObject qo){

        return service.queryPageResult(qo);
    }

    @RequestMapping("/positionName_listAll")
    @ResponseBody
    public List<PositionName> list1(){

        return service.selectAll();
    }





    @RequestMapping("/positionName_save")
    @ResponseBody
    //@RequiresPermissions("employee:save")
    //@PermissionName("新增员工")
    public AjaxResult save(PositionName positionName){

        try{
            service.insert(positionName);
            return new AjaxResult(true,"保存成功!");
        }catch(Exception e){
            e.printStackTrace();
        }
        return new AjaxResult(false,"保存失败!");
    }
    @RequestMapping("/positionName_update")
    @ResponseBody
   // @PermissionName("更新员工")
    //@RequiresPermissions("employee:update")
    public AjaxResult update(PositionName positionName){
        try{
            service.updateByPrimaryKey(positionName);
            return new AjaxResult(true,"更新成功!");
        }catch(Exception e){
            e.printStackTrace();
        }
        return new AjaxResult(false,"更新失败!");
    }
    @RequestMapping("/positionName_delete")
    @ResponseBody
   // @PermissionName("更新员工")
    //@RequiresPermissions("employee:update")
    public AjaxResult delete(Long id){
        try{
            service.deleteByPrimaryKey(id);
            return new AjaxResult(true,"删除成功!");
        }catch(Exception e){
            e.printStackTrace();
        }
        return new AjaxResult(false,"删除失败!");
    }

}
