package com._520it.crm.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//商品成分
@Setter@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductPomponent {
    private Long id;
    //商品成分名称
    private String pomponentname;
    //是否启用
    private Boolean start;

}