package com._520it.crm.service.impl;

import com._520it.crm.domain.Vipmember;
import com._520it.crm.mapper.VipmemberMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.VipmemberQuery;
import com._520it.crm.service.IVipmemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class VipmemberServiceImpl implements IVipmemberService {
    @Autowired
    private VipmemberMapper mapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Vipmember record) {
        return mapper.insert(record);
    }

    @Override
    public Vipmember selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Vipmember> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Vipmember record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult queryPageResult(VipmemberQuery qo) {
        Long count = mapper.queryPageCount(qo);
        if (count==0) {
            return new PageResult(count, Collections.EMPTY_LIST);
        }
        return new PageResult(count,mapper.queryPageResult(qo));
    }
}
