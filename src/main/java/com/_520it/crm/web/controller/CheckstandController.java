package com._520it.crm.web.controller;

import com._520it.crm.domain.Product;
import com._520it.crm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CheckstandController extends BaseController{

	@Autowired
	private IProductService service;

	@RequestMapping("/checkstand")
	//@RequiresPermissions("employee:view")
	//@PermissionName("员工主页")
	public String index(){
		return "checkstand";
	}

	@RequestMapping("/checkstand_listAll")
	//@RequiresPermissions("employee:view")
	//@PermissionName("员工主页")
	@ResponseBody
	public List<Product> list(String sn){
        List<Product> list = service.selectCheckstand(sn);
        return list;
	}

}
