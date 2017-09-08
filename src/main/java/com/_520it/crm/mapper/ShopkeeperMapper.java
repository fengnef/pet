package com._520it.crm.mapper;

import com._520it.crm.domain.Employee;
import com._520it.crm.domain.Shopkeeper;
import com._520it.crm.query.EmployeeQuery;
import com._520it.crm.query.QueryObject;
import com._520it.crm.query.ShopkeeperQuery;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ShopkeeperMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Shopkeeper record);

    void  insertShopeekerRole(Shopkeeper record);

    void update(Shopkeeper record);

    int updateByPrimaryKey(Shopkeeper record);

    Shopkeeper selectByPrimaryKey(Long id);

    List<Shopkeeper> selectAll();


    Long queryPageCount(ShopkeeperQuery qo);

    List<Shopkeeper> queryPageResult(ShopkeeperQuery qo);

    Shopkeeper getShopkeeperByUsername(String username);

    void insertRelation(@Param("shopkeeperId")Long employeeId, @Param("roleId")Long roleId);

    void deleteRelation(Long shopkeeperId);

    void setLoginTime(@Param("shopkeeperId")Long shopkeeperId , @Param("logintime")Date logintime);

    void updateSheet(Shopkeeper shop);

    void inserShopkeeper();
}