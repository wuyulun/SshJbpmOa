package com.hyjcy.oa.action;

import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hyjcy.oa.base.ModelDrivenBaseAction;
import com.hyjcy.oa.domain.Privilege;
import com.hyjcy.oa.domain.Role;
import com.opensymphony.xwork2.ActionContext;

@Controller//在struts中配置要用到这个注解
@Scope("prototype")//或者在Application中配置scope="prototype"多例每次创建一个新的对象一般用于ACTION，单利每次用同一个对象，一般在Service和Action
public class RoleAction extends ModelDrivenBaseAction<Role> {

	private Long[] privilegeIds;

	/** 显示列表 */
	public String list() throws Exception {
		// 准备数据
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		return "list";
	}

	/** 删除 */
	public String delete() throws Exception {
		roleService.delete(model.getId());
		return "toList";
	}

	/** 添加页面 */
	public String addUI() throws Exception {
		return "saveUI";
	}

	/** 添加 */
	public String add() throws Exception {
		// 封装对象
		// Role role = new Role();
		// role.setName(model.getName());
		// role.setDescription(model.getDescription());

		// 保存到数据库
		roleService.save(model);

		return "toList";
	}

	/** 修改页面 */
	public String editUI() throws Exception {
		// 准备要回显的数据
		Role role = roleService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(role);
		return "saveUI";
	}

	/** 修改  */
	public String edit() throws Exception {
		// 1，从数据库中获取要修改的原始对象
		Role role = roleService.getById(model.getId());
		// 2, 设置要修改的属性
		role.setName(model.getName());
		role.setDescription(model.getDescription());

		// 3，更新到数据库
		roleService.update(role);

		//修改成功重定向到role_list的action中的list页面
		return "toList";
	}

	
	/** 设置权限页面 */
	public String setPrivilegeUI() throws Exception {
		// 准备数据     
		List<Privilege> topPrivilegeList = privilegeService.findTopList();
		ActionContext.getContext().put("topPrivilegeList", topPrivilegeList);

		
		// 准备要回显的数据    =》根据ID显示所有数据
		Role role = roleService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(role);

		// 准备回显的权限数据
		privilegeIds = new Long[role.getPrivileges().size()];
		int index = 0;
		for (Privilege p : role.getPrivileges()) {
			privilegeIds[index++] = p.getId();
		}

		return "setPrivilegeUI";
	}

	/** 设置权限 */
	public String setPrivilege() throws Exception {
		// 1，从数据库中获取要修改的原始对象
		Role role = roleService.getById(model.getId());

		// 2, 设置要修改的属性 =>查找权限集合
		List<Privilege> privilegeList = privilegeService.getByIds(privilegeIds);

		// 
		role.setPrivileges(new HashSet<Privilege>(privilegeList));

		// 3，更新到数据库
		roleService.update(role);

		return "toList";
	}

	

	public Long[] getPrivilegeIds() {
		return privilegeIds;
	}

	public void setPrivilegeIds(Long[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}

}
