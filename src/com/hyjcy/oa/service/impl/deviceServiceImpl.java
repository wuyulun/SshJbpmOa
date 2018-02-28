package com.hyjcy.oa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyjcy.oa.base.DaoSupportImpl;
import com.hyjcy.oa.domain.Device;
import com.hyjcy.oa.domain.User;
import com.hyjcy.oa.service.DeviceService;
import com.opensymphony.xwork2.ActionContext;

@Service
@Transactional
public class deviceServiceImpl extends DaoSupportImpl<Device> implements DeviceService{

	@SuppressWarnings("unchecked")
	@Override
	public List<Device> allInfo() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM hyjcy_device ORDER BY possessor";
		return getSession().createSQLQuery(sql).addEntity(Device.class).list();		
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Device> myInfo() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM hyjcy_device WHERE possessor = ?";
		User possessor = (User)ActionContext.getContext().getSession().get("user");
		return getSession().createSQLQuery(sql).addEntity(Device.class).setParameter(0, possessor.getName()).list();
	}
	
	@Override
	public void addDevice(Device device) {
		// TODO Auto-generated method stub
		getSession().save(device);
	}

}
