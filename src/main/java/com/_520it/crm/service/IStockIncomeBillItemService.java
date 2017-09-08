package com._520it.crm.service;

import com._520it.crm.domain.StockIncomeBillItem;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;

import java.util.List;

public interface IStockIncomeBillItemService {
    int deleteByPrimaryKey(Long id);

    int insert(StockIncomeBillItem record);

    StockIncomeBillItem selectByPrimaryKey(Long id);

    List<StockIncomeBillItem> selectAll();

    int updateByPrimaryKey(StockIncomeBillItem record);

    //查询分页结果
    PageResult queryPageResult(QueryObject qo);

    //入库后删除所有订单
    void deleteAllOrderBill();
}
