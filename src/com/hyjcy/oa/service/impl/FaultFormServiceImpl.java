package com.hyjcy.oa.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyjcy.oa.base.DaoSupportImpl;
import com.hyjcy.oa.domain.Faultform;
import com.hyjcy.oa.domain.User;
import com.hyjcy.oa.service.FaultFormService;
import com.opensymphony.xwork2.ActionContext;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class FaultFormServiceImpl extends DaoSupportImpl<Faultform> implements FaultFormService{
	
	
	@Override
	public List<Faultform> findAll() {
		String sql = "SELECT * FROM hyjcy_faultform where applicantId = ? ORDER BY applytime DESC";
		User applicant = (User)ActionContext.getContext().getSession().get("user");
		return getSession().createSQLQuery(sql).addEntity(Faultform.class).setParameter(0, applicant.getId()).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Faultform> findDone() {
		String sql = "SELECT * FROM hyjcy_faultform f WHERE f.status = '已通过' ORDER BY f.applytime DESC";
		return getSession().createSQLQuery(sql).addEntity(Faultform.class).list();
	}

}
