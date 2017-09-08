package com._520it.crm.service.impl;

import com._520it.crm.domain.Breed;
import com._520it.crm.mapper.BreedMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.BreedQuery;
import com._520it.crm.service.IBreedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BreedServiceImpl implements IBreedService {
	@Autowired
	private BreedMapper mapper;

	@Override
	public int deleteByPrimaryKey(Long id) {

		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Breed record) {

		return mapper.insert(record);
	}

	@Override
	public Breed selectByPrimaryKey(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Breed> selectAll() {
		return mapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Breed record) {

		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public PageResult queryPageResult(BreedQuery qo) {
		//查询总结果数
		Long count = mapper.queryPageCount(qo);
		if (count == 0) {
			return new PageResult(count, Collections.EMPTY_LIST);
		}

		//查询结果集
		return new PageResult(count, mapper.queryPageResult(qo));
	}

	@Override
	public List<Breed> selectBreedByCategoryId(Long id) {
		return mapper.selectBreedByCategoryId(id);
	}

}
