package com._520it.crm.mapper;

import com._520it.crm.domain.ProductCategory;
import com._520it.crm.domain.ProductPomponent;
import com._520it.crm.query.ProductCategoryQuery;
import com._520it.crm.query.ProductPomponentQuery;

import java.util.List;

public interface ProductPomponentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductPomponent record);

    ProductPomponent selectByPrimaryKey(Long id);

    List<ProductPomponent> selectAll();

    int updateByPrimaryKey(ProductPomponent record);

    Long queryPageCount(ProductPomponentQuery qo);

    List<ProductPomponent> queryPageResult(ProductPomponentQuery qo);
}