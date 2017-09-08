package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.Role;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;

public interface IRoleService {
	int deleteByPrimaryKey(Long id);

	int insert(Role record);

	Role selectByPrimaryKey(Long id);

	List<Role> selectAll();

	int updateByPrimaryKey(Role record);

	//查询分页结果
	PageResult queryPageResult(QueryObject qo);

	List<Long> getRolesIdByShopkeeperId(Long shopkeeperId);

    List<String> getRoleSnByShopkeeperId(Long shopkeeperId);

	List<Role> getRoleByShopkeeperId(Long shopkeeperId);

}
