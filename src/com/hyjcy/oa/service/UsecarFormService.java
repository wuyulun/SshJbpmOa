package com.hyjcy.oa.service;

import java.util.List;

import com.hyjcy.oa.base.DaoSupport;
import com.hyjcy.oa.domain.Usecarform;

public interface UsecarFormService extends DaoSupport<Usecarform>{

	List<Usecarform> findDone();

	List<Usecarform> findover();

}
