package com._520it.crm.web.controller;

import com._520it.crm.domain.Supplier;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.SupplierQuery;
import com._520it.crm.service.ISupplierService;
import com._520it.crm.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SupplierController extends BaseController {
    @Autowired
    private ISupplierService supplierService;

    @RequestMapping("/supplier")
    public String index(){
        return "supplier";
    }

    @RequestMapping("/supplier_list")
    @ResponseBody
    public PageResult list(SupplierQuery qo){
        return supplierService.queryPageResult(qo);
    }

    @RequestMapping("/supplier_save")
    @ResponseBody
    public AjaxResult save(Supplier supplier){
        try {
            supplierService.insert(supplier);
            return new AjaxResult(true,"保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(false,"保存失败");
        }
    }

    @RequestMapping("/supplier_update")
    @ResponseBody
    public AjaxResult update(Supplier supplier){
        try {
            //System.out.println(supplier.getId());
            supplierService.updateByPrimaryKey(supplier);
            return new AjaxResult(true,"编辑成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(false,"编辑失败");
        }
    }

    @RequestMapping("/supplier_delete")
    @ResponseBody
    public AjaxResult delete(Long id){
        try {
            //System.out.println(supplier.getId());
            supplierService.deleteByPrimaryKey(id);
            return new AjaxResult(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(false,"删除失败");
        }
    }
}
