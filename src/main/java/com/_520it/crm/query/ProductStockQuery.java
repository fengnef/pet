package com._520it.crm.query;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductStockQuery extends QueryObject {
    //商品条码/库存编码
    private String keyword;
    //商品名称
    private String productName;
    //商品类别
    private String category;

}
