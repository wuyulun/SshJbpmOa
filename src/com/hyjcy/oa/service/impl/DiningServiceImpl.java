package com.hyjcy.oa.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyjcy.oa.base.DaoSupportImpl;
import com.hyjcy.oa.domain.DiningRecord;
import com.hyjcy.oa.domain.User;
import com.hyjcy.oa.service.DiningService;
import com.opensymphony.xwork2.ActionContext;

@Service
@Transactional
public class DiningServiceImpl extends DaoSupportImpl<DiningRecord> implements DiningService{

	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		/*String sql = "delete from dining_today where userId = ?";
		User diner = (User)ActionContext.getContext().getSession().get("user");
		getSession().createSQLQuery(sql).addEntity(DiningRecord.class).setParameter(0, diner.getId());*/
		
		String sql = "update hyjcy_diningrecord_today set lunch=0 where userId = ?";
		User diner = (User)ActionContext.getContext().getSession().get("user");
		int result = getSession().createSQLQuery(sql).addEntity(DiningRecord.class).setParameter(0, diner.getId()).executeUpdate();
		System.out.println(result);
		
	}

	@Override
	public void book() {
		// TODO Auto-generated method stub
		String sql = "update hyjcy_diningrecord_today set dinner=1 where userId = ?";
		User diner = (User)ActionContext.getContext().getSession().get("user");
		/*System.out.println(diner.getId());*/
		int result = getSession().createSQLQuery(sql).addEntity(DiningRecord.class).setParameter(0, diner.getId()).executeUpdate();
		System.out.println(result);
	}

	@Override
	public int statistics_am() {
		// TODO Auto-generated method stub
		int count = 0;
		String sql = "select count(*) from hyjcy_diningrecord_today where lunch = 1";
		/*int count = (Integer)getSession().createSQLQuery(sql).addEntity(DiningRecord.class).uniqueResult();*/
		Object obj = getSession().createSQLQuery(sql).uniqueResult();//加.addEntity(DiningRecord.class)要报错，原因不详
			if (obj instanceof BigInteger) {  
				BigInteger bi = (BigInteger)obj;  
				count = bi.intValue();  
			}
		return count;
	}
	
	
	@Override
	public int statistics_pm() {
		// TODO Auto-generated method stub
		int count = 0;
		String sql = "select count(*) from hyjcy_diningrecord_today where dinner = 1";
		Object obj = getSession().createSQLQuery(sql).uniqueResult();
			if (obj instanceof BigInteger) {  
				BigInteger bi = (BigInteger)obj;  
				count = bi.intValue();  
			}
		return count;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<DiningRecord> list_am() {
		// TODO Auto-generated method stub
		String sql = "select * from hyjcy_diningrecord_today where lunch=1";
		return getSession().createSQLQuery(sql).addEntity(DiningRecord.class).list();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DiningRecord> list_pm() {
		// TODO Auto-generated method stub
		String sql = "select * from hyjcy_diningrecord_today where dinner=1";
		return getSession().createSQLQuery(sql).addEntity(DiningRecord.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DiningRecord> record() {//显示用餐记录的日期列表
		// TODO Auto-generated method stub
		String sql = "select * from hyjcy_diningrecord_his group by day desc limit 50";
		return getSession().createSQLQuery(sql).addEntity(DiningRecord.class).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DiningRecord> record_am_list(String date) {//显示指定日期的中餐用餐记录
		// TODO Auto-generated method stub
		String sql = "select * from hyjcy_diningrecord_his where lunch = 1 and day = ?";
		return getSession().createSQLQuery(sql).addEntity(DiningRecord.class).setParameter(0, date).list();	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DiningRecord> record_pm_list(String date) {//显示指定日期的晚餐用餐记录
		// TODO Auto-generated method stub
		String sql = "select * from hyjcy_diningrecord_his where dinner = 1 and day = ?";
		return getSession().createSQLQuery(sql).addEntity(DiningRecord.class).setParameter(0, date).list();
	}

}
