package com._520it.crm.web.controller;

import com._520it.crm.domain.Brand;
import com._520it.crm.domain.ProductCategory;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ProductCategoryQuery;
import com._520it.crm.service.IProductCategoryService;
import com._520it.crm.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductCategoryController {
    @Autowired
    private IProductCategoryService service;

    @RequestMapping("/productCategory")
    public String index(){
        return "productCategory";
    }

    @RequestMapping("/productCategory_list")
    @ResponseBody
    public PageResult list(ProductCategoryQuery qo) {
        return service.queryPageResult(qo);
    }

    @RequestMapping("/productCategory_listall")
    @ResponseBody
    public List<ProductCategory> select(){
        return service.selectAll();
    }

    @RequestMapping("/productCategory_save")
    @ResponseBody
    public AjaxResult save(ProductCategory productCategory){
        try {
            service.insert(productCategory);
            return new AjaxResult(true,"保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(false,"保存失败");
        }
    }


    @RequestMapping("/productCategory_update")
    @ResponseBody
    public AjaxResult update(ProductCategory productCategory){
        try {
            service.updateByPrimaryKey(productCategory);
            return new AjaxResult(true,"编辑成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(false,"编辑失败");
        }
    }

    @RequestMapping("/productCategory_delete")
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
