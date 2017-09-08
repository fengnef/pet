package com._520it.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

//宠物
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Pet {

    private Long id;
    //宠物名称
    private String petname;
    //宠物性别
    private Boolean petgender;
    //宠物生日
    @DateTimeFormat(pattern = "yyyy-MM-dd" )
    @JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+8")
    private Date perbirthday;
    //过敏物
    private String petallergicmaterial;
    //特征
    private String petcharacteristic;
    //颜色
    private String petcolor;
    //血统登记号
    private String petlineageregisternumber;
    //宠物图片
    private String petpicture;
    //宠物状态(比如:正常,生病)
    private String petstatus;
    //暂时不写,等会员弄好再搞
    private Member member;
    //血统登记处
    private String petlineageregistry;
    //服务项目
    private Serviceitem serviceitem;
    //类别
    private Category category;
    //品种
    private Breed breed;




}