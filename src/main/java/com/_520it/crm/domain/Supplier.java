package com._520it.crm.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//供应商
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {
    private Long id;

    private String name;

    private String linkman;

    private String tel;

    private String good;

    private Integer cooperationtime;

    private String advantage;
}