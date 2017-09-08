package com._520it.crm.web.controller;

import com._520it.crm.domain.Dictionary;
import com._520it.crm.domain.DictionaryItem;
import com._520it.crm.domain.Employee;
import com._520it.crm.service.IDictionaryItemService;
import com._520it.crm.service.IDictionaryService;
import com._520it.crm.util.AjaxResult;
import com._520it.crm.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DictionaryController {

	@Autowired
	private IDictionaryService service;
	@Autowired
	private IDictionaryItemService itemService;



	@RequestMapping("/dictionary")
	public  String index(){
		return "dictionary";
	}

	@RequestMapping("/dictionary_list")
	@ResponseBody
	public List<Dictionary> list(){
		return service.selectAll();
	}

	@RequestMapping("/dictionary_save")
	@ResponseBody
	@RequiresPermissions("dictionary:save")
	@PermissionName("目录字典新增")
	public AjaxResult save(Dictionary dictionary){
		try{
			service.insert(dictionary);
			return new AjaxResult(true,"保存成功!");
		}catch(Exception e){
			e.printStackTrace();
		}
		return new AjaxResult(false,"保存失败!");
	}
	@RequestMapping("/dictionary_update")
	@ResponseBody
	@RequiresPermissions("dictionary:update")
	@PermissionName("目录字典新增")
	public AjaxResult update(Dictionary dictionary){
		try{
			service.updateByPrimaryKey(dictionary);
			return new AjaxResult(true,"更新成功!");
		}catch(Exception e){
			e.printStackTrace();
		}
		return new AjaxResult(false,"更新失败!");
	}

	@RequestMapping("/dictionaryItem_list")
	@ResponseBody
	public List<DictionaryItem> listItem(Long  pid) {
		if (pid != null) {
			return itemService.selectItem(pid);
		}
		return null;
	}

	@RequestMapping("/dictionaryItem_save")
	@ResponseBody
	@RequiresPermissions("dictionaryItem:save")
	@PermissionName("目录字典明细新增")
	public AjaxResult saveItem(DictionaryItem dictionaryItem){
		try{
			itemService.insert(dictionaryItem);
			return new AjaxResult(true,"保存成功!");
		}catch(Exception e){
			e.printStackTrace();
		}
		return new AjaxResult(false,"保存失败!");
	}
	@RequestMapping("/dictionaryItem_update")
	@ResponseBody
	@RequiresPermissions("dictionaryItem:update")
	@PermissionName("目录字典明细更新")
	public AjaxResult updateItem(DictionaryItem dictionaryItem){
		try{
			itemService.updateByPrimaryKey(dictionaryItem);
			return new AjaxResult(true,"更新成功!");
		}catch(Exception e){
			e.printStackTrace();
		}
		return new AjaxResult(false,"更新失败!");
	}
	@RequestMapping("/dictionaryItem_delete")
	@ResponseBody
	@RequiresPermissions("dictionaryItem:delete")
	@PermissionName("目录字典明细删除")
	public AjaxResult deleteItem(Long delId){
		try{
			itemService.deleteByPrimaryKey(delId);
			return new AjaxResult(true,"删除成功!");
		}catch(Exception e){
			e.printStackTrace();
		}
		return new AjaxResult(false,"删除失败!");
	}


}
