package com._520it.crm.service;

import com._520it.crm.domain.Category;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.CategoryQuery;

import java.util.List;

public interface ICategoryService {
	int deleteByPrimaryKey(Long id);

	int insert(Category record);

	Category selectByPrimaryKey(Long id);

	List<Category> selectAll();

	int updateByPrimaryKey(Category record);

	//查询分页结果
	PageResult queryPageResult(CategoryQuery qo);

}
