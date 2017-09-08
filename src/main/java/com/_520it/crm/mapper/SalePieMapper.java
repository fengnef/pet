package com._520it.crm.mapper;

import com._520it.crm.domain.SalePie;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SalePieMapper {
	//插入一条
    int insert(SalePie record);
	
	//以天为单位 ,需要指定年月日
	List<SalePie> queryDay(String date);
	//以月为单位 , 只需要指定年份和月
	List<SalePie> queryMonth(@Param("year") String year, @Param("month") String month);
	//以年为单位
	List<SalePie> queryYear(String year);
	
	
}