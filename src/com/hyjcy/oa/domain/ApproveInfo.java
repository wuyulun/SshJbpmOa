package com.hyjcy.oa.domain;

import java.util.Date;

/**
 * 
 * @ClassName: ApproveInfo
 * @Description: 审批信息
 * @Author: wyxx
 * @Date: 2016年8月23日 上午10:28:06
 * @version V1.0
 */
public class ApproveInfo {
	private Long id;
	private Application application; // 
	private User approver;// 审批人

	private Date approveTime;// 审批时间
	private boolean approval; // 是否通过
	private String comment; // 审批意见

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getApprover() {
		return approver;
	}

	public void setApprover(User approver) {
		this.approver = approver;
	}

	public Date getApproveTime() {
		return approveTime;
	}

	public void setApproveTime(Date approveTime) {
		this.approveTime = approveTime;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public boolean isApproval() {
		return approval;
	}

	public void setApproval(boolean approval) {
		this.approval = approval;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
