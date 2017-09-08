package com._520it.crm.web.controller;

import com._520it.crm.domain.Product;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ProductQuery;
import com._520it.crm.service.IProductService;
import com._520it.crm.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @RequestMapping("/product")
    public String index(){
        return "product";
    }
    
    @RequestMapping("/product_list")
    @ResponseBody
    public PageResult list(ProductQuery qo){
        return productService.queryPageResult(qo);
    }

    @RequestMapping("/product_save")
    @ResponseBody
    public AjaxResult save(Product product){
        try {
            productService.insert(product);
            return new AjaxResult(true,"保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(false,"保存失败");
        }
    }

    @RequestMapping("/product_update")
    @ResponseBody
    public AjaxResult update(Product product){
        try {
            //System.out.println(product.getId());
            productService.updateByPrimaryKey(product);
            return new AjaxResult(true,"编辑成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(false,"编辑失败");
        }
    }

    @RequestMapping("/product_delete")
    @ResponseBody
    public AjaxResult delete(Long id){
        try {
            //System.out.println(product.getId());
            productService.deleteByPrimaryKey(id);
            return new AjaxResult(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(false,"删除失败");
        }
    }
    
}
