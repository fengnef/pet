package com._520it.crm.service;

import com._520it.crm.domain.DictionaryItem;

import java.util.List;

public interface IDictionaryItemService {
	int deleteByPrimaryKey(Long id);

	int insert(DictionaryItem record);

	DictionaryItem selectByPrimaryKey(Long id);

	List<DictionaryItem> selectAll();

	int updateByPrimaryKey(DictionaryItem record);

	List<DictionaryItem> selectItem(long pid);
}
