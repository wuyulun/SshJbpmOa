package com.hyjcy.oa.service;

import java.util.List;

import com.hyjcy.oa.base.DaoSupport;
import com.hyjcy.oa.domain.Faultform;

public interface FaultFormService extends DaoSupport<Faultform>{

	List<Faultform> findDone();

}
