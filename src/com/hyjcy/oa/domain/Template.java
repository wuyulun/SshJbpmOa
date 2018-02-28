package com.hyjcy.oa.domain;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

/**
 * 
 * @ClassName: Template
 * @Description: 申请模板实体类
 * @Author: wyxx
 * @Date: 2016年8月22日 下午5:22:43
 * @version V1.0
 */
public class Template {
	private Long id;
	private String name;
	private String processKey;
	private String path; // 上传文件的路径
	private Set<Application> applications = new HashSet<Application>();
	
	public Set<Application> getApplications() {
		return applications;
	}
	public void setApplications(Set<Application> applications) {
		this.applications = applications;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProcessKey() {
		return processKey;
	}
	public void setProcessKey(String processKey) {
		this.processKey = processKey;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
}
