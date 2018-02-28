package com.hyjcy.oa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyjcy.oa.base.DaoSupportImpl;
import com.hyjcy.oa.domain.Goodsform;
import com.hyjcy.oa.domain.Usecarform;
import com.hyjcy.oa.domain.User;
import com.hyjcy.oa.service.UsecarFormService;
import com.hyjcy.oa.service.UsecarService;
import com.hyjcy.oa.service.UserService;
import com.opensymphony.xwork2.ActionContext;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class UsecarformServiceImpl extends DaoSupportImpl<Usecarform> implements UsecarFormService{
  
	@Override
	public List<Usecarform> findAll() {
		String sql = "SELECT * FROM hyjcy_usecarform where uapplicantId = ? ORDER BY applytime DESC";
		User applicant = (User)ActionContext.getContext().getSession().get("user");
		return getSession().createSQLQuery(sql).addEntity(Usecarform.class).setParameter(0, applicant.getId()).list();
	}

	@Override
	public List<Usecarform> findDone() {
		String sql = "SELECT * FROM hyjcy_usecarform u WHERE u.status <> '审批中'  ORDER BY u.applytime DESC";
		return getSession().createSQLQuery(sql).addEntity(Usecarform.class).list();
	}

	@Override
	public List<Usecarform> findover() {
		String sql = "SELECT * FROM hyjcy_usecarform u WHERE u.status = '已通过'  ORDER BY u.applytime DESC";
		return getSession().createSQLQuery(sql).addEntity(Usecarform.class).list();
	}

}
