package com.hyjcy.oa.service;

import com.hyjcy.oa.base.DaoSupport;
import com.hyjcy.oa.domain.User;


public interface UserService extends DaoSupport<User> {

	/**
	 * 验证用户名与密码，如果正确就返回这个用户，否则返回null
	 * 
	 * @param loginName
	 * @param password 明文密码
	 * @return
	 */
	User findByLoginNameAndPassword(String loginName, String password);
	
	/**
	 * 根据用登录名查询员工
	 * @param name 员工的用户名
	 * @return 符合用户名的员工
	 */ 
	User findByName(String loginName);
	/**
	 * 根据用登录名查询员工
	 * @param name 员工的用户名
	 * @return 符合用户名的员工
	 */ 
	void change(User user);

}
