package com.hyjcy.oa.domain;

import org.jbpm.api.task.Task;

public class UsecarformTaskView {
	private Task task;
	private Usecarform usecarform;
	public  UsecarformTaskView() {
	}
	public  UsecarformTaskView(Task task,Usecarform usecarform) {
		this.task=task;
		this.usecarform=usecarform;
	}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	public Usecarform getUsecarform() {
		return usecarform;
	}
	public void setUsecarform(Usecarform usecarform) {
		this.usecarform = usecarform;
	}

	
}
