package com._520it.crm.service;

import com._520it.crm.domain.CheckstandRecord;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.CheckstandRecordQuery;

import java.util.List;

public interface ICheckstandRecordService {
	int insert(CheckstandRecord record);

	CheckstandRecord selectByPrimaryKey(Long id);

	List<CheckstandRecord> selectAll();

	//查询分页结果
	PageResult queryPageResult(CheckstandRecordQuery qo);
}
