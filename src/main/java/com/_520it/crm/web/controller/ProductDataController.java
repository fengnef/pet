package com._520it.crm.web.controller;

import java.util.List;

import com._520it.crm.domain.Product;
import com._520it.crm.domain.ProductCategory;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ProductDataQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.ProductData;
import com._520it.crm.service.IProductDataService;

@Controller
public class ProductDataController {
	
	@Autowired
	private IProductDataService service;
	
	@RequestMapping("/pd_list")
	@ResponseBody
	public List<ProductData> list(){
	 List<ProductData> list = service.list();
		return list;
	}
	
	//查询商品类目表中所有的商品类别
	@RequestMapping("/getPetKind_list")
	@ResponseBody
	public List<ProductCategory> getPetKind(){
		return service.getPetKind();
	}
	
	//查询当前的商品种类所属的所有商品名称 
	@RequestMapping("/getProductNameBypc_list")
	@ResponseBody
	public List<Product> getProductNameBypc(Long parentId) {
		return service.getProductNameBypc(parentId);
	}

	@RequestMapping("/queryPageResult")
	@ResponseBody
	public PageResult queryPageResult(ProductDataQuery qo){
		return service.queryPageResult(qo);
	}


}
