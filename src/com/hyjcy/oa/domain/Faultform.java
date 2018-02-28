package com.hyjcy.oa.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Faultform {
	
	private Long id;
	private String type;//设备类型
	private String brand;//品牌
	private String model; // 型号
	private String description;//故障说明
	private User applicant;//申请人
	private Set<FaultApproveinfo> faultapproveinfos = new HashSet<FaultApproveinfo>();//审批人
	private String department;
	private String applytime;//申请时间
	private String donetime;//办理时间
	private String status; // 当前的状态
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public Set<FaultApproveinfo> getFaultapproveinfos() {
		return faultapproveinfos;
	}
	public void setFaultapproveinfos(Set<FaultApproveinfo> faultapproveinfos) {
		this.faultapproveinfos = faultapproveinfos;
	}
	
	public String getApplytime() {
		return applytime;
	}
	public void setApplytime(String applytime) {
		this.applytime = applytime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getApplicant() {
		return applicant;
	}
	public void setApplicant(User applicant) {
		this.applicant = applicant;
	}
	public String getDonetime() {
		return donetime;
	}
	public void setDonetime(String donetime) {
		this.donetime = donetime;
	}
	
}
