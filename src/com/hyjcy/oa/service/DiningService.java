package com.hyjcy.oa.service;

import java.util.List;

import com.hyjcy.oa.base.DaoSupport;
import com.hyjcy.oa.domain.DiningRecord;

public interface DiningService extends DaoSupport<DiningRecord> {

	void cancel();

	void book();

	int statistics_am();
	
	int statistics_pm();

	List<DiningRecord> list_am();
	
	List<DiningRecord> list_pm();

	List<DiningRecord> record();

	List<DiningRecord> record_am_list(String string);
	
	List<DiningRecord> record_pm_list(String string);

}
