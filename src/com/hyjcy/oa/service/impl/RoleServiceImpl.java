package com.hyjcy.oa.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyjcy.oa.base.DaoSupportImpl;
import com.hyjcy.oa.domain.Role;
import com.hyjcy.oa.service.RoleService;

/**
 * 
 * @ClassName: RoleServiceImpl
 * @Description: 角色管理业务逻辑层
 * @Author: wyxx
 * @Date: 2016年8月23日 上午8:44:09
 * @version V1.0
 */

@Service
@Transactional
public class RoleServiceImpl extends DaoSupportImpl<Role> implements RoleService {

}
