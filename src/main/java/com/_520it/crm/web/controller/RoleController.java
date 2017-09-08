package com._520it.crm.web.controller;

import java.util.List;

import com._520it.crm.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.Role;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.service.IRoleService;
import com._520it.crm.util.AjaxResult;

@Controller
public class RoleController {

	@Autowired
	private IRoleService service;

	@RequestMapping("/role")
	@RequiresPermissions("role:view")
	@PermissionName("角色首页")
	public String index(){
		return "role";
	}

	@RequestMapping("/role_save")
	@ResponseBody
	public AjaxResult save(Role role){
		try{
			service.insert(role);
			return new AjaxResult(true,"保存成功!");
		}catch(Exception e){
			e.printStackTrace();
		}
		return new AjaxResult(false,"保存失败!");
	}

	@RequestMapping("/role_list")
	@ResponseBody
	public PageResult list(QueryObject qo){
		return service.queryPageResult(qo);
	}
	@RequestMapping("/role_listAll")
	@ResponseBody
	public List<Role> selectAll( ){
		return service.selectAll();
	}

	@RequestMapping("/role_update")
	@ResponseBody
	public AjaxResult update(Role role){
		try{
			service.updateByPrimaryKey(role);
			return new AjaxResult(true,"更新成功!");
		}catch(Exception e){
			e.printStackTrace();
		}
		return new AjaxResult(false,"更新失败!");
	}

	@RequestMapping("/getRolesIdByShopkeeperId")
	@ResponseBody
	public List<Long> getRolesIdByShopkeeperId(Long shopkeeperId) {
		return service.getRolesIdByShopkeeperId(shopkeeperId);
	}


	//编辑查询对应的用户拥有的角色
	@RequestMapping("/getRoleByshopkeeperId")
	@ResponseBody
	public List<Role> getRoleIdByShopkeeperId(Long shopkeeperId) {
		return service.getRoleByShopkeeperId(shopkeeperId);
	}












}
