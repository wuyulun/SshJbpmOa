package com.hyjcy.oa.service;

import java.util.List;

import com.hyjcy.oa.base.DaoSupport;
import com.hyjcy.oa.domain.FaultApproveinfo;
import com.hyjcy.oa.domain.FaultTaskView;
import com.hyjcy.oa.domain.Faultform;
import com.hyjcy.oa.domain.User;

public interface GuzhangshenpiService {

	Faultform submit(Faultform faultForm);

	List<FaultTaskView> findMyTaskViewList(User currentUser);

	Faultform getFaultformById(Long faultFormId);

	void approve(FaultApproveinfo faultApproveinfo, String taskId);

//	Device findbyuser(User user);

}
