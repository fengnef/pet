package com._520it.crm.service;

import com._520it.crm.domain.Outindepot;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.OutindepotQuery;

import java.util.List;

public interface IOutindepotService {

    int deleteByPrimaryKey(Long id);

    int insert(Outindepot record);

    Outindepot selectByPrimaryKey(Long id);

    List<Outindepot> selectAll();

    int updateByPrimaryKey(Outindepot record);

    PageResult queryPageResult(OutindepotQuery qo);
}
