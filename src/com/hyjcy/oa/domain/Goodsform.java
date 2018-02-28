package com.hyjcy.oa.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Goodsform {
	private Long id;
	private String muchGoods;//
	private String reason;//
	private String department;
	private String applytime;//申请时间
	private String donetime;//办理时间
	private String status; // 当前的状态
	private User gapplicant;//申请人
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMuchGoods() {
		return muchGoods;
	}
	public void setMuchGoods(String muchGoods) {
		this.muchGoods = muchGoods;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public User getGapplicant() {
		return gapplicant;
	}
	public void setGapplicant(User gapplicant) {
		this.gapplicant = gapplicant;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getApplytime() {
		return applytime;
	}
	public void setApplytime(String applytime) {
		this.applytime = applytime;
	}
	public String getDonetime() {
		return donetime;
	}
	public void setDonetime(String donetime) {
		this.donetime = donetime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
