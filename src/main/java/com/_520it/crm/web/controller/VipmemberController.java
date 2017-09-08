package com._520it.crm.web.controller;

import com._520it.crm.domain.Brand;
import com._520it.crm.domain.Vipmember;
import com._520it.crm.mapper.VipmemberMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.VipmemberQuery;
import com._520it.crm.service.IVipmemberService;
import com._520it.crm.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VipmemberController {
    @Autowired
    private IVipmemberService service;

    @RequestMapping("/vipmember")
    public String index(){
        return "vipmember";
    }

    @RequestMapping("/vipmember_list")
    @ResponseBody
    public PageResult list(VipmemberQuery qo){
        return service.queryPageResult(qo);
    }

    @RequestMapping("/vipmember_save")
    @ResponseBody
    public AjaxResult save(Vipmember vipmember){
        try {
            service.insert(vipmember);
            return new AjaxResult(true,"保存成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AjaxResult(false,"保存失败");
    }

    @RequestMapping("/vipmember_update")
    @ResponseBody
    public AjaxResult update(Vipmember vipmember){
        try {
            //System.out.println(brand.getId());
            service.updateByPrimaryKey(vipmember);
            return new AjaxResult(true,"编辑成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(false,"编辑失败");
        }
    }

    @RequestMapping("/vipmember_delete")
    @ResponseBody
    public AjaxResult delete(Long id){
        try {
            //System.out.println(brand.getId());
            service.deleteByPrimaryKey(id);
            return new AjaxResult(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(false,"删除失败");
        }
    }
}
