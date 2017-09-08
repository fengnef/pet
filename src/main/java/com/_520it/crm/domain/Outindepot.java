package com._520it.crm.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//出入库方式
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Outindepot {
    private Long id;
    //出入库方式名称
    private String name;
    //是否启用
    private Boolean state;
}