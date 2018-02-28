package com.hyjcy.oa.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessDefinitionQuery;
import org.jbpm.api.ProcessEngine;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyjcy.oa.service.ProcessDefinitionService;

/**
 * @ClassName: ProcessDefinitionServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author: wyxx
 * @Date: 2016年8月22日 上午10:36:11
 * @version V1.0
 */

@Service
@Transactional
public class ProcessDefinitionServiceImpl implements ProcessDefinitionService {

	@Resource
	private SessionFactory sessionFactory;

	@Resource
	private ProcessEngine processEngine;

	
	public void FaultFrombs(){
		processEngine.getRepositoryService()//
		.createDeployment()//
		.addResourceFromClasspath("FaultForm/FaultForm.jpdl.xml")//
		.addResourceFromClasspath("FaultForm/FaultForm.png")//
		.deploy();
	}
	public void GoodsForms(){
		processEngine.getRepositoryService()//
				.createDeployment()//
				.addResourceFromClasspath("GoodsForm/GoodsForm.jpdl.xml")//
				.addResourceFromClasspath("GoodsForm/GoodsForm.png")//
				.deploy();
	}

	/**
	 * 部署流程定义（使用zip包的方式）
	 * 
	 * @param zipFile
	 */
	public void deployByZip(File zipFile) {
		ZipInputStream zipInputStream = null;
		// 准备
		try {
			zipInputStream = new ZipInputStream(new FileInputStream(zipFile));
			// 部署
			processEngine.getRepositoryService().createDeployment()
					.addResourcesFromZipInputStream(zipInputStream).deploy();

		} catch (FileNotFoundException e) {

			throw new RuntimeException();

		} finally {
			if (zipInputStream != null) {
				try {

					zipInputStream.close();

				} catch (IOException e) {

					throw new RuntimeException(e);
				}
			}
		}

	}
	@Override
	public void UsecarForms() {
		processEngine.getRepositoryService()//
		.createDeployment()//
		.addResourceFromClasspath("UsecarForm/UsecarForm.jpdl.xml")//
		.addResourceFromClasspath("UsecarForm/UsecarForm.png")//
		.deploy();
	}

	
}
