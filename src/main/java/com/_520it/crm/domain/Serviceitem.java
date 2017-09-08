package com._520it.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//宠物服务项目
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Serviceitem {
    private Long id;
    //服务项目名称
    private String text;
    //宠物服务根菜单
    private Long parentId;
    //服务价格
    private BigDecimal costprice;
    //服务次数
    private Integer units;
    //备注
    private String remark;
    //服务状态
    private String servicestatus;
    //付款状态
    private Boolean pay;
    //开始服务时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date begintime;
    //结束服务时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date endtime;
    //寄养时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date fostertime;

    List<Serviceitem> children = new ArrayList<>();

    //是否享受折扣
    private Boolean discount;
    //服务折扣
   private Integer specifieddiscount;
   //预付款
    private BigDecimal advancepayment;
    //尾款
    private BigDecimal retainage;
}