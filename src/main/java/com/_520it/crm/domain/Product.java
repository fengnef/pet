package com._520it.crm.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id;

    private String sn;

    private String name;

    private ProductCategory productcategory;

    private Brand brand;

    private Manufacturer manufacturer;

    private ProductPomponent productpomponent;

    private String allergens;

    private Long saleprice;

    private Boolean state;

    /**
     * 关联库存表
     */
    private ProductStock productstock;

    /**
     * 关联入库表
     */
    private StockIncomeBillItem incomebillitem;

    /**
     * 关联员工表
     */
    private Employee employee;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", sn='" + sn + '\'' +
                ", name='" + name + '\'' +
                ", productcategory=" + productcategory +
                ", brand=" + brand +
                ", manufacturer=" + manufacturer +
                ", productpomponent=" + productpomponent +
                ", allergens='" + allergens + '\'' +
                ", saleprice=" + saleprice +
                ", state=" + state +
                ", productstock=" + productstock +
                ", incomebillitem=" + incomebillitem +
                ", employee=" + employee +
                '}';
    }
}