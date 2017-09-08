package com._520it.crm.mapper;

import com._520it.crm.domain.PositionName;
import com._520it.crm.query.QueryObject;

import java.util.List;

public interface PositionNameMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PositionName record);

    PositionName selectByPrimaryKey(Long id);

    List<PositionName> selectAll();

    int updateByPrimaryKey(PositionName record);

    Long queryPageCount(QueryObject qo);

    List<PositionName> queryPageResult(QueryObject qo);



}