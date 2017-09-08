package com._520it.crm.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString
public class Member {
    private Long id;
    //会员名
    private String membername;
    //首冲金额
    private BigDecimal memberprice;
    //  性别
    private Boolean membersex;
    //生日
    @DateTimeFormat(pattern = "yyyy-MM-dd" )
    @JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+8")
    private Date memberbirthday;
    //住址
    private String memberarddess;
    //备注
    private String membernote;
    //  会员状态状态
    private Boolean memberstart;
    //电话号码
    private Long membernumber;
    //会员等级
    private Vipmember vipmember;
//    消费记录
     private Sufficienttake sufficienttake;
//宠物对象
     private Pet pet;

}