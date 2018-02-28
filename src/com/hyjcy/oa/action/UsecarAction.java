package com.hyjcy.oa.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hyjcy.oa.base.ModelDrivenBaseAction;
import com.hyjcy.oa.domain.Goodsform;
import com.hyjcy.oa.domain.UcleaderApproveinfo;
import com.hyjcy.oa.domain.UcsendApproveinfo;
import com.hyjcy.oa.domain.Usecarform;
import com.hyjcy.oa.domain.UsecarformTaskView;
import com.hyjcy.oa.service.UsecarFormService;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class UsecarAction extends ModelDrivenBaseAction<Usecarform>{

	 private Long usecarformId;
	 private String taskId;
	 private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 
	 
	 
		public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

		public Long getUsecarformId() {
		return usecarformId;
	}

	public void setUsecarformId(Long usecarformId) {
		this.usecarformId = usecarformId;
	}

		// 跳转到申报表单页面
		public String shenqing() throws Exception {
			return "shenqing";
		}
		
		//封装申报表单数据，提交申请进入工作流
		public String tijiao() throws Exception {
			Usecarform usecarform = new Usecarform();
			processDefinitionService.UsecarForms();
			usecarform.setUcdepartment(model.getUcdepartment());;
			usecarform.setUapplicant(getCurrentUser());
			usecarform.setUsecartime(model.getUsecartime());
			usecarform.setPlace(model.getPlace());
			usecarform.setPeople(model.getPeople());
			usecarform.setStuff(model.getStuff());
			usecarform = usecarService.submit(usecarform);
			ActionContext.getContext().getValueStack().push(usecarform);
			return "tijiao";
		}

		public String lingdaochuli() throws Exception {
			List<UsecarformTaskView> usecarformTaskViewslist = usecarService
					.findMyTaskViewList(getCurrentUser());
			ActionContext.getContext()
					.put("usecarformTaskViewslist", usecarformTaskViewslist);
			return "lingdaochuli";
		}

		public String usecarjilu(){
			List<Usecarform> usecarformsList =usecarFormService.findAll();
			ActionContext.getContext().put("usecarformsList", usecarformsList);
			return "usecarjilu";
		}

		public String lingdaoshenpijilu() throws Exception {
			List<Usecarform> usecarformsList =usecarFormService.findDone();
			ActionContext.getContext().put("usecarformsList", usecarformsList);
			return "lingdaoshenpijilu"; 
		}
		public String approveUI() throws Exception {
			Usecarform usecarform = usecarFormService.getById(usecarformId);
//			System.out.println("goodsform++++++++"+goodsform.getStatus()+goodsform.getApplytime());
			ActionContext.getContext().getValueStack().push(usecarform);
			return "approveUI";
		}
		public String approve() throws Exception {
	// 封装对象
		UcsendApproveinfo ucsendApproveinfo = new UcsendApproveinfo();
		ucsendApproveinfo.setUsecarform(usecarService//
				.getusecarformById(usecarformId)); // 所属的申请
		ucsendApproveinfo.setUcsendapprover(getCurrentUser()); // 审批人，当前登录用户
		ucsendApproveinfo.setSendapproveTime(sdf.format(new Date()));
		Usecarform usecarform =ucsendApproveinfo.getUsecarform();
        usecarform.setCarmessage(model.getCarmessage());
				// 调用业务方法（保存审批信息，完成当前任务，维护申请的状态）
		usecarService.approve(ucsendApproveinfo, taskId,usecarform);
			return "approve";
		}

		public String shoucheyuansp() {
			List<UsecarformTaskView> usecarformTaskViewslist = usecarService
					.findMyTaskViewList(getCurrentUser());
			ActionContext.getContext()
					.put("usecarformTaskViewslist", usecarformTaskViewslist);
			return "shoucheyuansp";
		}
		public String shoucheyuanjl() {
			List<Usecarform> usecarformsList =usecarFormService.findover();
			ActionContext.getContext().put("usecarformsList", usecarformsList);
			return "shoucheyuanjl";
		}
		public String shouli() {
			// 封装对象
			UcleaderApproveinfo ucleaderApproveinfo = new UcleaderApproveinfo();
			ucleaderApproveinfo.setUseleadercarform(usecarService//
					.getusecarformById(usecarformId)); // 所属的申请
			ucleaderApproveinfo.setUcleaderapprover(getCurrentUser()); // 审批人，当前登录用户
			ucleaderApproveinfo.setLeaderapproveTime(sdf.format(new Date())); // 审批时间，当前时间
			// 调用业务方法（保存审批信息，完成当前任务，维护申请的状态）
			usecarService.approve(ucleaderApproveinfo, taskId);

			return "shouli";  
		}
		public String message() {
			return "message";
		}
}
