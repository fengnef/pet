package com._520it.crm.service;

import com._520it.crm.domain.Serviceitem;

import java.util.List;

public interface IServiceitemService {
    int deleteByPrimaryKey(Long id);

    int insert(Serviceitem record);

    Serviceitem selectByPrimaryKey(Long id);

    List<Serviceitem> selectAll();

    int updateByPrimaryKey(Serviceitem record);


    List<Object> getServiceitemRoot();

    List<Long> getServiceitemRootId();

    Serviceitem selectByItemId(Long id);


}
