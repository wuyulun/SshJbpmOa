package com.hyjcy.oa.service;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessEngine;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: ProcessDefinitionService
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @Author: wyxx
 * @Date: 2016年8月22日 上午10:35:24
 * @version V1.0
 */

public interface ProcessDefinitionService {//没有实体类，用processEngine进行增删改查操作


	void FaultFrombs();
	/**
	 * 部署流程定义（使用zip包的方式）
	 * 
	 * @param zipFile
	 */
	void deployByZip(File zipFile);
	void GoodsForms();
	void UsecarForms();

	

	
}
