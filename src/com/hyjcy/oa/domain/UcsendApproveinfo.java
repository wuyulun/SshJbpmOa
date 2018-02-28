package com.hyjcy.oa.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class UcsendApproveinfo {
	private Long id;
	private String sendapproveTime;//审批时间
	private String message;
	private User ucsendapprover;//申请人
	private Usecarform usecarform;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getSendapproveTime() {
		return sendapproveTime;
	}
	public void setSendapproveTime(String sendapproveTime) {
		this.sendapproveTime = sendapproveTime;
	}
	public User getUcsendapprover() {
		return ucsendapprover;
	}
	public void setUcsendapprover(User ucsendapprover) {
		this.ucsendapprover = ucsendapprover;
	}
	public void setUsecarform(Usecarform usecarform) {
		this.usecarform = usecarform;
	}
	public Usecarform getUsecarform() {
		return usecarform;
	}	
}
