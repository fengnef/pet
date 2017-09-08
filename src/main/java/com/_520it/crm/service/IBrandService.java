package com._520it.crm.service;

import com._520it.crm.domain.Brand;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.BrandQuery;

import java.util.List;

public interface IBrandService {

    int deleteByPrimaryKey(Long id);

    int insert(Brand record);

    Brand selectByPrimaryKey(Long id);

    List<Brand> selectAll();

    int updateByPrimaryKey(Brand record);

    PageResult queryPageResult(BrandQuery qo);
}
