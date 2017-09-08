package com._520it.crm.web.controller;

import com._520it.crm.domain.Specification;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.SpecificationQuery;
import com._520it.crm.service.ISpecificationService;
import com._520it.crm.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SpecificationController extends BaseController {
    @Autowired
    private ISpecificationService specificationService;

    @RequestMapping("/specification")
    public String index(){
        return "specification";
    }

    @RequestMapping("/specification_list")
    @ResponseBody
    public PageResult list(SpecificationQuery qo){
        return specificationService.queryPageResult(qo);
    }

    @RequestMapping("/specification_save")
    @ResponseBody
    public AjaxResult save(Specification specification){
        try {
            specificationService.insert(specification);
            return new AjaxResult(true,"保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(false,"保存失败");
        }
    }
}
