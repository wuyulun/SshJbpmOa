package com.hyjcy.oa.domain;

import java.util.Date;

public class FaultApproveinfo {
	private Long id;
	private Faultform faultform; // 
	private User faultapprover;// 审批人

	private String  approveTime;// 审批时间
	private boolean approval; // 是否通过
	private String comment; // 审批意见
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Faultform getFaultform() {
		return faultform;
	}
	public void setFaultform(Faultform faultform) {
		this.faultform = faultform;
	}
	public User getFaultapprover() {
		return faultapprover;
	}
	public void setFaultapprover(User faultapprover) {
		this.faultapprover = faultapprover;
	}
	public String getApproveTime() {
		return approveTime;
	}
	public void setApproveTime(String approveTime) {
		this.approveTime = approveTime;
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
