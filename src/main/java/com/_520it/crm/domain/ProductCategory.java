package com._520it.crm.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//商品类目
@Setter@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategory {
    private Long id;
    //商品类别
    private String category;
    //商品种类
    private String kind;
    //是否启用
    private Boolean start;
}