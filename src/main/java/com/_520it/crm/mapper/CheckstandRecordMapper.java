package com._520it.crm.mapper;

import com._520it.crm.domain.CheckstandRecord;
import com._520it.crm.query.CheckstandRecordQuery;
import com._520it.crm.query.EmployeeQuery;

import java.util.List;

public interface CheckstandRecordMapper {

    int insert(CheckstandRecord record);

    CheckstandRecord selectByPrimaryKey(Long id);

    List<CheckstandRecord> selectAll();

    List<CheckstandRecordQuery> queryPageResult(CheckstandRecordQuery qo);

    Long queryPageCount(CheckstandRecordQuery qo);

}