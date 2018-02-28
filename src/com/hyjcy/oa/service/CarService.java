package com.hyjcy.oa.service;

import java.util.List;

import com.hyjcy.oa.base.DaoSupport;
import com.hyjcy.oa.domain.Car;
import com.hyjcy.oa.domain.Device;

public interface CarService extends DaoSupport<Car> {

	List<Car> list();

}
