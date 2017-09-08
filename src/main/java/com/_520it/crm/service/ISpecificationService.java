package com._520it.crm.service;

import com._520it.crm.domain.Specification;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.SpecificationQuery;

import java.util.List;

public interface ISpecificationService {

    int deleteByPrimaryKey(Long id);

    int insert(Specification record);

    Specification selectByPrimaryKey(Long id);

    List<Specification> selectAll();

    int updateByPrimaryKey(Specification record);

    PageResult queryPageResult(SpecificationQuery qo);
}
