package com._520it.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString
public class Shopkeeper {
//    店铺信息domain
    private Long id;

//    店铺名字
    private String storeName;
   // 店铺负责人 姓名
    private String storehead;
//店铺手机号
    private Long contactmobile;
//店铺传值
    private Long storefax;
//店铺地址
    private String province;
//成立时间
@DateTimeFormat(pattern = "yyyy-MM-dd" )
@JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+8")
    private Date setuptime;
//店铺详情
    private String storeintroduce;
//店铺图片
    private String picture;
//密码
    private String password;
//店主登入名
    private String username;
//店铺介绍
    private String storintroduce;
//主营项目
    private Long businesstype;

    private Boolean admin;
    @DateTimeFormat(pattern = "yyyy-MM-dd" )
    @JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+8")
    private Date logintime;

    private List<Role> roles = new ArrayList<>();


}