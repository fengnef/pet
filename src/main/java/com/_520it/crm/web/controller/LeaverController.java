package com._520it.crm.web.controller;



import com._520it.crm.domain.Employee;
import com._520it.crm.domain.Leaver;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.EmployeeQuery;
import com._520it.crm.service.ILeaverService;
import com._520it.crm.util.AjaxResult;
import com._520it.crm.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LeaverController {
    @Autowired
    private ILeaverService service;
    @RequestMapping("/leaver")
    public String index(){
        return "leaver";
    }

    @RequestMapping("/leaver_list")
    @ResponseBody
    public PageResult list(EmployeeQuery qo){
        return service.queryPageResult(qo);
    }

    @RequestMapping("/leaver_save")
    @ResponseBody
   // @RequiresPermissions("leaver:save")
    //@PermissionName("新增员工")
    public AjaxResult save(Leaver leaver){
        leaver.setState(true);
        try{
            service.insert(leaver);
            return new AjaxResult(true,"保存成功!");
        }catch(Exception e){
            e.printStackTrace();
        }
        return new AjaxResult(false,"保存失败!");
    }

    @RequestMapping("/leaver_update")
    @ResponseBody
   // @PermissionName("取消请假")
    //@RequiresPermissions("employee:update")
    public AjaxResult update(Leaver leaver){
       leaver.setState(false);
        try{
            service.updateByPrimaryKey(leaver);
            return new AjaxResult(true,"更新成功!");
        }catch(Exception e){
            e.printStackTrace();
        }
        return new AjaxResult(false,"更新失败!");
    }

}
