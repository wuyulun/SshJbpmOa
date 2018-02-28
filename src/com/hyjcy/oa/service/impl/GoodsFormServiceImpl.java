package com.hyjcy.oa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyjcy.oa.base.DaoSupportImpl;
import com.hyjcy.oa.domain.Faultform;
import com.hyjcy.oa.domain.Goodsform;
import com.hyjcy.oa.domain.User;
import com.hyjcy.oa.service.GoodsformService;
import com.opensymphony.xwork2.ActionContext;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class GoodsFormServiceImpl extends DaoSupportImpl<Goodsform> implements GoodsformService{

	@Override
	public List<Goodsform> findAll() {
		String sql = "SELECT * FROM hyjcy_goodsform where gapplicantId = ? ORDER BY applytime DESC";
		User applicant = (User)ActionContext.getContext().getSession().get("user");
		return getSession().createSQLQuery(sql).addEntity(Goodsform.class).setParameter(0, applicant.getId()).list();
	}
	@Override
	public List<Goodsform> findDone() {
		String sql = "SELECT * FROM hyjcy_goodsform g WHERE g.status <> '审批中'  ORDER BY g.applytime DESC";
		return getSession().createSQLQuery(sql).addEntity(Goodsform.class).list();
	}


}
