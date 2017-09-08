package com._520it.crm.mapper;

import com._520it.crm.domain.Shop;
import java.util.List;

public interface ShopMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Shop record);

    Shop selectByPrimaryKey(Long id);

    List<Shop> selectAll();

    int updateByPrimaryKey(Shop record);
}