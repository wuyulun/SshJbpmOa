package com.hyjcy.oa.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyjcy.oa.base.DaoSupportImpl;
import com.hyjcy.oa.domain.User;
import com.hyjcy.oa.service.UserService;



@Service
@Transactional
public class UserServiceImpl extends DaoSupportImpl<User> implements UserService {

	@Override
	public void save(User user) { 
		// 默认密码1234
		String md5 = DigestUtils.md5Hex("1234"); // 密码要使用MD5摘要
		user.setPassword(md5);
		// 保存到数据库
		getSession().save(user);
	}
	public void change(User user) { 
		// 默认密码1234
		String md5 = DigestUtils.md5Hex(user.getPassword()); // 密码要使用MD5摘要
		user.setPassword(md5);
		// 保存到数据库
		getSession().save(user);
	}

	public User findByLoginNameAndPassword(String loginName, String password) {
		String md5 = DigestUtils.md5Hex(password);
		return (User) getSession().createQuery(//
				"FROM User u WHERE u.loginName=? AND u.password=?")//
				.setParameter(0, loginName)//
				.setParameter(1, md5)// 密码要使用MD5摘要
				.uniqueResult();//返回结果为一个，有多个结果时会报错
	}


	@Override
	public User findByName(String loginName) {
		
		return (User) getSession().createQuery("FROM User u WHERE u.loginName=?");
	}

}
