package com._520it.crm.service;

import com._520it.crm.domain.Product;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ProductQuery;

import java.util.List;

public interface IProductService {
    int deleteByPrimaryKey(Long id);

    int insert(Product record);

    Product selectByPrimaryKey(Long id);

    List<Product> selectAll();

    int updateByPrimaryKey(Product record);

    /**
     * 收银查询
     * @param sn 商品编码或者69码
     * @return
     */
    List<Product> selectCheckstand(String sn);

    PageResult queryPageResult(ProductQuery qo);

    /**
     * 根据商品69码查商品
     */
    Product getProductBySn(String sn);
}
