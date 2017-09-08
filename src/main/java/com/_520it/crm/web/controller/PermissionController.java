package com._520it.crm.web.controller;

import java.util.List;

import com._520it.crm.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.Permission;
import com._520it.crm.service.IPermissionService;

@Controller
public class PermissionController {

	@Autowired
	private IPermissionService service;

	@RequestMapping("/permission_listAll")
	@ResponseBody
	public List<Permission> listAll(){
		return service.selectAll();
	}

	@RequestMapping("/getPermissionsByRoleId")
	@ResponseBody
	public List<Permission> getPermissionsByRoleId(Long rid){
		return service.getPermissionsByRoleId(rid);
	}

	@RequestMapping("/loadPermission")
	@ResponseBody
	public AjaxResult load(){
		try{
			service.load();
			return new AjaxResult(true,"加载成功!");
		}catch(Exception e){
			e.printStackTrace();
		}
		return new AjaxResult(false,"加载失败!");
	}


}
