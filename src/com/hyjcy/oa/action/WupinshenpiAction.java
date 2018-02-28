package com.hyjcy.oa.action;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hyjcy.oa.base.ModelDrivenBaseAction;
import com.hyjcy.oa.domain.FaultApproveinfo;
import com.hyjcy.oa.domain.Faultform;
import com.hyjcy.oa.domain.GoodsApproveinfo;
import com.hyjcy.oa.domain.GoodsTaskView;
import com.hyjcy.oa.domain.Goodsform;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class WupinshenpiAction extends ModelDrivenBaseAction<Goodsform>{
   
	private Long goodsformId;
	private String taskId;
	private boolean gapproval;
	private String comment;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	
	public boolean isGapproval() {
		return gapproval;
	}

	public void setGapproval(boolean gapproval) {
		this.gapproval = gapproval;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public Long getGoodsformId() {
		return goodsformId;
	}

	public void setGoodsformId(Long goodsformId) {
		this.goodsformId = goodsformId;
	}

		// 跳转到申报表单页面
		public String shenqing() throws Exception {
			return "shenqing";
		}
		
		//封装申报表单数据，提交申请进入工作流
		public String tijiao() throws Exception {
			Goodsform goodsform = new Goodsform();
			processDefinitionService.GoodsForms();
			goodsform.setDepartment(model.getDepartment());
			goodsform.setGapplicant(getCurrentUser());
			goodsform.setMuchGoods(model.getMuchGoods());

			goodsform = wupinshenpiService.submit(goodsform);
			ActionContext.getContext().getValueStack().push(goodsform);
			return "tijiao";
		}

		public String chuli() throws Exception {
			List<GoodsTaskView> goodsTaskViewslist = wupinshenpiService
					.findMyTaskViewList(getCurrentUser());
			
			ActionContext.getContext()
					.put("goodsTaskViewslist", goodsTaskViewslist);
//			System.out.println("goodstaskviewlist++++"+ActionContext.getContext().get("goodsTaskViewslist"));
			return "chuli";
		}

		public String shenpijilu(){
			List<Goodsform> goodsformsList =goodsformservice.findDone();
			ActionContext.getContext().put("goodsformsList", goodsformsList);
			return "shenpijilu";
		}

		public String jilu() throws Exception {
			List<Goodsform> goodsformsList =goodsformservice.findAll();
			ActionContext.getContext().put("goodsformsList", goodsformsList);
			return "jilu";
		}
		public String approveUI() throws Exception {
			Goodsform goodsform = goodsformservice.getById(goodsformId);
			System.out.println("goodsform++++++++"+goodsform.getStatus()+goodsform.getApplytime());
			ActionContext.getContext().getValueStack().push(goodsform);
			return "approveUI";
		}

		public String shouli() {
			// 封装对象
			GoodsApproveinfo goodsApproveinfo = new GoodsApproveinfo();
			goodsApproveinfo.setGapproval(gapproval); //
			goodsApproveinfo.setComment(comment);
			goodsApproveinfo.setGoodsform(wupinshenpiService//
					.getGoodsformById(goodsformId));
//			System.out.println("goodsformID+++++++"+goodsformId);
			goodsApproveinfo.setGoodapprover(getCurrentUser()); // 审批人，当前登录用户
			goodsApproveinfo.setGoodapproveTime(sdf.format(new Date())); // 审批时间，当前时间
			// 调用业务方法（保存审批信息，完成当前任务，维护申请的状态）
			wupinshenpiService.approve(goodsApproveinfo, taskId,gapproval);
			return "shouli";
		}
}
