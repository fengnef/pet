package com._520it.crm.mapper;

import com._520it.crm.domain.StockOutcomeBill;
import com._520it.crm.query.QueryObject;

import java.util.List;

public interface StockOutcomeBillMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StockOutcomeBill record);

    StockOutcomeBill selectByPrimaryKey(Long id);

    List<StockOutcomeBill> selectAll();

    int updateByPrimaryKey(StockOutcomeBill record);

    List<StockOutcomeBill> queryPageResult(QueryObject qo);

    Long queryPageCount(QueryObject qo);

    void deleteAllOutcomeBill();

}