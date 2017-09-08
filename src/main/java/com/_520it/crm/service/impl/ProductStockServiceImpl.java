package com._520it.crm.service.impl;

import com._520it.crm.domain.ProductStock;
import com._520it.crm.mapper.ProductStockMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ProductStockQuery;
import com._520it.crm.service.IProductStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Service
public class ProductStockServiceImpl implements IProductStockService {
    @Autowired
    private ProductStockMapper mapper;


    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(ProductStock record) {

        mapper.insert(record);
        return 0;
    }

    @Override
    public ProductStock selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public List<ProductStock> selectAll() {
        return null;
    }

    @Override
    public int updateByPrimaryKey(ProductStock record) {
        mapper.updateByPrimaryKey(record);
        return 0;
    }

    @Override
    public PageResult queryPageResult(ProductStockQuery qo) {
        //查询总结果数
        Long count = mapper.queryPageCount(qo);
        if (count == 0) {
            return new PageResult(count, Collections.EMPTY_LIST);
        }
        //查询结果集
        return new PageResult(count, mapper.queryPageResult(qo));
    }

    @Override
    public ProductStock getStockByProductSn(String productSn) {
        return mapper.getStockByProductSn(productSn);
    }

    @Override
    public void updateBalanceStore(BigDecimal balanceStore, String sn) {
        mapper.updateBalanceStore(balanceStore, sn);
    }

    @Override
    public ProductStock getStockByStockSn(String stockSn) {
       return mapper.getStockByStockSn(stockSn);
    }


}
