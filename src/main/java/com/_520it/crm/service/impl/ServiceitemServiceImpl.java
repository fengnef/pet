package com._520it.crm.service.impl;

import com._520it.crm.domain.Serviceitem;
import com._520it.crm.mapper.ServiceitemMapper;
import com._520it.crm.service.IServiceitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceitemServiceImpl implements IServiceitemService {
	@Autowired
	private ServiceitemMapper mapper;

	@Override
	public int deleteByPrimaryKey(Long id) {

		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Serviceitem record) {
		return mapper.insert(record);
	}

	@Override
	public Serviceitem selectByPrimaryKey(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Serviceitem> selectAll() {
		return mapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Serviceitem record) {

		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Object> getServiceitemRoot() {
		return mapper.getServiceitemRoot();
	}

	@Override
	public List<Long> getServiceitemRootId() {
		return mapper.getServiceitemRootId();
	}

	@Override
	public Serviceitem selectByItemId(Long id) {
		return mapper.selectByItemId(id);
	}



}
