package com._520it.crm.service;

import com._520it.crm.domain.LeaveClass;

import java.util.List;

public interface ILeaveClassService {
/*	int deleteByPrimaryKey(Long id);
	int insert(Department record);
	Department selectByPrimaryKey(Long id);
	int updateByPrimaryKey(Department record);*/

	List<LeaveClass> selectAll();
}
