package com._520it.crm.service.impl;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import com._520it.crm.domain.Product;
import com._520it.crm.domain.ProductCategory;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ProductDataQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.ProductData;
import com._520it.crm.mapper.ProductDataMapper;
import com._520it.crm.service.IProductDataService;
@Service
public class ProductDataServiceImpl implements IProductDataService {

	@Autowired
	private ProductDataMapper mapper;
	@Override
	public List<ProductData> list() {
		ProductData pd =new ProductData();
		String aname = "吉米娃娃923-18";//这个name为选定的商品的
		// 具体名称
		//获取商品名称
		//String productName = mapper.getProductName(aname);
		//获取商品Id
		Long productId = mapper.getProductId(aname);
		//获取入库单价
		BigDecimal stockIncomeAveragePrice = mapper.getStockIncomeAveragePrice(aname);
		//获取出库单价
		BigDecimal stockOutcomeAveragePrice = mapper.getStockOutcomeAveragePrice(aname);
		//查询销售数量
		//BigDecimal saleCount = mapper.getSaleCount(aname);
		BigDecimal saleCount = new BigDecimal(1);
		//设置商品名称
		pd.setProductId(productId);//productId
		//设置商品名称
		pd.setProductName(aname);//productName
		//设置入库单价
		pd.setStockIncomeAveragePrice(stockIncomeAveragePrice);
		//设置出库单价
		pd.setStockOutcomeAveragePrice(stockOutcomeAveragePrice);
		//设置销售价格
		pd.setSalePrice(stockOutcomeAveragePrice);
		//设置销售数量
		pd.setSaleCount(saleCount);
		//设置销售总价
		pd.setSalePriceCount(pd.getSaleCount().multiply(pd.getSalePrice()));
		//设置盈利
		pd.setProfit(pd.getSalePriceCount().subtract(saleCount.multiply(stockIncomeAveragePrice)));
		mapper.save(pd);
		return mapper.list();
	}
	
	//查询商品类目表中所有的商品类别
	@Override
	public List<ProductCategory> getPetKind() {
		return mapper.getPetKind();
	}
	
	//查询当前的商品种类所属的所有商品名称 
	@Override
	public List<Product> getProductNameBypc(Long parentId) {
		return mapper.getProductNameBypc(parentId);
	}

	@Override
	public PageResult queryPageResult(ProductDataQuery qo) {

		//查询总结果数
		Long count = mapper.queryPageCount(qo);
		if (count == 0) {
			return new PageResult(count, Collections.EMPTY_LIST);
		}

		//查询结果集
		return new PageResult(count, mapper.queryPageResult(qo));
	}

}
