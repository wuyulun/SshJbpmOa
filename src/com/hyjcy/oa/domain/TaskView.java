package com.hyjcy.oa.domain;

import org.jbpm.api.task.Task;

/**
 * 
 * @ClassName: TaskView
 * @Description: 在页面中显示用的JavaBean。表示一个任务的信息（任务本身的信息 + 与任务相关联的申请的信息）
 * @Author: wyxx
 * @Date: 2016年8月23日 下午3:37:57
 * @version V1.0
 */
public class TaskView {
	private Task task; //活动
	private Application application; //申请

	public TaskView() {
	}

	public TaskView(Task task, Application application) {
		this.task = task;
		this.application = application;
	}
	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

}
