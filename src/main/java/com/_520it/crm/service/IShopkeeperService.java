package com._520it.crm.service;

import com._520it.crm.domain.Shopkeeper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ShopkeeperQuery;

import java.util.Date;
import java.util.List;

public interface IShopkeeperService {
	int deleteByPrimaryKey(Long id);

	int insert(Shopkeeper record);

	Shopkeeper selectByPrimaryKey(Long id);

	List<Shopkeeper> selectAll();

	int updateByPrimaryKey(Shopkeeper record);

	PageResult queryPageResult(ShopkeeperQuery qo);

	Shopkeeper getShopkeeperByUsername(String username);

	void setLoginTime(Long shopkeeperId ,Date logintime);

	void  insertShopeekerRole(Shopkeeper record);

	void update(Shopkeeper record);

    void updateSheet(Shopkeeper shop);

    void inserShopkeeper(Shopkeeper  shop);
}
