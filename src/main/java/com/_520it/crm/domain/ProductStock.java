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
//库存对象
public class ProductStock {
    private Long id;
    //库存编号
    private String sn;
    //关联商品
    private Product product = new Product();
    //整装库存
    private BigDecimal readyStock;
    //散装库存
    private BigDecimal bulkstock;
    //库存结余
    private BigDecimal balancestock;
    //预警数量
    private BigDecimal warnningnum;
    //商品类别
    private String productCategory;
    //商品品牌
    private String productBrand;
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

}