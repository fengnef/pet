package com._520it.crm.web.controller;

import com._520it.crm.domain.Petkindandcategory;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.PetkindandcategoryQuery;
import com._520it.crm.service.IPetkindandcategoryService;
import com._520it.crm.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PetkindandcategoryController extends BaseController {
    @Autowired
    private IPetkindandcategoryService service;

    @RequestMapping("/petkindandcategory")
    public String index(){
        return "petkindandcategory";
    }

    @RequestMapping("/petkindandcategory_list")
    @ResponseBody
    public PageResult list(PetkindandcategoryQuery qo){
        return service.queryPageResult(qo);
    }

    @RequestMapping("/petkindandcategory_listall")
    @ResponseBody
    public List<Petkindandcategory> select(){
        return service.selectAll();
    }


    @RequestMapping("/petkindandcategory_save")
    @ResponseBody
    public AjaxResult save(Petkindandcategory pet){
        try {
            service.insert(pet);
            return new AjaxResult(true,"保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(false,"保存失败");
        }
    }

    @RequestMapping("/petkindandcategory_update")
    @ResponseBody
    public AjaxResult update(Petkindandcategory pet){
        try {
            //System.out.println(petkindandcategory.getId());
            service.updateByPrimaryKey(pet);
            return new AjaxResult(true,"编辑成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(false,"编辑失败");
        }
    }

    @RequestMapping("/petkindandcategory_delete")
    @ResponseBody
    public AjaxResult delete(Long id){
        try {
            //System.out.println(petkindandcategory.getId());
            service.deleteByPrimaryKey(id);
            return new AjaxResult(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(false,"删除失败");
        }
    }
}
