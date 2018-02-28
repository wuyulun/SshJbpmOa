package com.hyjcy.oa.service;

import java.util.List;

import com.hyjcy.oa.base.DaoSupport;
import com.hyjcy.oa.domain.Goodsform;

public interface GoodsformService extends DaoSupport<Goodsform>{

	List<Goodsform> findDone();

}
