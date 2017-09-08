package com._520it.crm.web.controller;

import com._520it.crm.domain.LeaveClass;
import com._520it.crm.query.EmployeeQuery;
import com._520it.crm.service.ILeaveClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LeaveClassController {

	@Autowired
	private ILeaveClassService service;


	@RequestMapping("/leaveClass_listAll")
	@ResponseBody
	public List<LeaveClass> list(EmployeeQuery qo){

		return service.selectAll();
	}
}
