package com._520it.crm.service.impl;

import com._520it.crm.domain.Brand;
import com._520it.crm.mapper.BrandMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.BrandQuery;
import com._520it.crm.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BrandServiceImpl implements IBrandService {
    @Autowired
    private BrandMapper brandMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Brand record) {
        return brandMapper.insert(record);
    }

    @Override
    public Brand selectByPrimaryKey(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Brand> selectAll() {
        return brandMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Brand record) {
        return brandMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult queryPageResult(BrandQuery qo) {
        Long count = brandMapper.queryPageCount(qo);
        if (count==0) {
            return new PageResult(count, Collections.EMPTY_LIST);
        }
        return new PageResult(count,brandMapper.queryPageResult(qo));
    }
}
