package com.hyjcy.oa.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hyjcy.oa.base.ModelDrivenBaseAction;
import com.hyjcy.oa.domain.FaultApproveinfo;
import com.hyjcy.oa.domain.FaultTaskView;
import com.hyjcy.oa.domain.Faultform;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class guzhangshenpiAction extends ModelDrivenBaseAction<Faultform> {
	private String status;
	private Long faultFormId;
	private String taskId;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public Long getFaultFormId() {
		return faultFormId;
	}

	public void setFaultFormId(Long faultFormId) {
		this.faultFormId = faultFormId;
	}

	public String getStatus() {
		return status;
	}

	
	public void setStatus(String status) {
		this.status = status;
	}

	// 跳转到申报表单页面
	public String shenqing() throws Exception {
		return "shenqing";
	}
	
	//封装申报表单数据，提交申请进入工作流
	public String tijiao() throws Exception {
		Faultform faultform = new Faultform();
		processDefinitionService.FaultFrombs();
		faultform.setBrand(model.getBrand());
		faultform.setDepartment(model.getDepartment());
		faultform.setDescription(model.getDescription());
		faultform.setModel(model.getModel());
		faultform.setType(model.getType());
		faultform.setApplicant(getCurrentUser());

		faultform = guzhangshenpiService.submit(faultform);
		ActionContext.getContext().getValueStack().push(faultform);
		return "tijiao";
	}

	public String chuli() throws Exception {
		List<FaultTaskView> faultTaskViewslist = guzhangshenpiService
				.findMyTaskViewList(getCurrentUser());
		ActionContext.getContext()
				.put("faultTaskViewslist", faultTaskViewslist);
		return "chuli";
	}

	public String shenpijilu(){
		List<Faultform> faultformsList =faultFormService.findDone();
		ActionContext.getContext().put("faultformsList", faultformsList);
		return "shenpijilu";
	}


	

	public String jilu() throws Exception {
		List<Faultform> faultformsList = faultFormService.findAll();
		ActionContext.getContext().put("faultformsList", faultformsList);
		return "jilu";
	}

	public String shouli() {
		// 封装对象
		FaultApproveinfo faultApproveinfo = new FaultApproveinfo();
		faultApproveinfo.setApproval(true); //
//		System.out.println("PPPPPPPPPPPPP" + taskId + faultFormId);
		faultApproveinfo.setFaultform(guzhangshenpiService//
				.getFaultformById(faultFormId)); // 所属的申请
		faultApproveinfo.setFaultapprover(getCurrentUser()); // 审批人，当前登录用户
		faultApproveinfo.setApproveTime(sdf.format(new Date())); // 审批时间，当前时间

		// 调用业务方法（保存审批信息，完成当前任务，维护申请的状态）
		guzhangshenpiService.approve(faultApproveinfo, taskId);

		return "shouli";
	}

}
