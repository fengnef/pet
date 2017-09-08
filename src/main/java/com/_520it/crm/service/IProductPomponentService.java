package com._520it.crm.service;

import com._520it.crm.domain.ProductPomponent;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ProductPomponentQuery;

import java.util.List;

public interface IProductPomponentService {
    int deleteByPrimaryKey(Long id);

    int insert(ProductPomponent record);

    ProductPomponent selectByPrimaryKey(Long id);

    List<ProductPomponent> selectAll();

    int updateByPrimaryKey(ProductPomponent record);

    PageResult queryPageResult(ProductPomponentQuery qo);
}
