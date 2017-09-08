package com._520it.crm.mapper;

import com._520it.crm.domain.ProductStock;
import com._520it.crm.query.ProductStockQuery;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductStockMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductStock record);

    ProductStock selectByPrimaryKey(Long id);

    List<ProductStock> selectAll();

    int updateByPrimaryKey(ProductStock record);

    List<ProductStock> queryPageResult(ProductStockQuery qo);

    Long queryPageCount(ProductStockQuery qo);

    //根据商品编码查库存
    ProductStock getStockByProductSn(String productSn);

    //更新库存结余
    void updateBalanceStore(@Param("balanceStock") BigDecimal balanceStock, @Param("sn") String sn);

    //根据库存编码查库存
    ProductStock getStockByStockSn(String stockSn);
}