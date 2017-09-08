package com._520it.crm.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com._520it.crm.domain.Employee;
import com._520it.crm.domain.PositionName;
import com._520it.crm.mapper.EmployeeMapper;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.Role;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.EmployeeQuery;
import com._520it.crm.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private EmployeeMapper mapper;

	@Override
	public int deleteByPrimaryKey(Long id) {


		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Employee record) {


		int count = mapper.insert(record);


		return count;
	}

	@Override
	public Employee selectByPrimaryKey(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Employee> selectAll() {
		return mapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Employee record) {


		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public PageResult queryPageResult(EmployeeQuery qo) {
		//查询总结果数
		Long count = mapper.queryPageCount(qo);
		if (count == 0) {
			return new PageResult(count, Collections.EMPTY_LIST);
		}

		//查询结果集
		return new PageResult(count, mapper.queryPageResult(qo));
	}

	@Override
	public void changeState(Long id) {
		mapper.changeState(id,new Date());
	}



	@Override
	public PageResult querySalalryPageResult(EmployeeQuery qo) {
		Long count = mapper.querySalaryPageCount(qo);
		if (count==0){
			return new PageResult(count, Collections.EMPTY_LIST);
		}
		List<Employee> lists = mapper.querySalaryPageResult(qo);
		for (Employee e :lists){

			if (e.getLeaver() == null ||!e.getLeaver().getState()){

				//提成
				BigDecimal base = e.getPositionName().getPostallowance().add(e.getPositionName().getTrafficsubsidies()).add(
						e.getPositionName().getPhonesubsidies()).add(e.getPositionName().getSubsidizedmeals()).add(e.getPositionName().getFulltime());
				e.getPositionName().setCommission(e.getPositionName().getCommission().divide(new BigDecimal("100")).multiply(base));
				e.setSalary(new BigDecimal("0"));
				e.setTotal(base.add(e.getPositionName().getCommission()).add(e.getBasicSalary()));

			}else {
				e.getPositionName().setFulltime(new BigDecimal("0"));
				BigDecimal base = e.getPositionName().getPostallowance().add(e.getPositionName().getTrafficsubsidies()).add(
						e.getPositionName().getPhonesubsidies()).add(e.getPositionName().getSubsidizedmeals());
				e.getPositionName().setCommission(e.getPositionName().getCommission().divide(new BigDecimal("100")).multiply(base));
				//请假一次扣除一天的工资
				BigDecimal divide1 =e.getBasicSalary().divide(new BigDecimal("21.75"),2, RoundingMode.HALF_UP );
				e.setSalary(divide1.multiply(new BigDecimal(e.getLeaver().getLeaveDuration())));
				e.setTotal(e.getBasicSalary().add(base).add(e.getPositionName().getCommission()).subtract(e.getSalary()));
			}
		}
		return new  PageResult(count,lists);
	}

}
