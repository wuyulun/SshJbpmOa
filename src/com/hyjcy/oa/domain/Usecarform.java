package com.hyjcy.oa.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Usecarform {
	private Long id;
	private String ucdepartment;
	private String place;
	private String usecartime;//用车时间
	private String people;
	private String stuff;//缘由
	private String applytime;//申请时间
	private String leadertime;//领导办理时间
	private String cartime;//发车时间
	private String status; // 当前的状态
	private User uapplicant;//申请人
	private User leader;//办理领导
	private String carmessage;
	
	
	
	public String getCarmessage() {
		return carmessage;
	}
	public void setCarmessage(String carmessage) {
		this.carmessage = carmessage;
	}
	public User getUapplicant() {
		return uapplicant;
	}
	public void setUapplicant(User uapplicant) {
		this.uapplicant = uapplicant;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUcdepartment() {
		return ucdepartment;
	}
	public void setUcdepartment(String ucdepartment) {
		this.ucdepartment = ucdepartment;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getUsecartime() {
		return usecartime;
	}
	public void setUsecartime(String usecartime) {
		this.usecartime = usecartime;
	}
	public String getPeople() {
		return people;
	}
	public void setPeople(String people) {
		this.people = people;
	}
	public String getStuff() {
		return stuff;
	}
	public void setStuff(String stuff) {
		this.stuff = stuff;
	}
	public String getApplytime() {
		return applytime;
	}
	public void setApplytime(String applytime) {
		this.applytime = applytime;
	}
	public String getLeadertime() {
		return leadertime;
	}
	public void setLeadertime(String leadertime) {
		this.leadertime = leadertime;
	}
	public String getCartime() {
		return cartime;
	}
	public void setCartime(String cartime) {
		this.cartime = cartime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public User getLeader() {
		return leader;
	}
	public void setLeader(User leader) {
		this.leader = leader;
	}
	
	
}
