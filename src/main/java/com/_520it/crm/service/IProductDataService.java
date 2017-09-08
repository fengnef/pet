package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.Product;
import com._520it.crm.domain.ProductCategory;
import com._520it.crm.domain.ProductData;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.CheckstandRecordQuery;
import com._520it.crm.query.ProductDataQuery;

public interface IProductDataService {
	
	//查询全部
	List<ProductData> list();
	
	//查询商品类目表中所有的商品类别
	List<ProductCategory> getPetKind();
	
	//查询当前的商品种类所属的所有商品名称 
	List<Product> getProductNameBypc(Long parentId);

	//查询分页结果
	PageResult queryPageResult(ProductDataQuery qo);
}
