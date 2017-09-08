package com._520it.crm.mapper;

import com._520it.crm.domain.Supplier;
import com._520it.crm.domain.Supplier;
import com._520it.crm.query.SupplierQuery;

import java.util.List;

public interface SupplierMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Supplier record);

    Supplier selectByPrimaryKey(Long id);

    List<Supplier> selectAll();

    int updateByPrimaryKey(Supplier record);

    Long queryPageCount(SupplierQuery qo);

    List<Supplier> queryPageResult(SupplierQuery qo);
}