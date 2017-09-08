package com._520it.crm.service.impl;

import com._520it.crm.domain.Specification;
import com._520it.crm.mapper.SpecificationMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.SpecificationQuery;
import com._520it.crm.service.ISpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SpecificationServiceImpl implements ISpecificationService {
    @Autowired
    private SpecificationMapper specMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return specMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Specification record) {
        return specMapper.insert(record);
    }

    @Override
    public Specification selectByPrimaryKey(Long id) {
        return specMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Specification> selectAll() {
        return specMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Specification record) {
        return specMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult queryPageResult(SpecificationQuery qo) {
        Long count = specMapper.queryPageCount(qo);
        if (count==0) {
            return new PageResult(count, Collections.EMPTY_LIST);
        }
        return new PageResult(count,specMapper.queryPageResult(qo));
    }
}
