package com.hyjcy.oa.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.task.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyjcy.oa.domain.Faultform;
import com.hyjcy.oa.domain.GoodsApproveinfo;
import com.hyjcy.oa.domain.GoodsTaskView;
import com.hyjcy.oa.domain.Goodsform;
import com.hyjcy.oa.domain.Statues;
import com.hyjcy.oa.domain.User;
import com.hyjcy.oa.service.WupinshenpiService;
@Service
@Transactional
@SuppressWarnings("unchecked")
public class WupinshenpiServiceImpl implements WupinshenpiService{
   
	@Resource
	public SessionFactory sessionFactory;
	@Resource
	private ProcessEngine processEngine;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH：mm:ss");
	@Override
	public Goodsform submit(Goodsform goodsform) {
		
		String processDefinitionKey ="物品领取";
		goodsform.setApplytime(sdf.format(new Date()));
		goodsform.setStatus(Statues.STATUS_RUNNING);
		sessionFactory.getCurrentSession().save(goodsform); // 保存
		Map<String, Object> variables = new HashMap<String, Object>(); // 定义流程变量
		variables.put("goodsForm", goodsform);
		ProcessInstance pi = processEngine.getExecutionService()
				.startProcessInstanceByKey(processDefinitionKey, variables);
		Task task = processEngine.getTaskService()//
				.createTaskQuery()// 查询出本流程实例中当前情况下仅有的一个任务
				.processInstanceId(pi.getId())//
				.uniqueResult();
		processEngine.getTaskService().completeTask(task.getId());
		return goodsform;

	}
	@Override
	public List<GoodsTaskView> findMyTaskViewList(User currentUser) {
		// 查询我的任务列表
		String userId = currentUser.getName(); // 使用loginName作为JBPM中的用户标识符
		List<Task> taskList = processEngine.getTaskService().findPersonalTasks(
				userId);

		// 获取每个任务对应的申请信息
		List<GoodsTaskView> returnList = new ArrayList<GoodsTaskView>();
		for (Task task : taskList) {
			Goodsform goodsForm = (Goodsform) processEngine
					.getTaskService().getVariable(task.getId(), "goodsForm");
			GoodsTaskView tv = new GoodsTaskView(task, goodsForm);
			returnList.add(tv);
		}
		return returnList;
	}
	@Override
	public Goodsform getGoodsformById(Long goodsformId) {
		return (Goodsform) sessionFactory//
				.getCurrentSession()//
				.get(Goodsform.class, goodsformId);
	}
	@Override
	public void approve(GoodsApproveinfo goodsApproveinfo, String taskId,boolean gapproval) {
		// 1, 保存审批信息
		sessionFactory.getCurrentSession().save(goodsApproveinfo);

		// 2, 完成当前任务
		Task task = processEngine.getTaskService().getTask(taskId); // 获取任务的代码一定要是写到完成任务前，因为任务办理完后就变成了历史任务信息。
			processEngine.getTaskService().completeTask(taskId); // 使用默认的Transition


		// 3, 维护申请的状态
		Goodsform goodsform = goodsApproveinfo.getGoodsform();
		if (gapproval==true) {
			goodsform.setStatus(Statues.STATUS_APPROVED);
		}else{
			goodsform.setStatus(Statues.STATUS_REJECTED);
		}
		
		goodsform.setDonetime(sdf.format(new Date()));
		goodsform.setReason(goodsApproveinfo.getComment());
		sessionFactory.getCurrentSession().update(goodsform);	
	}
	@Override
	public Collection<String> getOutcomesByTaskId(String taskId) {
		return processEngine.getTaskService().getOutcomes(taskId);
	}
}
