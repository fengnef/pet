package com._520it.crm.service;

import com._520it.crm.domain.Petkindandcategory;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.PetkindandcategoryQuery;

import java.util.List;

public interface IPetkindandcategoryService {

    int deleteByPrimaryKey(Long id);

    int insert(Petkindandcategory record);

    Petkindandcategory selectByPrimaryKey(Long id);

    List<Petkindandcategory> selectAll();

    int updateByPrimaryKey(Petkindandcategory record);

    PageResult queryPageResult(PetkindandcategoryQuery qo);
}
