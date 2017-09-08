package com._520it.crm.realm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com._520it.crm.domain.Employee;
import com._520it.crm.domain.Shopkeeper;
import com._520it.crm.service.IShopkeeperService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com._520it.crm.service.IEmployeeService;
import com._520it.crm.service.IPermissionService;
import com._520it.crm.service.IRoleService;

public class MyRealm extends AuthorizingRealm{

	@Autowired
	private IShopkeeperService shopkeeperService;
	@Autowired
	private IPermissionService permissionService;
	@Autowired
	private IRoleService roleService;

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//获取用户输入的用户名
		Object principal = token.getPrincipal();
		//判断数据库中是否存在该用户名,如果没有则返回null
		Shopkeeper  shopkeeper = shopkeeperService.getShopkeeperByUsername((String)principal);

		if( shopkeeper==null){
			return null;
		}
		//记录登录时间
		shopkeeperService.setLoginTime(shopkeeper.getId(),new Date());

		//如果有则返回info,包括一些正确凭证之类的数据(此时传的身份信息是一个员工对象)
		//传入盐(用户名就是盐)
		SimpleAuthenticationInfo info
		= new SimpleAuthenticationInfo( shopkeeper, shopkeeper.getPassword(),ByteSource.Util.bytes( shopkeeper.getUsername()),this.getName());
		return info;
	}


	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//从数据库中查询
		Shopkeeper shopkeeper = (Shopkeeper)principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		List roles = null;
		List permissions = null;
		//如果是管理员则不需要查询
		if(shopkeeper.getAdmin()){
			roles = new ArrayList<>();
			roles.add("admin");
			permissions = new ArrayList<>();
			permissions.add("*:*");
		}else{
			//查询数据库的角色集合
			roles = roleService.getRoleSnByShopkeeperId(shopkeeper.getId());
			//查询数据库的权限集合
			permissions = permissionService.getResourceByEmployeeId(shopkeeper.getId());
		}
		//添加角色集合
		info.addRoles(roles);
		//添加权限集合
		info.addStringPermissions(permissions);
		return info;
	}

}
