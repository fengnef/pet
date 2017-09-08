package com._520it.crm.web.controller;

import com._520it.crm.domain.Category;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.CategoryQuery;
import com._520it.crm.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CategoryController extends BaseController{

	@Autowired
	private ICategoryService service;

	@RequestMapping("/category_list")
	@ResponseBody
	public PageResult list(CategoryQuery qo){

		return service.queryPageResult(qo);
	}
	@RequestMapping("/category_listAll")
	@ResponseBody
	public  List<Category> listAll(){
		return service.selectAll();
	}

}
