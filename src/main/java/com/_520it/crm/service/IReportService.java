package com._520it.crm.service;

import com._520it.crm.domain.Report;
import com._520it.crm.query.QueryObject;

import java.util.List;

public interface IReportService {
	
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
	
	/**以天为单位 ,需要指定月份和年份
	 * @param year
	 * @param month
	 * @return
	 */
	List<Report> queryByDay(Integer year, Integer month);
	
	/**以周为单位 , 只需要指定年份
	 * @param week
	 * @return
	 */
	List<Report> queryByWeek(Integer week);
	
	/**以月为单位 , 只需要指定年份
	 * @param year
	 * @return
	 */
	List<Report> queryByMonth(Integer year);
	
	/**以年为单位
	 * @return
	 */
	List<Report> queryByYear();
	
}
