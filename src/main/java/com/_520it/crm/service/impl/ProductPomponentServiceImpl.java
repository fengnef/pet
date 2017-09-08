package com._520it.crm.service.impl;

import com._520it.crm.domain.ProductPomponent;
import com._520it.crm.mapper.ProductPomponentMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ProductPomponentQuery;
import com._520it.crm.service.IProductPomponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProductPomponentServiceImpl implements IProductPomponentService {
    @Autowired
    private ProductPomponentMapper mapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ProductPomponent record) {
        return mapper.insert(record);
    }

    @Override
    public ProductPomponent selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ProductPomponent> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(ProductPomponent record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult queryPageResult(ProductPomponentQuery qo) {
        Long count = mapper.queryPageCount(qo);
        if (count==0) {
            return new PageResult(count, Collections.EMPTY_LIST);
        }
        System.out.println(mapper.queryPageResult(qo));
        return new PageResult(count,mapper.queryPageResult(qo));
    }
}
