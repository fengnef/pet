package com._520it.crm.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class CheckstandRecordQuery extends QueryObject{
	private String ordersn;


	@DateTimeFormat(pattern = "yyyy-MM-dd" )
	@JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+8")
	private Date currentDate;

}
