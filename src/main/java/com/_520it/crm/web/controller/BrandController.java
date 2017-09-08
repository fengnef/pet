package com._520it.crm.web.controller;

import com._520it.crm.domain.Brand;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.BrandQuery;
import com._520it.crm.service.IBrandService;
import com._520it.crm.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BrandController extends BaseController {
    @Autowired
    private IBrandService brandService;

    @RequestMapping("/brand")
    public String index(){
        return "brand";
    }

    @RequestMapping("/brand_list")
    @ResponseBody
    public PageResult list(BrandQuery qo){
        return brandService.queryPageResult(qo);
    }

    @RequestMapping("/brand_listall")
    @ResponseBody
    public List<Brand> select(){
        return brandService.selectAll();
    }


    @RequestMapping("/brand_save")
    @ResponseBody
    public AjaxResult save(Brand brand){
        try {
            brandService.insert(brand);
            return new AjaxResult(true,"保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(false,"保存失败");
        }
    }

    @RequestMapping("/brand_update")
    @ResponseBody
    public AjaxResult update(Brand brand){
        try {
            //System.out.println(brand.getId());
            brandService.updateByPrimaryKey(brand);
            return new AjaxResult(true,"编辑成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(false,"编辑失败");
        }
    }

    @RequestMapping("/brand_delete")
    @ResponseBody
    public AjaxResult delete(Long id){
        try {
            //System.out.println(brand.getId());
            brandService.deleteByPrimaryKey(id);
            return new AjaxResult(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(false,"删除失败");
        }
    }
}
