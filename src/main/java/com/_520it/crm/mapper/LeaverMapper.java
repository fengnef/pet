package com._520it.crm.mapper;

import com._520it.crm.domain.Leaver;
import com._520it.crm.query.QueryObject;

import java.util.List;

public interface LeaverMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Leaver record);

    Leaver selectByPrimaryKey(Long id);

    List<Leaver> selectAll();

    int updateByPrimaryKey(Leaver record);

    Long queryPageCount(QueryObject qo);

    List<Leaver> queryPageResult(QueryObject qo);
}