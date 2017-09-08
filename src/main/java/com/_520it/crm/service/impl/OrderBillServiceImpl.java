package com._520it.crm.service.impl;

import com._520it.crm.domain.OrderBill;
import com._520it.crm.mapper.OrderBillMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.service.IOrderBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class OrderBillServiceImpl implements IOrderBillService {
    @Autowired
    private OrderBillMapper mapper;


    @Override
    public int deleteByPrimaryKey(Long id) {
        mapper.deleteByPrimaryKey(id);
        return 0;
    }

    @Override
    public int insert(OrderBill record) {

        mapper.insert(record);
        return 0;
    }

    @Override
    public OrderBill selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<OrderBill> selectAll() {
        return null;
    }

    @Override
    public int updateByPrimaryKey(OrderBill record) {
        mapper.updateByPrimaryKey(record);
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
