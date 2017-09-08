package com._520it.crm.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Breed {
    private Long id;
    //品种名称
    private String petbreedname;
    //关联类别
    private Long categoryId;
    //关联宠物
    private Long petId;

}