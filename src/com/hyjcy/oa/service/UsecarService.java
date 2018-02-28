package com.hyjcy.oa.service;

import java.util.List;

import com.hyjcy.oa.domain.UcleaderApproveinfo;
import com.hyjcy.oa.domain.UcsendApproveinfo;
import com.hyjcy.oa.domain.Usecarform;
import com.hyjcy.oa.domain.UsecarformTaskView;
import com.hyjcy.oa.domain.User;

public interface UsecarService {

	Usecarform submit(Usecarform usecarform);

	List<UsecarformTaskView> findMyTaskViewList(User currentUser);

	Usecarform getusecarformById(Long usecarformId);

	void approve(UcleaderApproveinfo ucleaderApproveinfo, String taskId);

	void approve(UcsendApproveinfo ucsendApproveinfo, String taskId,
			Usecarform usecarform);

}
