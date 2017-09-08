package com._520it.crm.service.impl;

import com._520it.crm.domain.Supplier;
import com._520it.crm.mapper.SupplierMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.SupplierQuery;
import com._520it.crm.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SupplierServiceImpl implements ISupplierService {
    @Autowired
    private SupplierMapper supplierMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return supplierMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Supplier record) {
        return supplierMapper.insert(record);
    }

    @Override
    public Supplier selectByPrimaryKey(Long id) {
        return supplierMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Supplier> selectAll() {
        return supplierMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Supplier record) {
        return supplierMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult queryPageResult(SupplierQuery qo) {
        Long count = supplierMapper.queryPageCount(qo);
        if (count==0) {
            return new PageResult(count, Collections.EMPTY_LIST);
        }
        return new PageResult(count,supplierMapper.queryPageResult(qo));
    }
}
