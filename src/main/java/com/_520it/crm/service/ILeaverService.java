package com._520it.crm.service;

import com._520it.crm.domain.Leaver;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.EmployeeQuery;

import java.util.List;

public interface ILeaverService {
	int deleteByPrimaryKey(Long id);

	int insert(Leaver record);

	Leaver selectByPrimaryKey(Long id);

	List<Leaver> selectAll();

	int updateByPrimaryKey(Leaver record);

	PageResult queryPageResult(EmployeeQuery qo);

}
