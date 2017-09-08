package com._520it.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Getter@Setter@NoArgsConstructor
@AllArgsConstructor

public class CheckstandRecord {
    private Long id;

    /**
     * 订单编号
     */
    private String ordersn;

    /**
     * 订单时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd" )
    @JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+8")
    private Date ordertime;

    /**
     * 商品总数
     */
    private Integer productcount;

    /**
     * 消费金额
     */
    private BigDecimal monetary;
    /**
     * 会员卡号
     */
    private Member member;
    /**
     * 店铺名称
     */
    private Shop shop;

    /**
     * 操作人
     */
    private Employee employee;

    @Override
    public String toString() {
        return "CheckstandRecord{" +
                "id=" + id +
                ", ordersn='" + ordersn + '\'' +
                ", ordertime=" + ordertime +
                ", productcount=" + productcount +
                ", monetary=" + monetary +
                '}';
    }
}