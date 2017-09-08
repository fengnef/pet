package com._520it.crm.web.controller;

import com._520it.crm.page.PageResult;
import com._520it.crm.query.CheckstandRecordQuery;
import com._520it.crm.service.ICheckstandRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CheckstandRecordController extends BaseController{

	@Autowired
	private ICheckstandRecordService service;

	@RequestMapping("/checkstandRecord")
	//@RequiresPermissions("employee:view")
	//@PermissionName("员工主页")
	public String index(){
		return "checkstandRecord";
	}


	@RequestMapping("/checkstandRecord_listAll")
	@ResponseBody
	public PageResult list(CheckstandRecordQuery qo){
		return service.queryPageResult(qo);
	}
}
