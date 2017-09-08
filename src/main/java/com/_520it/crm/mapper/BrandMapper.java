package com._520it.crm.mapper;

import com._520it.crm.domain.Brand;
import com._520it.crm.query.BrandQuery;

import java.util.List;

public interface BrandMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Brand record);

    Brand selectByPrimaryKey(Long id);

    List<Brand> selectAll();

    int updateByPrimaryKey(Brand record);

    Long queryPageCount(BrandQuery qo);

    List<Brand> queryPageResult(BrandQuery qo);
}