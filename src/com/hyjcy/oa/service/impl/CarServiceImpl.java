package com.hyjcy.oa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyjcy.oa.base.DaoSupportImpl;
import com.hyjcy.oa.domain.Car;
import com.hyjcy.oa.domain.Device;
import com.hyjcy.oa.domain.User;
import com.hyjcy.oa.service.CarService;
import com.hyjcy.oa.service.DeviceService;
import com.opensymphony.xwork2.ActionContext;

@Service
@Transactional
public class CarServiceImpl extends DaoSupportImpl<Car> implements CarService{

	@SuppressWarnings("unchecked")
	@Override
	public List<Car> list() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM hyjcy_car";
		return getSession().createSQLQuery(sql).addEntity(Car.class).list();		
	}

}
