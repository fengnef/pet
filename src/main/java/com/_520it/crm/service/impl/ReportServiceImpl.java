package com._520it.crm.service.impl;

import com._520it.crm.domain.Report;
import com._520it.crm.mapper.ReportMapper;
import com._520it.crm.query.QueryObject;
import com._520it.crm.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ReportServiceImpl implements IReportService {
	
	@Autowired
	private ReportMapper mapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public int insert(Report record) {
		return mapper.insert(record);
	}
	
	@Override
	public Report selectByPrimaryKey(Long id) {
		return mapper.selectByPrimaryKey(id);
	}
	
	@Override
	public List<Report> selectAll() {
		return mapper.selectAll();
	}
	
	@Override
	public int updateByPrimaryKey(Report record) {
		return mapper.updateByPrimaryKey(record);
	}
	
	@Override
	public List<Report> query(QueryObject qo) {
		return mapper.query(qo);
	}
	
	@Override
	public Long queryCount(QueryObject qo) {
		return mapper.queryCount(qo);
	}
	
	@Override
	public List<Report> queryByDay(Integer year , Integer month) {
		return mapper.queryByDay(year,month);
	}
	
	@Override
	public List<Report> queryByWeek(Integer week) {
		return mapper.queryByWeek(week);
	}
	
	@Override
	public List<Report> queryByMonth(Integer year) {
		return mapper.queryByMonth(year);
	}
	
	@Override
	public List<Report> queryByYear() {
		return mapper.queryByYear();
	}
}
