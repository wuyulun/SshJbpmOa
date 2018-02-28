package com.hyjcy.oa.action;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import org.jbpm.api.ProcessDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hyjcy.oa.base.BaseAction;
import com.opensymphony.xwork2.ActionContext;

/**
 * @ClassName: ProcessDefinitionAction
 * @Description: (这里用一句话描述这个类的作用)
 * @Author: wyxx
 * @Date: 2016年8月22日 上午10:06:54
 * @version V1.0
 */
@Controller
@Scope("prototype")
public class ProcessDefinitionAction extends BaseAction {//没有实体类，将modelDriven分离出来

	private File upload;// 上传的文件
//	private String uploadFilename;//上文件的原始名字
//	private String uploadContenType;//上傳文件的類型
	private InputStream inputStream;// 下载输入流
	private String id;
	private String key;//所有版本


	/** 添加（部署） */
	public String add() throws Exception {
		processDefinitionService.deployByZip(upload);
		return "toList";
	}

	

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
