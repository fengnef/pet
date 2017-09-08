package com._520it.crm.web.controller;

import com._520it.crm.domain.Brand;
import com._520it.crm.domain.ProductPomponent;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ProductPomponentQuery;
import com._520it.crm.service.IProductPomponentService;
import com._520it.crm.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductPomponentController {
    @Autowired
    private IProductPomponentService service;

    @RequestMapping("/productPomponent")
    public String index(){
        return "productPomponent";
    }

    @RequestMapping("/productPomponent_list")
    @ResponseBody
    public PageResult list(ProductPomponentQuery qo) {
        return service.queryPageResult(qo);

    }

    @RequestMapping("/productPomponent_listall")
    @ResponseBody
    public List<ProductPomponent> select(){
        return service.selectAll();
    }


    @RequestMapping("/productPomponent_save")
    @ResponseBody
    public AjaxResult save(ProductPomponent productPomponent){
        try {
            service.insert(productPomponent);
            return new AjaxResult(true,"保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(false,"保存失败");
        }
    }


    @RequestMapping("/productPomponent_update")
    @ResponseBody
    public AjaxResult update(ProductPomponent productPomponent){
        try {
            //System.out.println(brand.getId());
            service.updateByPrimaryKey(productPomponent);
            return new AjaxResult(true,"编辑成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(false,"编辑失败");
        }
    }

    @RequestMapping("/productPomponent_delete")
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
