package com.hyjcy.oa.domain;

import org.jbpm.api.task.Task;

public class FaultTaskView {
	private Task task;
	private Faultform faultForm;
	public  FaultTaskView() {
	}
	public  FaultTaskView(Task task,Faultform faultForm) {
		this.task=task;
		this.faultForm=faultForm;
	}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	public Faultform getFaultForm() {
		return faultForm;
	}
	public void setFaultForm(Faultform faultForm) {
		this.faultForm = faultForm;
	}
	


}
