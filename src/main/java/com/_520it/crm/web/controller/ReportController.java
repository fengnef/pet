package com._520it.crm.web.controller;

import com._520it.crm.domain.Report;
import com._520it.crm.service.IReportService;
import com.alibaba.druid.support.json.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ReportController {
	
	@Autowired
	private IReportService service;
	
	@RequestMapping("report")
	public String report() {
		return "report";
	}
	
	//以天为单位 ,需要指定月份和年份
	@RequestMapping("/line")
	public ModelAndView queryByDay(HttpServletRequest request) {
		String year = request.getParameter("year");
		String month = request.getParameter("month");

		System.err.println(year +"  "+ month);

		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		String sdate = sd.format(date);
		if (year == null || "".equals(year) ) {
			year = sdate.substring(0 , 4);
		}
		if (month == null || "".equals(month)) {
			month = sdate.substring(5 , 7);
		}
		List<Report> reportList = service.queryByDay(Integer.valueOf(year) , Integer.valueOf(month));
		
		List<Object> listData = new ArrayList<>();
		List<Object> listIn = new ArrayList<>();
		List<Object> listOut = new ArrayList<>();
		List<Object> listIncome = new ArrayList<>();
		
		for (Report report : reportList) {
			BigDecimal inbill = report.getInbill();
			BigDecimal outbill = report.getOutbill();
			BigDecimal subBill = inbill.subtract(outbill);
			String way = report.getWay();
			
			listIn.add(inbill);
			listOut.add(outbill);
			listIncome.add(subBill);
			listData.add(way);
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("listData" , JSONUtils.toJSONString(listData));
		mav.addObject("listIn" , JSONUtils.toJSONString(listIn));
		mav.addObject("listOut" , JSONUtils.toJSONString(listOut));
		mav.addObject("listIncome" , JSONUtils.toJSONString(listIncome));
		
		mav.setViewName("forward:/WEB-INF/views/PriceTotal.jsp");
		return mav;
	}
	
	//以月为单位 , 只需要指定年份
	@RequestMapping("line_month")
	public ModelAndView queryByMonth(HttpServletRequest request) {
		String year = request.getParameter("year");
        Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		String sdate = sd.format(date);
		if (year == null || "".equals(year) ) {
			year = sdate.substring(0 , 4);
		}
		List<Report> reportList = service.queryByMonth(Integer.valueOf(year));
		
		List<Object> listData = new ArrayList<>();
		List<Object> listIn = new ArrayList<>();
		List<Object> listOut = new ArrayList<>();
		List<Object> listIncome = new ArrayList<>();
		
		for (Report report : reportList) {
			BigDecimal inbill = report.getInbill();
			BigDecimal outbill = report.getOutbill();
			BigDecimal subBill = inbill.subtract(outbill);
			String way = report.getWay();
			
			listIn.add(inbill);
			listOut.add(outbill);
			listIncome.add(subBill);
			listData.add(way);
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("listData" , JSONUtils.toJSONString(listData));
		mav.addObject("listIn" , JSONUtils.toJSONString(listIn));
		mav.addObject("listOut" , JSONUtils.toJSONString(listOut));
		mav.addObject("listIncome" , JSONUtils.toJSONString(listIncome));
		
		mav.setViewName("forward:/WEB-INF/views/PriceTotal.jsp");
		return mav;
	}
	
	//以年为单位
	@RequestMapping("line_year")
	public ModelAndView queryByYear(HttpServletRequest request) {
		List<Report> reportList = service.queryByYear();
		
		List<Object> listData = new ArrayList<>();
		List<Object> listIn = new ArrayList<>();
		List<Object> listOut = new ArrayList<>();
		List<Object> listIncome = new ArrayList<>();
		
		for (Report report : reportList) {
			BigDecimal inbill = report.getInbill();
			BigDecimal outbill = report.getOutbill();
			BigDecimal subBill = inbill.subtract(outbill);
			String way = report.getWay();
			
			listIn.add(inbill);
			listOut.add(outbill);
			listIncome.add(subBill);
			listData.add(way);
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("listData" , JSONUtils.toJSONString(listData));
		mav.addObject("listIn" , JSONUtils.toJSONString(listIn));
		mav.addObject("listOut" , JSONUtils.toJSONString(listOut));
		mav.addObject("listIncome" , JSONUtils.toJSONString(listIncome));
		
		mav.setViewName("forward:/WEB-INF/views/PriceTotal.jsp");
		return mav;
	}
};
