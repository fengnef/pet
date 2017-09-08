package com._520it.crm.mapper;

import com._520it.crm.domain.Category;
import com._520it.crm.query.CategoryQuery;

import java.util.List;

public interface CategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Category record);

    Category selectByPrimaryKey(Long id);

    List<Category> selectAll();

    int updateByPrimaryKey(Category record);
    List<Category> queryPageResult(CategoryQuery qo);
    Long queryPageCount(CategoryQuery qo);
}