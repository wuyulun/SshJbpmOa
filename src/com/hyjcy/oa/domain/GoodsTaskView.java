package com.hyjcy.oa.domain;

import org.jbpm.api.task.Task;

public class GoodsTaskView {
	private Task task;
	private Goodsform goodsForm;
	public  GoodsTaskView() {
	}
	public  GoodsTaskView(Task task,Goodsform goodsForm) {
		this.task=task;
		this.goodsForm=goodsForm;
	}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	public Goodsform getGoodsform() {
		return goodsForm;
	}
	public void setGoodsform(Goodsform goodsForm) {
		this.goodsForm = goodsForm;
	}

}
