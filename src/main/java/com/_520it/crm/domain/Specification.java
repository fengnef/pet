package com._520it.crm.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//商品规格
@Setter@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Specification {
    private Long id;

    private String name;

    private Boolean state;

}