package com._520it.crm.mapper;

import com._520it.crm.domain.Systemlog;
import com._520it.crm.query.SystemlogQuery;

import java.util.List;

public interface SystemlogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Systemlog record);

    Systemlog selectByPrimaryKey(Long id);

    List<Systemlog> selectAll();

    int updateByPrimaryKey(Systemlog record);

    Long queryPageCount(SystemlogQuery qo);

    List<Systemlog> queryPageResult(SystemlogQuery qo);
}