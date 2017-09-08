package com._520it.crm.web.controller;

import com._520it.crm.domain.Breed;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.BreedQuery;
import com._520it.crm.service.IBreedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BreedController extends BaseController{

	@Autowired
	private IBreedService service;

	@RequestMapping("/breed_list")
	@ResponseBody
	public PageResult list(BreedQuery qo){

		return service.queryPageResult(qo);
	}
	@RequestMapping("/breed_listAll")
	@ResponseBody
	public  List<Breed> listAll(){
		return service.selectAll();
	}

	@RequestMapping("/selectBreedByCategoryId")
	@ResponseBody
	public  List<Breed> selectBreedByCategoryId(Long id){
		return service.selectBreedByCategoryId(id);
	}






}
