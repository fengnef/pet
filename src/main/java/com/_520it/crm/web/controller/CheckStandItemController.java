package com._520it.crm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CheckStandItemController extends BaseController{



	@RequestMapping("/checkstanditem")
	public String index(){
		return "checkstanditem";
	}
}
