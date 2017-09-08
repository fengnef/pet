package com._520it.crm.service.impl;

import com._520it.crm.domain.CheckstandRecord;
import com._520it.crm.mapper.CheckstandRecordMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.CheckstandRecordQuery;
import com._520it.crm.service.ICheckstandRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CheckstandRecordServiceImpl implements ICheckstandRecordService{
	@Autowired
	private CheckstandRecordMapper mapper;


	@Override
	public int insert(CheckstandRecord record) {
		return mapper.insert(record);
	}

	@Override
	public CheckstandRecord selectByPrimaryKey(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<CheckstandRecord> selectAll() {
		return mapper.selectAll();
	}

	@Override
	public PageResult queryPageResult(CheckstandRecordQuery qo) {
		//查询总结果数
		Long count = mapper.queryPageCount(qo);
		if (count == 0) {
			return new PageResult(count, Collections.EMPTY_LIST);
		}

		//查询结果集
		return new PageResult(count, mapper.queryPageResult(qo));
	}

}
