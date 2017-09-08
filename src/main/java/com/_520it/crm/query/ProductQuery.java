package com._520it.crm.query;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ProductQuery extends QueryObject {
    private String productName;
    private Long categoryId;
    private Long brandId;
    private String pomponent;
}
