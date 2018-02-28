package com.hyjcy.oa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyjcy.oa.base.DaoSupportImpl;
import com.hyjcy.oa.domain.Privilege;
import com.hyjcy.oa.service.PrivilegeService;



@Service
@Transactional
@SuppressWarnings("unchecked")
public class PrivilegeServiceImpl extends DaoSupportImpl<Privilege> implements PrivilegeService {

	//查询顶级权限列表
	public List<Privilege> findTopList() {
		return getSession().createQuery(//
				"FROM Privilege p WHERE p.parent IS NULL")//
				.list();
	}

	//查询所有的URL集合（不包含null值和重复的值）
	public List<String> getAllPrivilegeUrls() {
		return getSession().createQuery(//查询不重复的url
				"SELECT DISTINCT p.url FROM Privilege p WHERE p.url IS NOT NULL ")//
				.list();
	}

	

	
}
