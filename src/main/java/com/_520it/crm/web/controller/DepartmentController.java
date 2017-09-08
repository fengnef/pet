package com._520it.crm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.Department;
import com._520it.crm.query.EmployeeQuery;
import com._520it.crm.service.IDepartmentService;

@Controller
public class DepartmentController {

	@Autowired
	private IDepartmentService service;


	@RequestMapping("/dept_listAll")
	@ResponseBody
	public List<Department> list(EmployeeQuery qo){
		return service.selectAll();
	}
}
