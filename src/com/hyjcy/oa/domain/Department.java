package com.hyjcy.oa.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @ClassName: Department
 * @Description: TODO 部门实体类 
 * @Author: wyxx
 * @Date: 2016年8月19日 上午10:53:43
 * @version V1.0
 */
public class Department implements java.io.Serializable{//序列化，进行网络传输或者放进SESSION中的时候
	private Long id;
	private Set<User> users = new HashSet<User>();
	private Department parent;//自关联属性
	private Set<Department> children = new HashSet<Department>();//自关联属性

	private String name;
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Department getParent() {
		return parent;
	}

	public void setParent(Department parent) {
		this.parent = parent;
	}

	public Set<Department> getChildren() {
		return children;
	}

	public void setChildren(Set<Department> children) {
		this.children = children;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
