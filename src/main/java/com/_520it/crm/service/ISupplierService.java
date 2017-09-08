package com._520it.crm.service;

import com._520it.crm.domain.Supplier;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.SupplierQuery;

import java.util.List;

public interface ISupplierService {

    int deleteByPrimaryKey(Long id);

    int insert(Supplier record);

    Supplier selectByPrimaryKey(Long id);

    List<Supplier> selectAll();

    int updateByPrimaryKey(Supplier record);

    PageResult queryPageResult(SupplierQuery qo);
}
