package com._520it.crm.mapper;

import com._520it.crm.domain.CommercialSpecification;
import java.util.List;

public interface CommercialSpecificationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CommercialSpecification record);

    CommercialSpecification selectByPrimaryKey(Long id);

    List<CommercialSpecification> selectAll();

    int updateByPrimaryKey(CommercialSpecification record);
}