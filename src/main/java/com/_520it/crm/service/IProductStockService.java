package com._520it.crm.service;

import com._520it.crm.domain.ProductStock;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ProductStockQuery;

import java.math.BigDecimal;
import java.util.List;

public interface IProductStockService {
    int deleteByPrimaryKey(Long id);

    int insert(ProductStock record);

    ProductStock selectByPrimaryKey(Long id);

    List<ProductStock> selectAll();

    int updateByPrimaryKey(ProductStock record);

    //查询分页结果
    PageResult queryPageResult(ProductStockQuery qo);

    //根据商品编码查库存
    ProductStock getStockByProductSn(String productSn);

    //更新库存结余
    void updateBalanceStore(BigDecimal balanceStore, String sn);

    //根据库存编码查库存
    ProductStock getStockByStockSn(String stockSn);

}
