package com._520it.crm.service.impl;

import com._520it.crm.domain.Outindepot;
import com._520it.crm.mapper.OutindepotMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.OutindepotQuery;
import com._520it.crm.service.IOutindepotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class OutindepotServiceImpl implements IOutindepotService {
    @Autowired
    private OutindepotMapper depotMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return depotMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Outindepot record) {
        return depotMapper.insert(record);
    }

    @Override
    public Outindepot selectByPrimaryKey(Long id) {
        return depotMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Outindepot> selectAll() {
        return depotMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Outindepot record) {
        return depotMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult queryPageResult(OutindepotQuery qo) {
        Long count = depotMapper.queryPageCount(qo);
        if (count==0) {
            return new PageResult(count, Collections.EMPTY_LIST);
        }
        return new PageResult(count,depotMapper.queryPageResult(qo));
    }
}
