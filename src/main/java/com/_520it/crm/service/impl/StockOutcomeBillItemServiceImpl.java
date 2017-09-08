package com._520it.crm.service.impl;


import com._520it.crm.domain.StockIncomeBillItem;
import com._520it.crm.domain.StockOutcomeBillItem;
import com._520it.crm.mapper.StockOutcomeBillitemMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.service.IStockOutcomeBillItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class StockOutcomeBillItemServiceImpl implements IStockOutcomeBillItemService {
    @Autowired
    private StockOutcomeBillitemMapper mapper;


    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(StockOutcomeBillItem record) {
        mapper.insert(record);
        return 0;
    }

    @Override
    public StockIncomeBillItem selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public List<StockOutcomeBillItem> selectAll() {
        return null;
    }

    @Override
    public int updateByPrimaryKey(StockOutcomeBillItem record) {
        return 0;
    }


    @Override
    public PageResult queryPageResult(QueryObject qo) {
        //查询总结果数
        Long count = mapper.queryPageCount(qo);
        if (count == 0) {
            return new PageResult(count, Collections.EMPTY_LIST);
        }
        //查询结果集
        return new PageResult(count, mapper.queryPageResult(qo));
    }

}
