package com._520it.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@ToString
public class Sufficientitem {
    private Long id;
    //充值订单明细表
//    充值订单
    private String rechargenumber;
    //充值门店编号
    private String usergroupcode;
    //充值门店名称
    private String usergroupname;
    //充值时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date rechargetime;
    //充值金额
    private BigDecimal rechargeprice;
    //备注
    private String itemremarks;

    //会员
    private Member membername;
    //    会员等级
    private Vipmember vipmember;

}