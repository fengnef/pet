package com._520it.crm.service.impl;

import com._520it.crm.domain.SalePie;
import com._520it.crm.mapper.SalePieMapper;
import com._520it.crm.service.ISalePieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SalePieServiceImpl implements ISalePieService {
	
	@Autowired
	public SalePieMapper mapper;
	
	@Override
	public int insert(SalePie record) {
		return mapper.insert(record);
	}
	
	
	@Override
	public List<SalePie> queryDay(String date) {
		return mapper.queryDay(date);
	}
	
	@Override
	public List<SalePie> queryMonth(String year , String month) {
		return mapper.queryMonth(year,month);
	}
	
	@Override
	public List<SalePie> queryYear(String year) {
		return mapper.queryYear(year);
	}
}
