package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.Employee;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.EmployeeQuery;

public interface IEmployeeService {
	int deleteByPrimaryKey(Long id);

	int insert(Employee record);

	Employee selectByPrimaryKey(Long id);

	List<Employee> selectAll();

	int updateByPrimaryKey(Employee record);

	//查询分页结果
	PageResult queryPageResult(EmployeeQuery qo);
	//设置为离职状态
	void changeState(Long id);



	PageResult querySalalryPageResult(EmployeeQuery qo);
}
