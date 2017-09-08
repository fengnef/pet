package com._520it.crm.mapper;

import com._520it.crm.domain.Sufficientitem;
import com._520it.crm.query.MemberQuery;

import java.util.List;

public interface SufficientitemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Sufficientitem record);

    Sufficientitem selectByPrimaryKey(Long id);

    List<Sufficientitem> selectAll();

    int updateByPrimaryKey(Sufficientitem record);


    List<Sufficientitem> selectSufficientitem(MemberQuery qo);


    Long queryPageCount(MemberQuery qo);
}