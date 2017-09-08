package com._520it.crm.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//系统管理打宠物种类
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Petkindandcategory {
    private Long id;

    private String petcategory;

    private String petkind;

    private Boolean state;

}