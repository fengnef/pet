package com._520it.crm.mapper;

import com._520it.crm.domain.Vipmember;
import com._520it.crm.query.VipmemberQuery;

import java.util.List;

public interface VipmemberMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Vipmember record);

    Vipmember selectByPrimaryKey(Long id);

    List<Vipmember> selectAll();

    int updateByPrimaryKey(Vipmember record);

    Long queryPageCount(VipmemberQuery qo);

    List<Vipmember> queryPageResult(VipmemberQuery qo);
}