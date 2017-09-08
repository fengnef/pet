package com._520it.crm.mapper;

import com._520it.crm.domain.LeaveClass;
import java.util.List;

public interface LeaveClassMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LeaveClass record);

    LeaveClass selectByPrimaryKey(Long id);

    List<LeaveClass> selectAll();

    int updateByPrimaryKey(LeaveClass record);
}