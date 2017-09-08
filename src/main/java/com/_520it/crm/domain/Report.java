package com._520it.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Getter@Setter
public class Report {
    private Long id;
	//出账
    private BigDecimal outbill;
	//入账
    private BigDecimal inbill;
	//日期,按日期分组
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date billdate;
	
	private String way;
}