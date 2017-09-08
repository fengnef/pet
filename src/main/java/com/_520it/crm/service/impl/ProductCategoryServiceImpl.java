package com._520it.crm.service.impl;

import com._520it.crm.domain.ProductCategory;
import com._520it.crm.mapper.ProductCategoryMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ProductCategoryQuery;
import com._520it.crm.service.IProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProductCategoryServiceImpl implements IProductCategoryService {
    @Autowired
    private ProductCategoryMapper mapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ProductCategory record) {
        return mapper.insert(record);
    }

    @Override
    public ProductCategory selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ProductCategory> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(ProductCategory record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult queryPageResult(ProductCategoryQuery qo) {
        Long count = mapper.queryPageCount(qo);
        if (count==0) {
            return new PageResult(count, Collections.EMPTY_LIST);
        }
        return new PageResult(count,mapper.queryPageResult(qo));
    }
}
