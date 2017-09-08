package com._520it.crm.mapper;

import com._520it.crm.domain.Outindepot;
import com._520it.crm.domain.Outindepot;
import com._520it.crm.query.OutindepotQuery;

import java.util.List;

public interface OutindepotMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Outindepot record);

    Outindepot selectByPrimaryKey(Long id);

    List<Outindepot> selectAll();

    int updateByPrimaryKey(Outindepot record);

    Long queryPageCount(OutindepotQuery qo);

    List<Outindepot> queryPageResult(OutindepotQuery qo);
}