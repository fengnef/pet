package com._520it.crm.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dictionary {
    private Long id;
    //字典目录编号
    private String sn;
    //字典目录名称
    private String name;
    //字典目录简介
    private String intro;


}