package com._520it.crm.web.controller;

import com._520it.crm.page.PageResult;
import com._520it.crm.query.SystemlogQuery;
import com._520it.crm.service.ISystemlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SystemlogController {
    @Autowired
    private ISystemlogService systemlogService;

    @RequestMapping("/systemlog")
    public String index(){
        return "systemlog";
    }

    @RequestMapping("/systemlog_list")
    @ResponseBody
    public PageResult list(SystemlogQuery qo){
        return systemlogService.queryPageResult(qo);
    }
}
