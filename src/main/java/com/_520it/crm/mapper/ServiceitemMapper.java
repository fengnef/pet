package com._520it.crm.mapper;

import com._520it.crm.domain.Serviceitem;

import java.util.List;

public interface ServiceitemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Serviceitem record);

    Serviceitem selectByPrimaryKey(Long id);

    Serviceitem selectByItemId(Long id);

    List<Serviceitem> selectAll();

    int updateByPrimaryKey(Serviceitem record);


    List<Object> getServiceitemRoot();

    List<Long> getServiceitemRootId();
}