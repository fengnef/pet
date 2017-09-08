package com._520it.crm.service;

import com._520it.crm.domain.PositionName;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;

import java.util.List;

public interface IPositionNameService {
	int deleteByPrimaryKey(Long id);

	int insert(PositionName record);

	PositionName selectByPrimaryKey(Long id);

	List<PositionName> selectAll();

	int updateByPrimaryKey(PositionName record);

	//查询分页结果
	PageResult queryPageResult(QueryObject qo);


}
