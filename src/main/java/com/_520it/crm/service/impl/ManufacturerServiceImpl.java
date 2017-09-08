package com._520it.crm.service.impl;

import com._520it.crm.domain.Manufacturer;
import com._520it.crm.mapper.ManufacturerMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ManufacturerQuery;
import com._520it.crm.service.IManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class ManufacturerServiceImpl implements IManufacturerService {

    @Autowired
    private ManufacturerMapper manufacturerMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return manufacturerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Manufacturer record) {
        return manufacturerMapper.insert(record);
    }

    @Override
    public Manufacturer selectByPrimaryKey(Long id) {
        return manufacturerMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Manufacturer> selectAll() {
        return manufacturerMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Manufacturer record) {
        return manufacturerMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult queryPageResult(ManufacturerQuery qo) {
        Long count = manufacturerMapper.queryPageCount(qo);
        if (count==0) {
            return new PageResult(count, Collections.EMPTY_LIST);
        }
        return new PageResult(count,manufacturerMapper.queryPageResult(qo));
    }
}
