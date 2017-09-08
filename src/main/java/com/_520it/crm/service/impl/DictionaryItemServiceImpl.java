package com._520it.crm.service.impl;

import com._520it.crm.domain.Dictionary;
import com._520it.crm.domain.DictionaryItem;
import com._520it.crm.mapper.DictionaryItemMapper;
import com._520it.crm.mapper.DictionaryMapper;
import com._520it.crm.service.IDictionaryItemService;
import com._520it.crm.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryItemServiceImpl implements IDictionaryItemService {
	@Autowired
	private DictionaryItemMapper mapper;

	@Override
	public int deleteByPrimaryKey(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DictionaryItem record) {
		return mapper.insert(record);
	}

	@Override
	public DictionaryItem selectByPrimaryKey(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<DictionaryItem> selectAll() {
		return mapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(DictionaryItem record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public List<DictionaryItem> selectItem(long pid) {
		return mapper.selectItem(pid);
	}


}
