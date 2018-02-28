package com.hyjcy.oa.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class UcleaderApproveinfo {
	private Long id;
	private String leaderapproveTime;//审批时间
	private User ucleaderapprover;//申请人
	private Usecarform useleadercarform;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLeaderapproveTime() {
		return leaderapproveTime;
	}
	public void setLeaderapproveTime(String leaderapproveTime) {
		this.leaderapproveTime = leaderapproveTime;
	}
	public User getUcleaderapprover() {
		return ucleaderapprover;
	}
	public void setUcleaderapprover(User ucleaderapprover) {
		this.ucleaderapprover = ucleaderapprover;
	}
	public Usecarform getUseleadercarform() {
		return useleadercarform;
	}
	public void setUseleadercarform(Usecarform useleadercarform) {
		this.useleadercarform = useleadercarform;
	}
	
}
