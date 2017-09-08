package com._520it.crm.mapper;

import com._520it.crm.domain.Inoutstock;
import java.util.List;

public interface InoutstockMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Inoutstock record);

    Inoutstock selectByPrimaryKey(Long id);

    List<Inoutstock> selectAll();

    int updateByPrimaryKey(Inoutstock record);
}