package com._520it.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

//系统日志
@Setter@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Systemlog {
    private Long id;
    //操作用户
    private Shopkeeper opuser;
    //操作时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss" )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    private Date optime;
    //操作ip
    private String opip;
    //执行的操作
    private String function;
    //参数
    private String params;
}