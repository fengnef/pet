package com._520it.crm.mapper;

import com._520it.crm.domain.Report;
import com._520it.crm.query.QueryObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportMapper {
	//删除一条
	int deleteByPrimaryKey(Long id);
	//插入一条
    int insert(Report record);
	//查询一条
    Report selectByPrimaryKey(Long id);
	//查询所有
    List<Report> selectAll();
	//更新一条
    int updateByPrimaryKey(Report record);
	
	List<Report> query(QueryObject qo);

	Long queryCount(QueryObject qo);
	
	//以天为单位 ,需要指定月份和年份
	List<Report> queryByDay(@Param("year") Integer year, @Param("month") Integer month);
	//以周为单位 , 只需要指定年份
	List<Report> queryByWeek(Integer week);
	//以月为单位 , 只需要指定年份
	List<Report> queryByMonth(Integer year);
	//以年为单位
	List<Report> queryByYear();
	
}