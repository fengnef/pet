package com._520it.crm.web.controller;

import com._520it.crm.domain.Employee;
import com._520it.crm.domain.Shopkeeper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.EmployeeQuery;
import com._520it.crm.query.QueryObject;
import com._520it.crm.query.ShopkeeperQuery;
import com._520it.crm.service.IShopkeeperService;
import com._520it.crm.util.AjaxResult;
import com._520it.crm.util.PermissionName;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class ShopkeeperController {
    @Autowired
    private IShopkeeperService shopkeeperService;

    @RequestMapping("/principalSheet")
    @PermissionName("店铺主页面")
    public String shopkeeper() {
        return "principalSheet";
    }


    @RequestMapping("/show_Sheet")
    @PermissionName("店铺主页面")
    @ResponseBody
    public Shopkeeper showSheet() {
//        显示店铺的数据
        Subject subject = SecurityUtils.getSubject();
        Shopkeeper principal = (Shopkeeper) subject.getPrincipal();
        Shopkeeper shopkeeper = shopkeeperService.selectByPrimaryKey(principal.getId());
        return shopkeeper;
    }
    @RequestMapping("/update_Sheet")
    @PermissionName("店主更新自己店铺功能")
    @ResponseBody
    public AjaxResult updateSheet(Shopkeeper shop) {
//        店主店铺的更新
        try {
            shopkeeperService.updateSheet(shop);
            return new AjaxResult(true, "保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AjaxResult(false, "保存失败!");

    }


    @RequestMapping("/shopkeeper")
    @RequiresPermissions("shopkeeper:view")
    @PermissionName("登录用户管理")
    public String index() {
        return "shopkeeper";
    }


    @RequestMapping("/shopkeeper_save")
    @ResponseBody
    public AjaxResult save(Shopkeeper shop) {
//        店铺注册
        try {
            shop.setSetuptime(new Date());
            shop.setAdmin(true);
            shopkeeperService.insert(shop);
            return new AjaxResult(true, "保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AjaxResult(false, "保存失败!");
    }



    @RequestMapping("/shopkeeper_list")
    @ResponseBody
    @RequiresPermissions("shopkeeper:list")
    @PermissionName("用户列表")
    public PageResult list(ShopkeeperQuery qo) {
        Subject subject = SecurityUtils.getSubject();
        Shopkeeper shopkeeper = (Shopkeeper) subject.getPrincipal();
        //数据权限控制
        //如果是经理则可以查询所有数据
        if (!subject.hasRole("admin")) {
            //如果不是,则只能查询自己的数据
            qo.setId(shopkeeper.getId());
        }
        return shopkeeperService.queryPageResult(qo);
    }


    @RequestMapping("/shopkeeper_save1")
    @ResponseBody
    public AjaxResult saveShopkeeper(Shopkeeper shop) {
        shop.setSetuptime(new Date());
        //登录账号新增
        try {
            shopkeeperService.insertShopeekerRole(shop);
            return new AjaxResult(true, "保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AjaxResult(false, "保存失败!");
    }

    @RequestMapping("/shopkeeper_update")
    @ResponseBody
    public AjaxResult update(Shopkeeper shop) {
        //登录账号修改
        try {
            shopkeeperService.update(shop);
            return new AjaxResult(true, "更新成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AjaxResult(false, "更新失败!");
    }

}
