package com._520it.crm.service.impl;

import com._520it.crm.domain.Leaver;
import com._520it.crm.mapper.LeaverMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.EmployeeQuery;
import com._520it.crm.service.ILeaverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class LeaverServiceImpl implements ILeaverService {
    @Autowired
    private LeaverMapper mapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Leaver record) {
        return mapper.insert(record);
    }

    @Override
    public Leaver selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Leaver> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Leaver record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult queryPageResult(EmployeeQuery qo) {
        //查询总结果数
        Long count = mapper.queryPageCount(qo);
        if(count==0){
            return new PageResult(count, Collections.EMPTY_LIST);
        }
        //查询结果集
        return new PageResult(count, mapper.queryPageResult(qo));
    }
}
