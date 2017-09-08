package com._520it.crm.service;

import com._520it.crm.domain.StockIncomeBillItem;
import com._520it.crm.domain.StockOutcomeBillItem;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;

import java.util.List;

public interface IStockOutcomeBillItemService {
    int deleteByPrimaryKey(Long id);

    int insert(StockOutcomeBillItem record);

    StockIncomeBillItem selectByPrimaryKey(Long id);

    List<StockOutcomeBillItem > selectAll();

    int updateByPrimaryKey(StockOutcomeBillItem  record);

    //查询分页结果
    PageResult queryPageResult(QueryObject qo);


}
