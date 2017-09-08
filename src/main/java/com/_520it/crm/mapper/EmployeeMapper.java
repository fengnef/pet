package com._520it.crm.mapper;

import com._520it.crm.domain.Employee;
import com._520it.crm.query.EmployeeQuery;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Employee record);

    Employee selectByPrimaryKey(Long id);

    List<Employee> selectAll();

    int updateByPrimaryKey(Employee record);

    Long queryPageCount(EmployeeQuery qo);

    List<Employee> queryPageResult(EmployeeQuery qo);

    void changeState(@Param("id")Long id, @Param("departureTime")Date departureTime);


    Long querySalaryPageCount(EmployeeQuery qo);

    List<Employee> querySalaryPageResult(EmployeeQuery qo);


}