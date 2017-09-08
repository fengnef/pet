package com._520it.crm.mapper;

import com._520it.crm.domain.ProductCategory;
import com._520it.crm.query.ProductCategoryQuery;

import java.util.List;

public interface ProductCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductCategory record);

    ProductCategory selectByPrimaryKey(Long id);

    List<ProductCategory> selectAll();

    int updateByPrimaryKey(ProductCategory record);

    Long queryPageCount(ProductCategoryQuery qo);

    List<ProductCategory> queryPageResult(ProductCategoryQuery qo);
}