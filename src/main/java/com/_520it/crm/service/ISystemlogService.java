package com._520it.crm.service;

import com._520it.crm.domain.Systemlog;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.SystemlogQuery;

import java.util.List;

public interface ISystemlogService {

    int deleteByPrimaryKey(Long id);

    int insert(Systemlog record);

    Systemlog selectByPrimaryKey(Long id);

    List<Systemlog> selectAll();

    int updateByPrimaryKey(Systemlog record);

    PageResult queryPageResult(SystemlogQuery qo);
}
