package com._520it.crm.web.controller;

import com._520it.crm.domain.Outindepot;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.OutindepotQuery;
import com._520it.crm.service.IOutindepotService;
import com._520it.crm.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OutindepotController extends BaseController {
    @Autowired
    private IOutindepotService outindepotService;

    @RequestMapping("/outindepot")
    public String index(){
        return "outindepot";
    }

    @RequestMapping("/outindepot_list")
    @ResponseBody
    public PageResult list(OutindepotQuery qo){
        return outindepotService.queryPageResult(qo);
    }

    @RequestMapping("/outindepot_save")
    @ResponseBody
    public AjaxResult save(Outindepot outindepot){
        try {
            outindepotService.insert(outindepot);
            return new AjaxResult(true,"保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(false,"保存失败");
        }
    }

    @RequestMapping("/outindepot_update")
    @ResponseBody
    public AjaxResult update(Outindepot outindepot){
        try {
            //System.out.println(outindepot.getId());
            outindepotService.updateByPrimaryKey(outindepot);
            return new AjaxResult(true,"编辑成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(false,"编辑失败");
        }
    }

    @RequestMapping("/outindepot_delete")
    @ResponseBody
    public AjaxResult delete(Long id){
        try {
            //System.out.println(outindepot.getId());
            outindepotService.deleteByPrimaryKey(id);
            return new AjaxResult(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(false,"删除失败");
        }
    }
}
