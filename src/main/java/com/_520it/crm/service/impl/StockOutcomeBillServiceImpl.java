package com._520it.crm.service.impl;

import com._520it.crm.domain.StockOutcomeBill;
import com._520it.crm.mapper.StockOutcomeBillMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.service.IStockOutcomeBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class StockOutcomeBillServiceImpl implements IStockOutcomeBillService {
    @Autowired
    private StockOutcomeBillMapper mapper;


    @Override
    public int deleteByPrimaryKey(Long id) {
        mapper.deleteByPrimaryKey(id);
        return 0;
    }

    @Override
    public int insert(StockOutcomeBill record) {
        mapper.insert(record);
        return 0;
    }

    @Override
    public StockOutcomeBill selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<StockOutcomeBill> selectAll() {
        return null;
    }

    @Override
    public int updateByPrimaryKey(StockOutcomeBill record) {

        return mapper.updateByPrimaryKey(record);
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

    @Override
    public void deleteAllOutcomeBill() {
        mapper.deleteAllOutcomeBill();
    }

}
