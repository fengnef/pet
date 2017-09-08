package com._520it.crm.mapper;

import com._520it.crm.domain.Petkindandcategory;
import com._520it.crm.domain.Petkindandcategory;
import com._520it.crm.query.PetkindandcategoryQuery;

import java.util.List;

public interface PetkindandcategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Petkindandcategory record);

    Petkindandcategory selectByPrimaryKey(Long id);

    List<Petkindandcategory> selectAll();

    int updateByPrimaryKey(Petkindandcategory record);

    Long queryPageCount(PetkindandcategoryQuery qo);

    List<Petkindandcategory> queryPageResult(PetkindandcategoryQuery qo);
}