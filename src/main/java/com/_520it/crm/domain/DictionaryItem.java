package com._520it.crm.domain;

import lombok.*;

@Getter@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DictionaryItem {
    private Long id;
    //字典目录编号
    private String sn;
    //字典明细名称
    private String name;
    //字典明细简介
    private String intro;
    //多对一
    private Dictionary dictionary;

}