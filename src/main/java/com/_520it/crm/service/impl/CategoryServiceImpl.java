package com._520it.crm.service.impl;

import com._520it.crm.domain.Category;
import com._520it.crm.mapper.CategoryMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.CategoryQuery;
import com._520it.crm.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
	@Autowired
	private CategoryMapper mapper;

	@Override
	public int deleteByPrimaryKey(Long id) {

		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Category record) {

		return mapper.insert(record);
	}

	@Override
	public Category selectByPrimaryKey(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Category> selectAll() {
		return mapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Category record) {

		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public PageResult queryPageResult(CategoryQuery qo) {
		//查询总结果数
		Long count = mapper.queryPageCount(qo);
		if (count == 0) {
			return new PageResult(count, Collections.EMPTY_LIST);
		}

		//查询结果集
		return new PageResult(count, mapper.queryPageResult(qo));
	}

}
