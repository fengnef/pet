package com._520it.crm.mapper;

import com._520it.crm.domain.DictionaryItem;
import java.util.List;

public interface DictionaryItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DictionaryItem record);

    DictionaryItem selectByPrimaryKey(Long id);

    List<DictionaryItem> selectAll();

    int updateByPrimaryKey(DictionaryItem record);

    List<DictionaryItem> selectItem(long pid);
}