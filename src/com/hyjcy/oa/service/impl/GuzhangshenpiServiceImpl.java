package com.hyjcy.oa.service.impl;

import java.text.ParseException;
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

import com.hyjcy.oa.base.DaoSupportImpl;
import com.hyjcy.oa.domain.Application;
import com.hyjcy.oa.domain.FaultApproveinfo;
import com.hyjcy.oa.domain.FaultTaskView;
import com.hyjcy.oa.domain.Faultform;
import com.hyjcy.oa.domain.Statues;
import com.hyjcy.oa.domain.TaskView;
import com.hyjcy.oa.domain.User;
import com.hyjcy.oa.service.GuzhangshenpiService;


@Service
@Transactional
public class GuzhangshenpiServiceImpl implements GuzhangshenpiService {
  
	@Resource
	public SessionFactory sessionFactory;
	@Resource
	private ProcessEngine processEngine;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH：mm:ss");
	
	@Override
	public Faultform submit(Faultform faultForm) {
		
		String time = sdf.format(new Date());
		String processDefinitionKey ="故障审批";
		faultForm.setApplytime(time);
		faultForm.setStatus(Statues.STATUS_RUNNING);
		sessionFactory.getCurrentSession().save(faultForm); // 保存
		Map<String, Object> variables = new HashMap<String, Object>(); // 定义流程变量
		variables.put("faultForm", faultForm);
		System.out.println("--ooooooo---"+variables.get("faultForm").toString());
		ProcessInstance pi = processEngine.getExecutionService()
				.startProcessInstanceByKey(processDefinitionKey, variables);
		Task task = processEngine.getTaskService()//
				.createTaskQuery()// 查询出本流程实例中当前情况下仅有的一个任务
				.processInstanceId(pi.getId())//
				.uniqueResult();
		processEngine.getTaskService().completeTask(task.getId());
		return faultForm;

	}


	@Override
	public List<FaultTaskView> findMyTaskViewList(User currentUser) {
		// 查询我的任务列表
				String userId = currentUser.getName(); // 使用loginName作为JBPM中的用户标识符
				List<Task> taskList = processEngine.getTaskService().findPersonalTasks(
						userId);

				// 获取每个任务对应的申请信息
				List<FaultTaskView> returnList = new ArrayList<FaultTaskView>();
				for (Task task : taskList) {
					Faultform faultform = (Faultform) processEngine
							.getTaskService().getVariable(task.getId(), "faultForm");
					FaultTaskView tv = new FaultTaskView(task, faultform);
					returnList.add(tv);
				}
				return returnList;
	}


	@Override
	public Faultform getFaultformById(Long faultFormId) {
		return (Faultform) sessionFactory//
				.getCurrentSession()//
				.get(Faultform.class, faultFormId);
	}


	@Override
	public void approve(FaultApproveinfo faultApproveinfo, String taskId) {
		// 1, 保存审批信息
				sessionFactory.getCurrentSession().save(faultApproveinfo);

				// 2, 完成当前任务
				Task task = processEngine.getTaskService().getTask(taskId); // 获取任务的代码一定要是写到完成任务前，因为任务办理完后就变成了历史任务信息。
					processEngine.getTaskService().completeTask(taskId); // 使用默认的Transition


				// 3, 维护申请的状态
				Faultform faultform = faultApproveinfo.getFaultform();
				faultform.setStatus(Statues.STATUS_APPROVED);
				faultform.setDonetime(sdf.format(new Date()));
				sessionFactory.getCurrentSession().update(faultform);
	}

	
}
