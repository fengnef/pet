package com._520it.crm.service;

import com._520it.crm.domain.Vipmember;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.VipmemberQuery;

import java.util.List;

public interface IVipmemberService {
    int deleteByPrimaryKey(Long id);

    int insert(Vipmember record);

    Vipmember selectByPrimaryKey(Long id);

    List<Vipmember> selectAll();

    int updateByPrimaryKey(Vipmember record);

    PageResult queryPageResult(VipmemberQuery qo);
}
