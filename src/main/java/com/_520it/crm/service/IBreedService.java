package com._520it.crm.service;

import com._520it.crm.domain.Breed;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.BreedQuery;

import java.util.List;

public interface IBreedService {
	int deleteByPrimaryKey(Long id);

	int insert(Breed record);

	Breed selectByPrimaryKey(Long id);

	List<Breed> selectAll();

	int updateByPrimaryKey(Breed record);

	//查询分页结果
	PageResult queryPageResult(BreedQuery qo);

	List<Breed> selectBreedByCategoryId(Long id);

}
