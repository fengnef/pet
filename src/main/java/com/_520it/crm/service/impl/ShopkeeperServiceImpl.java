package com._520it.crm.service.impl;

import com._520it.crm.domain.Employee;
import com._520it.crm.domain.Role;
import com._520it.crm.domain.Shopkeeper;
import com._520it.crm.mapper.ShopkeeperMapper;
import com._520it.crm.mapper.ShopkeeperMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.query.ShopkeeperQuery;
import com._520it.crm.service.IShopkeeperService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class ShopkeeperServiceImpl implements IShopkeeperService {
	@Autowired
	private ShopkeeperMapper  mapper;

	@Override
	public int deleteByPrimaryKey(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

// 店铺更新功能
	public void updateSheet(Shopkeeper shop) {
		mapper.updateSheet(shop);
	}

//	店主注册
	public void inserShopkeeper(Shopkeeper shop) {
		mapper.inserShopkeeper();
	}


	@Override
	public int insert(Shopkeeper record) {
		//密码加密(直接使用用户名当做盐)
		record.setPassword(new Md5Hash(record.getPassword(),record.getUsername()).toString());

		int count = mapper.insert(record);

		//处理中间表关联关系
		List<Role> roles = record.getRoles();
		if (roles.size() > 0) {
			for (Role role : roles) {
				mapper.insertRelation(record.getId(), role.getId());
			}
		}
		return count;
	}

	@Override
	public Shopkeeper selectByPrimaryKey(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Shopkeeper> selectAll() {
		return mapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Shopkeeper record) {

		//先删除中间表关系
		mapper.deleteRelation(record.getId());

		//重新关联关系
		List<Role> roles = record.getRoles();
		if (roles.size() > 0) {
			for (Role role : roles) {
				mapper.insertRelation(record.getId(), role.getId());
			}
		}

		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public Shopkeeper getShopkeeperByUsername(String username) {
		return mapper.getShopkeeperByUsername(username);
	}

	@Override
	public void setLoginTime(Long shopkeeperId, Date logintime) {
		mapper.setLoginTime(shopkeeperId,logintime);
	}

	@Override
	public void insertShopeekerRole(Shopkeeper record) {
		//密码加密(直接使用用户名当做盐)
		record.setPassword(new Md5Hash(record.getPassword(),record.getUsername()).toString());

		 mapper.insert(record);

		//处理中间表关联关系
		List<Role> roles = record.getRoles();
		if (roles.size() > 0) {
			for (Role role : roles) {
				mapper.insertRelation(record.getId(), role.getId());
			}
		}
	}

	@Override
	public void update(Shopkeeper record) {
		//先删除中间表关系
		mapper.deleteRelation(record.getId());

		//重新关联关系
		List<Role> roles = record.getRoles();
		if (roles.size() > 0) {
			for (Role role : roles) {
				mapper.insertRelation(record.getId(), role.getId());
			}
		}
		 mapper.update(record);
	}


	@Override
	public PageResult queryPageResult(ShopkeeperQuery qo) {
		//查询总结果数
		Long count = mapper.queryPageCount(qo);
		if (count == 0) {
			return new PageResult(count, Collections.EMPTY_LIST);
		}
		//查询结果集
		return new PageResult(count, mapper.queryPageResult(qo));
	}


}
