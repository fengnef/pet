package com._520it.crm.mapper;

import com._520it.crm.domain.StockOutcomeBillItem;
import com._520it.crm.query.QueryObject;

import java.util.List;

public interface StockOutcomeBillitemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StockOutcomeBillItem record);

    StockOutcomeBillItem selectByPrimaryKey(Integer id);

    List<StockOutcomeBillItem> selectAll();

    int updateByPrimaryKey(StockOutcomeBillItem record);

    List<StockOutcomeBillItem> queryPageResult(QueryObject qo);

     Long queryPageCount(QueryObject qo);
}