package com._520it.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
//出库单
public class StockOutcomeBill {
    private Long id;
    //库存编码
    private String sn;
    private Long productId;
    //录入时间
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inputtime;
    //最小单位
    private String minunit;
    //最小单位
    private String maxunit;
    //数量
    private BigDecimal count;
    //总数
    private BigDecimal totalamount;
    //售价
    private BigDecimal saleprice;
    //会员价
    private BigDecimal discount;
    //出货价
    private BigDecimal costPrice;
    //订单关联商品
    // private Product product;
    //商品69码
    private String productSn;
    //商品名称
    private String productName;
    //商品类别
    private String productCategory;
    //商品规格
    private String productSpecification;
    //保质期
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date warrantyDate;
    //生产日期
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date productDate;
    //入货商店
    private String subStore;

}