package com._520it.crm.mapper;

import com._520it.crm.domain.Product;
import com._520it.crm.domain.ProductCategory;
import com._520it.crm.query.ProductCategoryQuery;
import com._520it.crm.query.ProductQuery;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Product record);

    Product selectByPrimaryKey(Long id);

    List<Product> selectAll();

    int updateByPrimaryKey(Product record);

    /**
     * 收银查询
     * @return
     */
    List<Product> selectCheckstand();

    Long queryPageCount(ProductQuery qo);

    List<Product> queryPageResult(ProductQuery qo);

    /**
     * 根据商品69码查商品
     */
   Product getProductBySn(String sn);
}