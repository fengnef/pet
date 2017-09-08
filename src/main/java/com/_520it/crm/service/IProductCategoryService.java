package com._520it.crm.service;

import com._520it.crm.domain.ProductCategory;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ProductCategoryQuery;

import java.util.List;

public interface IProductCategoryService {
    int deleteByPrimaryKey(Long id);

    int insert(ProductCategory record);

    ProductCategory selectByPrimaryKey(Long id);

    List<ProductCategory> selectAll();

    int updateByPrimaryKey(ProductCategory record);

    PageResult queryPageResult(ProductCategoryQuery qo);
}
