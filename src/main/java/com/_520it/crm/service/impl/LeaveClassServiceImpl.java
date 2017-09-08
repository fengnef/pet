package com._520it.crm.service.impl;

import com._520it.crm.domain.LeaveClass;
import com._520it.crm.mapper.LeaveClassMapper;
import com._520it.crm.service.ILeaveClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveClassServiceImpl implements ILeaveClassService {
	@Autowired
	private LeaveClassMapper mapper;

	/*@Override
	public int deleteByPrimaryKey(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Leavertype record) {
		return mapper.insert(record);
	}

	@Override
	public Leavertype selectByPrimaryKey(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(Leavertype record) {
		return mapper.updateByPrimaryKey(record);
	}*/
	@Override
	public List<LeaveClass> selectAll() {
		return mapper.selectAll();
	}



}
