package com._520it.crm.service;

import com._520it.crm.domain.StockOutcomeBill;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;

import java.util.List;

public interface IStockOutcomeBillService {
    int deleteByPrimaryKey(Long id);

    int insert(StockOutcomeBill record);

    StockOutcomeBill selectByPrimaryKey(Long id);

    List<StockOutcomeBill> selectAll();

    int updateByPrimaryKey(StockOutcomeBill record);

    //查询分页结果
    PageResult queryPageResult(QueryObject qo);

    //出库后删除所有出库单
    void deleteAllOutcomeBill();
}
