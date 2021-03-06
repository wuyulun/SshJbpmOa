
package com.hyjcy.oa.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hyjcy.oa.base.ModelDrivenBaseAction;
import com.hyjcy.oa.domain.Department;
import com.hyjcy.oa.util.DepartmentUtils;
import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class DepartmentAction extends ModelDrivenBaseAction<Department> {

	//顶级部门ID
	private Long parentId;

	/**
	 * 列表:列表页面只显示一层的（同级的）部门数据，默认显示最顶级的部门列表
	 */
	public String list() throws Exception {
		List<Department> departmentList = null;
		if (parentId == null) {
			// 默认显示顶级部门列表
			departmentList = departmentService.findTopList();
		} else {
			// 显示指定部门的子部门列表
			departmentList = departmentService.findChildren(parentId);
			
			// 
			Department parent = departmentService.getById(parentId);
			ActionContext.getContext().put("parent", parent);
		}
		ActionContext.getContext().put("departmentList", departmentList);
		return "list";
	}

	
	/** 删除 */
	public String delete() throws Exception {
		departmentService.delete(model.getId());
		return "toList";
	}

	/** 添加页面 */
	public String addUI() throws Exception {
		// 准备数据
		// List<Department> departmentList = departmentService.findAll();
		// ActionContext.getContext().put("departmentList", departmentList);

		// 准备数据（树状结构） 获取顶级部门集合
		List<Department> topList = departmentService.findTopList();
		//添加页面显示树状列表
		List<Department> departmentList = DepartmentUtils.getAllDepartmentList(topList, null);
		ActionContext.getContext().put("departmentList", departmentList);
	


		return "saveUI";
	}

	/** 添加 */
	public String add() throws Exception {
		// 封装对象
		// Department department = new Department();
		// department.setName(name);
		// department.setDescription(description);

		// 处理上级部门 
		Department parent = departmentService.getById(parentId);
		model.setParent(parent);

		// 保存到数据库
		departmentService.save(model);

		return "toList";
	}

	/** 更新页面 */
	public String editUI() throws Exception {
		// 准备回显的数据
		Department department = departmentService.getById(model.getId()); // 当前要修改的部门
		ActionContext.getContext().getValueStack().push(department);
		
		//上级部门数据回显
		if (department.getParent() != null) {
			this.parentId = department.getParent().getId();
		} 

		// 准备数据
		// List<Department> departmentList = departmentService.findAll();
		// ActionContext.getContext().put("departmentList", departmentList);

		// 准备数据（树状结构）
		List<Department> topList = departmentService.findTopList();
		// 添加页面显示树状列表
		List<Department> departmentList = DepartmentUtils.getAllDepartmentList(topList, department);
		ActionContext.getContext().put("departmentList", departmentList);

		return "saveUI";
	}

	/** 更新*/
	public String edit() throws Exception {
		// 1，从数据库中取出要修改的原始数据
		Department department = departmentService.getById(model.getId());

		// 2，设置要修改的属性
		department.setName(model.getName());
		department.setDescription(model.getDescription());
		// >> 处理上级部门
		Department parent = departmentService.getById(parentId);
		department.setParent(parent);
 
		// 3，更新到数据库
		departmentService.update(department);

		return "toList";
	}

	
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

}
