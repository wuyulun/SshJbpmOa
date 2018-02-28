package com.hyjcy.oa.service;

import java.util.List;

import com.hyjcy.oa.base.DaoSupport;
import com.hyjcy.oa.domain.Device;

public interface DeviceService extends DaoSupport<Device> {

	void addDevice(Device device);

	List<Device> allInfo();

	List<Device> myInfo();

}
