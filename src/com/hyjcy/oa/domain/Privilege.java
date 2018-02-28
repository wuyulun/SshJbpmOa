package com.hyjcy.oa.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @ClassName: Privilege
 * @Description: TODO  权限实体类
 * @Author: wyxx
 * @Date: 2016年8月18日 上午9:22:07
 * @version V1.0
 */
public class Privilege implements java.io.Serializable{
	
	private Long id; //权限id
	private String url; //权限路径
	private String name; //权限名称
	private String icon;
	
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	private Set<Role> roles = new HashSet<Role>(); //

	//自链接
	private Privilege parent;
	
	private Set<Privilege> children = new HashSet<Privilege>();

	public Privilege() {
	}

	public Privilege(String name, String url, Privilege parent) {
		this.name = name;
		this.url = url;
		this.parent = parent;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Privilege getParent() {
		return parent;
	}

	public void setParent(Privilege parent) {
		this.parent = parent;
	}

	public Set<Privilege> getChildren() {
		return children;
	}

	public void setChildren(Set<Privilege> children) {
		this.children = children;
	}

}
