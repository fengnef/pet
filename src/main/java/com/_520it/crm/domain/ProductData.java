package com._520it.crm.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//商品数据(做商品数据报表使用)
public class ProductData {
	
	//id
	public Long id;
	//商品Id
	public Long productId;
	//商品名称
	public String productName;
	//入库单价
	public BigDecimal stockIncomeAveragePrice;
	//出库单价
	public BigDecimal stockOutcomeAveragePrice;
	//销售价格
	public BigDecimal salePrice;
	//销售数量
	public BigDecimal saleCount;
	//销售总价
	public BigDecimal salePriceCount;
	//盈利
	public BigDecimal profit;
	
	
}
