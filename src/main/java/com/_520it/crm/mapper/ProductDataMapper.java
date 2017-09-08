package com._520it.crm.mapper;

import java.math.BigDecimal;
import java.util.List;

import com._520it.crm.domain.Employee;
import com._520it.crm.domain.Product;
import com._520it.crm.domain.ProductCategory;
import com._520it.crm.domain.ProductData;
import com._520it.crm.query.EmployeeQuery;
import com._520it.crm.query.ProductDataQuery;

public interface ProductDataMapper {
	//插入数据
	void save(ProductData pd);
	
	//查询全部 
	List<ProductData> list();
	
	//查询商品类目表中所有的商品类别
	List<ProductCategory> getPetKind();
	
	//查询当前的商品种类所属的所有商品名称 
	List<Product> getProductNameBypc(Long parentId);
	//高级查询
	Long queryPageCount(ProductDataQuery qo);
	//高级查询
	List<ProductData> queryPageResult(ProductDataQuery qo);
	
	//查询产品Id
	Long getProductId(String aname);
	
	//查询产品名称//根据商品类目查询在该商品类目下的商品信息(主要是商品名称)
	String getProductName(String aname);
	
	//查询入库单价
	BigDecimal getStockIncomeAveragePrice(String aname);
	
	//查询出库单价/销售价格
	BigDecimal getStockOutcomeAveragePrice(String aname);
	
	//查询销售数量
	BigDecimal getSaleCount(String aname);
}
