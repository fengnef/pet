package com._520it.crm.service.impl;

import com._520it.crm.domain.Systemlog;
import com._520it.crm.mapper.SystemlogMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.SystemlogQuery;
import com._520it.crm.service.ISystemlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SystemlogServiceImpl implements ISystemlogService {
    @Autowired
    private SystemlogMapper systemlogMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return systemlogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Systemlog record) {
        return systemlogMapper.insert(record);
    }

    @Override
    public Systemlog selectByPrimaryKey(Long id) {
        return systemlogMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Systemlog> selectAll() {
        return systemlogMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Systemlog record) {
        return systemlogMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult queryPageResult(SystemlogQuery qo) {
        Long count = systemlogMapper.queryPageCount(qo);
        if (count==0) {
            return new PageResult(count, Collections.EMPTY_LIST);
        }
        return new PageResult(count,systemlogMapper.queryPageResult(qo));
    }
}
