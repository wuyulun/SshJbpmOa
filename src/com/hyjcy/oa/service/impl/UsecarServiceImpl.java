package com.hyjcy.oa.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.hyjcy.oa.domain.GoodsTaskView;
import com.hyjcy.oa.domain.Goodsform;
import com.hyjcy.oa.domain.Statues;
import com.hyjcy.oa.domain.UcleaderApproveinfo;
import com.hyjcy.oa.domain.UcsendApproveinfo;
import com.hyjcy.oa.domain.Usecarform;
import com.hyjcy.oa.domain.UsecarformTaskView;
import com.hyjcy.oa.domain.User;
import com.hyjcy.oa.service.UsecarService;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class UsecarServiceImpl implements UsecarService{

	@Resource
	public SessionFactory sessionFactory;
	@Resource
	private ProcessEngine processEngine;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH：mm:ss");

	@Override
	public Usecarform submit(Usecarform usecarform) {
		String processDefinitionKey ="用车流程";
		usecarform.setApplytime(sdf.format(new Date()));
		usecarform.setStatus(Statues.STATUS_RUNNING);
		sessionFactory.getCurrentSession().save(usecarform); // 保存
		Map<String, Object> variables = new HashMap<String, Object>(); // 定义流程变量
		variables.put("usecarform", usecarform);
		ProcessInstance pi = processEngine.getExecutionService()
				.startProcessInstanceByKey(processDefinitionKey, variables);
		Task task = processEngine.getTaskService()//
				.createTaskQuery()// 查询出本流程实例中当前情况下仅有的一个任务
				.processInstanceId(pi.getId())//
				.uniqueResult();
		processEngine.getTaskService().completeTask(task.getId());
		return usecarform;
	}

	@Override
	public List<UsecarformTaskView> findMyTaskViewList(User currentUser) {
		// 查询我的任务列表
				String userId = currentUser.getName(); // 使用loginName作为JBPM中的用户标识符
				List<Task> taskList = processEngine.getTaskService().findPersonalTasks(
						userId);

				// 获取每个任务对应的申请信息
				List<UsecarformTaskView> returnList = new ArrayList<UsecarformTaskView>();
				for (Task task : taskList) {
					Usecarform usecarform = (Usecarform) processEngine
							.getTaskService().getVariable(task.getId(), "usecarform");
					UsecarformTaskView tv = new UsecarformTaskView(task, usecarform);
					returnList.add(tv);
				}
				return returnList;
	}

	@Override
	public Usecarform getusecarformById(Long usecarformId) {
		return (Usecarform) sessionFactory//
				.getCurrentSession()//
				.get(Usecarform.class, usecarformId);
	}

	@Override
	public void approve(UcleaderApproveinfo ucleaderApproveinfo, String taskId) {
		// 1, 保存审批信息
		sessionFactory.getCurrentSession().save(ucleaderApproveinfo);

		// 2, 完成当前任务
		Task task = processEngine.getTaskService().getTask(taskId); // 获取任务的代码一定要是写到完成任务前，因为任务办理完后就变成了历史任务信息。
			processEngine.getTaskService().completeTask(taskId); // 使用默认的Transition


		// 3, 维护申请的状态
		Usecarform usecarform = ucleaderApproveinfo.getUseleadercarform();
		usecarform.setStatus(Statues.STATUS_LEADERAPPROVED);
		usecarform.setLeadertime(sdf.format(new Date()));
		usecarform.setLeader(ucleaderApproveinfo.getUcleaderapprover());
		sessionFactory.getCurrentSession().update(usecarform);
	}

	@Override
	public void approve(UcsendApproveinfo ucsendApproveinfo, String taskId,
			Usecarform usecarform) {
		       ucsendApproveinfo.setMessage(usecarform.getCarmessage());
		// 1, 保存审批信息
				sessionFactory.getCurrentSession().save(ucsendApproveinfo);

				// 2, 完成当前任务
				Task task = processEngine.getTaskService().getTask(taskId); // 获取任务的代码一定要是写到完成任务前，因为任务办理完后就变成了历史任务信息。
					processEngine.getTaskService().completeTask(taskId); // 使用默认的Transition


				// 3, 维护申请的状态
				usecarform.setStatus(Statues.STATUS_APPROVED);
				usecarform.setCartime(sdf.format(new Date()));
				 System.out.println("usecarmessage+++++++"+usecarform.getStatus()+usecarform.getCartime());
				sessionFactory.getCurrentSession().update(usecarform);
	}
}
