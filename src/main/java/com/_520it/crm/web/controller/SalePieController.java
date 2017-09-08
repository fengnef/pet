package com._520it.crm.web.controller;


import com._520it.crm.domain.SalePie;
import com._520it.crm.service.ISalePieService;
import com.alibaba.druid.support.json.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class SalePieController {
	
	@Autowired
	private ISalePieService service;
	
	//以天为单位 ,需要指定年月日
	@RequestMapping("/pie")
	public ModelAndView queryDay(String date){
		if(date == null||"".equals(date)){
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			date = sd.format(new Date());
		}
		System.err.println(date);
		ModelAndView mav = new ModelAndView();
		List<SalePie> salePies = service.queryDay(date);
		
		List<Object> listData = new ArrayList<>();
		List<Object> listNumber = new ArrayList<>();
		List<Object> listAmount = new ArrayList<>();
		
		List<Map<String, Object>> listMap = new ArrayList<>();
		
		for (SalePie salePie : salePies) {
			Map<String,Object> map = new HashMap<>();
			map.put("value",salePie.getSaleprice());   //销售金额
			map.put("name",salePie.getPkind().getCategory());//名称
			
			
			listMap.add(map);                               //销售金额
			listData.add(salePie.getPkind().getCategory()); //分组名称
			listNumber.add(salePie.getSalenumber());    //数量
			listAmount.add(salePie.getSaleprice());     //总利润
		}
		
		mav.addObject("listData", JSONUtils.toJSONString(listData));
		mav.addObject("listNumber", JSONUtils.toJSONString(listNumber));
		mav.addObject("listAmount", JSONUtils.toJSONString(listAmount));
		mav.addObject("listMap", JSONUtils.toJSONString(listMap));
		
		System.err.println(listMap);
		mav.setViewName("forward:/WEB-INF/views/ClassSellScale.jsp");
		return mav;
	}
	//以天为单位 ,需要指定年月日
	@RequestMapping("/pies")
	public ModelAndView queryDays(String date){
		if(date == null||"".equals(date)){
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			date = sd.format(new Date());
		}
		System.err.println(date);
		List<SalePie> salePies = service.queryDay(date);
		
		ModelAndView mav = new ModelAndView();
		List<Object> listData = new ArrayList<>();
		List<Object> listNumber = new ArrayList<>();
		List<Object> listAmount = new ArrayList<>();
		
		List<Map<String, Object>> listMap = new ArrayList<>();
		List<Map<String, Object>> listMap1 = new ArrayList<>();
		
		
		for (SalePie salePie : salePies) {
			Map<String,Object> map = new HashMap<>();
			map.put("value",salePie.getSalenumber());   //销售数量
			map.put("name",salePie.getPkind().getCategory());//名称
			
			
			listMap.add(map);                               //销售数量
			listData.add(salePie.getPkind().getCategory()); //分组名称
			listNumber.add(salePie.getSalenumber());    //数量
			listAmount.add(salePie.getSaleprice());     //总利润
		}
		
		mav.addObject("listData", JSONUtils.toJSONString(listData));
		mav.addObject("listNumber", JSONUtils.toJSONString(listNumber));
		mav.addObject("listAmount", JSONUtils.toJSONString(listAmount));
		mav.addObject("listMap", JSONUtils.toJSONString(listMap));
		
		System.err.println(listMap);
		mav.setViewName("forward:/WEB-INF/views/ClassSellScale.jsp");
		return mav;
	}
	
	
	//以月为单位 , 只需要指定年份和月
	@RequestMapping("/pie_month")
	public ModelAndView queryMonth(HttpServletRequest request){
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
		
		List<SalePie> salePies = service.queryMonth(year,month);
		List<Object> listData = new ArrayList<>();
		List<Object> listNumber = new ArrayList<>();
		List<Object> listAmount = new ArrayList<>();
		ModelAndView mav = new ModelAndView();
		List<Map<String, Object>> listMap = new ArrayList<>();
		
		for (SalePie salePie : salePies) {
			Map<String,Object> map = new HashMap<>();
			map.put("value",salePie.getSaleprice());   //销售金额
			map.put("name",salePie.getPkind().getCategory());//名称
			
			
			listMap.add(map);                               //销售金额
			listData.add(salePie.getPkind().getCategory()); //分组名称
			listNumber.add(salePie.getSalenumber());    //数量
			listAmount.add(salePie.getSaleprice());     //总利润
		}
		
		mav.addObject("listData", JSONUtils.toJSONString(listData));
		mav.addObject("listNumber", JSONUtils.toJSONString(listNumber));
		mav.addObject("listAmount", JSONUtils.toJSONString(listAmount));
		mav.addObject("listMap", JSONUtils.toJSONString(listMap));
		
		System.err.println(listMap);
		mav.setViewName("forward:/WEB-INF/views/ClassSellScale.jsp");
		return mav;
	}
	@RequestMapping("/pie_months")
	public ModelAndView queryMonths(HttpServletRequest request){
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
		
		List<SalePie> salePies = service.queryMonth(year,month);
		List<Object> listData = new ArrayList<>();
		List<Object> listNumber = new ArrayList<>();
		List<Object> listAmount = new ArrayList<>();
		ModelAndView mav = new ModelAndView();
		List<Map<String, Object>> listMap = new ArrayList<>();
		
		for (SalePie salePie : salePies) {
			Map<String,Object> map = new HashMap<>();
			map.put("value",salePie.getSalenumber());   //销售金额
			map.put("name",salePie.getPkind().getCategory());//名称
			
			
			listMap.add(map);                               //销售金额
			listData.add(salePie.getPkind().getCategory()); //分组名称
			listNumber.add(salePie.getSalenumber());    //数量
			listAmount.add(salePie.getSaleprice());     //总利润
		}
		
		mav.addObject("listData", JSONUtils.toJSONString(listData));
		mav.addObject("listNumber", JSONUtils.toJSONString(listNumber));
		mav.addObject("listAmount", JSONUtils.toJSONString(listAmount));
		mav.addObject("listMap", JSONUtils.toJSONString(listMap));
		
		System.err.println(listMap);
		mav.setViewName("forward:/WEB-INF/views/ClassSellScale.jsp");
		return mav;
	}
	
	//以年为单位
	@RequestMapping("/pie_year")
	public ModelAndView queryYear(String year){
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		String sdate = sd.format(date);
		if (year == null || "".equals(year) ) {
			year = sdate.substring(0 , 4);
		}
		List<SalePie> salePies = service.queryYear(year);
		List<Object> listData = new ArrayList<>();
		List<Object> listNumber = new ArrayList<>();
		List<Object> listAmount = new ArrayList<>();
		ModelAndView mav = new ModelAndView();
		List<Map<String, Object>> listMap = new ArrayList<>();
		
		for (SalePie salePie : salePies) {
			Map<String,Object> map = new HashMap<>();
			map.put("value",salePie.getSaleprice());   //销售金额
			map.put("name",salePie.getPkind().getCategory());//名称
			
			
			listMap.add(map);                               //销售金额
			listData.add(salePie.getPkind().getCategory()); //分组名称
			listNumber.add(salePie.getSalenumber());    //数量
			listAmount.add(salePie.getSaleprice());     //总利润
		}
		
		mav.addObject("listData", JSONUtils.toJSONString(listData));
		mav.addObject("listNumber", JSONUtils.toJSONString(listNumber));
		mav.addObject("listAmount", JSONUtils.toJSONString(listAmount));
		mav.addObject("listMap", JSONUtils.toJSONString(listMap));
		
		System.err.println(listMap);
		mav.setViewName("forward:/WEB-INF/views/ClassSellScale.jsp");
		return mav;
	}
	@RequestMapping("/pie_years")
	public ModelAndView queryYears(String year){
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		String sdate = sd.format(date);
		if (year == null || "".equals(year) ) {
			year = sdate.substring(0 , 4);
		}
		List<SalePie> salePies = service.queryYear(year);
		List<Object> listData = new ArrayList<>();
		List<Object> listNumber = new ArrayList<>();
		List<Object> listAmount = new ArrayList<>();
		ModelAndView mav = new ModelAndView();
		List<Map<String, Object>> listMap = new ArrayList<>();
		
		for (SalePie salePie : salePies) {
			Map<String,Object> map = new HashMap<>();
			map.put("value",salePie.getSalenumber());   //销售金额
			map.put("name",salePie.getPkind().getCategory());//名称
			
			
			listMap.add(map);                               //销售金额
			listData.add(salePie.getPkind().getCategory()); //分组名称
			listNumber.add(salePie.getSalenumber());    //数量
			listAmount.add(salePie.getSaleprice());     //总利润
		}
		
		mav.addObject("listData", JSONUtils.toJSONString(listData));
		mav.addObject("listNumber", JSONUtils.toJSONString(listNumber));
		mav.addObject("listAmount", JSONUtils.toJSONString(listAmount));
		mav.addObject("listMap", JSONUtils.toJSONString(listMap));
		
		System.err.println(listMap);
		mav.setViewName("forward:/WEB-INF/views/ClassSellScale.jsp");
		return mav;
	}
}
