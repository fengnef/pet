package com._520it.crm.mapper;

import com._520it.crm.domain.StockIncomeBillItem;
import com._520it.crm.query.QueryObject;

import java.util.List;

public interface StockIncomeBillItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StockIncomeBillItem record);

    StockIncomeBillItem selectByPrimaryKey(Long id);

    List<StockIncomeBillItem> selectAll();

    int updateByPrimaryKey(StockIncomeBillItem record);

    List<StockIncomeBillItem> queryPageResult(QueryObject qo);

    Long queryPageCount(QueryObject qo);

     void deleteAllOrderBill();
}