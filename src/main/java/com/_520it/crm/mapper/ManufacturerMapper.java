package com._520it.crm.mapper;

import com._520it.crm.domain.Brand;
import com._520it.crm.domain.Manufacturer;
import com._520it.crm.query.ManufacturerQuery;

import java.util.List;

public interface ManufacturerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Manufacturer record);

    Manufacturer selectByPrimaryKey(Long id);

    List<Manufacturer> selectAll();

    int updateByPrimaryKey(Manufacturer record);

    Long queryPageCount(ManufacturerQuery qo);

    List<Manufacturer> queryPageResult(ManufacturerQuery qo);
}