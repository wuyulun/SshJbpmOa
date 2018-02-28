package com.hyjcy.oa.service;

import java.util.List;

import com.hyjcy.oa.base.DaoSupport;
import com.hyjcy.oa.domain.Privilege;



public interface PrivilegeService extends DaoSupport<Privilege> {

	/**
	 * 查询所有顶级的权限列表
	 * 
	 * @return
	 */
	List<Privilege> findTopList();

	/**
	 * @return
	 */
	
	/**
	 * 查询所有的URL集合
	 * @return
	 */
	List<String> getAllPrivilegeUrls();


}
