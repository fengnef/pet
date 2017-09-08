package com._520it.crm.service;

import com._520it.crm.domain.Manufacturer;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ManufacturerQuery;

import java.util.List;

public interface IManufacturerService {
    int deleteByPrimaryKey(Long id);

    int insert(Manufacturer record);

    Manufacturer selectByPrimaryKey(Long id);

    List<Manufacturer> selectAll();

    int updateByPrimaryKey(Manufacturer record);

    PageResult queryPageResult(ManufacturerQuery qo);
}
