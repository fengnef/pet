package com._520it.crm.web.controller;

import com._520it.crm.domain.Serviceitem;
import com._520it.crm.service.IServiceitemService;
import com._520it.crm.util.AjaxResult;
import com._520it.crm.util.PermissionName;
import com._520it.crm.vo.ServiceStatusVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ServiceitemController extends BaseController {

    @Autowired
    private IServiceitemService service;

    @RequestMapping("/serviceitem_list")
    @ResponseBody
    @PermissionName("服务项目")
    public List<Object> list() {
        return service.getServiceitemRoot();
    }

    @RequestMapping("/serviceitem_status")
    @ResponseBody
    public List<ServiceStatusVo> serviceitemStatus() {
        List<ServiceStatusVo> list = new ArrayList<>();
        ServiceStatusVo sv1 = new ServiceStatusVo("","所有");
        ServiceStatusVo sv2 = new ServiceStatusVo("等待中","等待中");
        ServiceStatusVo sv3 = new ServiceStatusVo("进行中","进行中");
        ServiceStatusVo sv4 = new ServiceStatusVo("已结束","已结束");
        ServiceStatusVo sv5 = new ServiceStatusVo("未付款","未付款");
        list.add(sv1);
        list.add(sv2);
        list.add(sv3);
        list.add(sv4);
        list.add(sv5);
        return list;
    }

    @RequestMapping("/getServiceitemRootId")
    @ResponseBody
    @PermissionName("服务项目")
    public List<Long> getServiceitemRootId() {
        return service.getServiceitemRootId();
    }

    @RequestMapping("/serviceitem_save")
    @ResponseBody
    public AjaxResult save(Serviceitem item) {
        item.setServicestatus("等待中");
        try {
            service.insert(item);
            return new AjaxResult(true, "保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AjaxResult(false, "保存失败!");
    }
    @RequestMapping("/serviceitem_changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(Long statusId) {
        try {
            Serviceitem s = service.selectByItemId(statusId);
            s.setServicestatus("进行中");
            service.updateByPrimaryKey(s);
            return new AjaxResult(true, "主人,正在进行中,请耐心等待!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AjaxResult(false, "保存失败!");
    }
    @RequestMapping("/serviceitem_endStatus")
    @ResponseBody
    public AjaxResult endStatus(Long statusId) {
        try {
            Serviceitem s = service.selectByItemId(statusId);
            s.setServicestatus("已结束");
            service.updateByPrimaryKey(s);
            return new AjaxResult(true, "主人,已经服务完毕,欢迎再次光临!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AjaxResult(false, "保存失败!");
    }
    @RequestMapping("/serviceitem_cancelStatus")
    @ResponseBody
    public AjaxResult cancelStatus(Long statusId) {
        try {
            Serviceitem s = service.selectByItemId(statusId);
            s.setServicestatus("已取消");
            service.updateByPrimaryKey(s);
            return new AjaxResult(true, "主人,已为您取消服务!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AjaxResult(false, "保存失败!");
    }

}
