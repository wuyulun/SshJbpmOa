package com.hyjcy.oa.service;

import java.util.Collection;
import java.util.List;

import com.hyjcy.oa.domain.GoodsApproveinfo;
import com.hyjcy.oa.domain.GoodsTaskView;
import com.hyjcy.oa.domain.Goodsform;
import com.hyjcy.oa.domain.User;

public interface WupinshenpiService {

	Goodsform submit(Goodsform goodsform);

	List<GoodsTaskView> findMyTaskViewList(User currentUser);

	Goodsform getGoodsformById(Long goodsformId);


	Collection<String> getOutcomesByTaskId(String taskId);

	void approve(GoodsApproveinfo goodsApproveinfo, String taskId,
			boolean gapproval);

}
