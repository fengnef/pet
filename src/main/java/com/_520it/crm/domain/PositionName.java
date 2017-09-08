package com._520it.crm.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter@Setter
public class PositionName {
    private Long id;
    //职位名称
    private String positionname;
    //岗位津贴
    private BigDecimal postallowance;
    //交通补贴
    private BigDecimal trafficsubsidies;
    //话费补贴
    private BigDecimal phonesubsidies;
    //餐补
    private BigDecimal subsidizedmeals;
    //全勤
    private BigDecimal fulltime;
    //提成比例(%)
    private BigDecimal commission;



}