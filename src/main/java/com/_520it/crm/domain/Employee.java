package com._520it.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter@Setter
public class Employee {
    private Long id;

    private String sn;

    private String username;


    //职位
    private PositionName positionName;
    //性别
    private Boolean sex;

    private Long phone;

    @DateTimeFormat(pattern = "yyyy-MM-dd" )
    @JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+8")
    private Date inductionTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd" )
    @JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+8")
    private Date departureTime;

    private BigDecimal basicSalary;

    private String idcard;

    private Boolean state;



    private Leaver leaver;

    private  BigDecimal total;
    //请假扣的工资
    private BigDecimal salary;
}