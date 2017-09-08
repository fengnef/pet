package com._520it.crm.service.impl;

import com._520it.crm.domain.Product;
import com._520it.crm.mapper.ProductMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ProductQuery;
import com._520it.crm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Product record) {
        return productMapper.insert(record);
    }

    @Override
    public Product selectByPrimaryKey(Long id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Product> selectAll() {
        return productMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Product record) {
        return productMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Product> selectCheckstand(String sn) {
        return productMapper.selectCheckstand();
    }

    @Override
    public PageResult queryPageResult(ProductQuery qo) {
        Long count = productMapper.queryPageCount(qo);
        if (count==0) {
            return new PageResult(count, Collections.EMPTY_LIST);
        }
        return new PageResult(count,productMapper.queryPageResult(qo));
    }

    /**
     * 根据商品69码查商品
     */
    @Override
    public Product getProductBySn(String sn) {
        return productMapper.getProductBySn(sn);
    }
}
