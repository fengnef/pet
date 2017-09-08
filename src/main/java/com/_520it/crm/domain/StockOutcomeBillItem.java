package com._520it.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
//订单明细
public class StockOutcomeBillItem {
    private Long id;

    //private Long productId;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inputtime;
    //成本
    private BigDecimal costPrice;
    //售价
    private BigDecimal saleprice;
    //会员价
    private BigDecimal memberprice;
    //数量
    private BigDecimal count;
    //总成本
    private BigDecimal totalamout;
    //预警日期
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date warningdate;
    //保质期
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date warrantydate;
    //操作人
    private String operator;
    //商品名称
    private String productName;
    //商品类别
    private String productCategory;
    //商品规格
    private String productSpecification;
    //分店
    private String subStore;
}