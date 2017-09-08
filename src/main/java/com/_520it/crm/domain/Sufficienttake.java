package com._520it.crm.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
@Getter
@Setter
@ToString
public class Sufficienttake {
    private Long id;
//会员卡的总金额
    private BigDecimal totalamount;
//最大充值金额
    private BigDecimal maxrechargeprice;
//历史消费额
    private BigDecimal amountspent;
//备注
    private String takeremarks;
//会员对象
    private Member membername;
//vip卡号
    private Vipmember vipmember;
//员工对象
    private Employee employee;

}