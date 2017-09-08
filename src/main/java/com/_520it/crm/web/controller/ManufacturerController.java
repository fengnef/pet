package com._520it.crm.web.controller;

import com._520it.crm.domain.Brand;
import com._520it.crm.domain.Manufacturer;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ManufacturerQuery;
import com._520it.crm.service.IManufacturerService;
import com._520it.crm.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ManufacturerController {
    @Autowired
    private IManufacturerService manufacturerService;

    @RequestMapping("/manufacturer")
    public String index(){
        return "manufacturer";
    }

    @RequestMapping("/manufacturer_list")
    @ResponseBody
    public PageResult list(ManufacturerQuery qo){
        return manufacturerService.queryPageResult(qo);
    }

    @RequestMapping("/manufacturer_listall")
    @ResponseBody
    public List<Manufacturer> select(){
        return manufacturerService.selectAll();
    }

    @RequestMapping("/manufacturer_save")
    @ResponseBody
    public AjaxResult save(Manufacturer manu){
        try {
            manufacturerService.insert(manu);
            return new AjaxResult(true,"保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(false,"保存失败");
        }
    }

    @RequestMapping("/manufacturer_update")
    @ResponseBody
    public AjaxResult update(Manufacturer manu){
        try {
            //System.out.println(brand.getId());
            manufacturerService.updateByPrimaryKey(manu);
            return new AjaxResult(true,"编辑成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(false,"编辑失败");
        }
    }

    @RequestMapping("/manufacturer_delete")
    @ResponseBody
    public AjaxResult delete(Long id){
        try {
            //System.out.println(brand.getId());
            manufacturerService.deleteByPrimaryKey(id);
            return new AjaxResult(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(false,"删除失败");
        }
    }
}
