package com.hyjcy.oa.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;

import org.jbpm.api.ProcessDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hyjcy.oa.base.ModelDrivenBaseAction;
import com.hyjcy.oa.domain.Template;
import com.opensymphony.xwork2.ActionContext;

/**
 * @ClassName: TemplateAction
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author: wyxx
 * @Date: 2016年8月22日 下午5:28:39
 * @version V1.0
 */

@Controller
@Scope("prototype")
public class TemplateAction extends ModelDrivenBaseAction<Template> {
	private File upload; // 上传的文件
	private InputStream inputStream; // 下载用的

	/**
	 * 显示列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		List<Template> templateList = templateService.findAll();
		ActionContext.getContext().put("templateList", templateList);
		return "list";
	}

	/**
	 * 删除
	 * 
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {
		templateService.delete(model.getId());
		return "toList";
	}

	/**
	 * 添加
	 * 
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		// 封装数据类型
		Template template = new Template();
		// 设置数据属性
		template.setName(model.getName());
		template.setProcessKey(model.getProcessKey());
		// >> 处理上传的文件
		String path = saveUploadFile(upload);
		template.setPath(path);

		// 调用业务方法（保存）
		templateService.save(template);
		return "toList";
	}


	/** 修改 */
	public String edit() throws Exception {
		// 1，从数据库中获取原对象
		Template template = templateService.getById(model.getId());
		// 2，设置要修改的属性
		template.setName(model.getName());
		template.setProcessKey(model.getProcessKey());
		if (upload != null) { // 如果上传了文件，才表示要修改文件模板内容
			// 删除老文件
			File file = new File(template.getPath());
			if (file.exists()) {
				file.delete();
			}
			// 保存新文件
			String path = saveUploadFile(upload);
			template.setPath(path);
		}
		// 3，更新到数据库中
		templateService.update(template);
		return "toList";
	}

	/** 下载 */
	public String download() throws Exception {
		// 获取模板对象的信息
		Template template = templateService.getById(model.getId());
		String path = template.getPath();

		// 准备默认的文件名
		String fileName = template.getName();
		System.out.println("-----"+fileName);
		// 解决下载的文件名的乱码问题
//		fileName = URLEncoder.encode(fileName, "utf-8");
		fileName = new String(fileName.getBytes(), "ISO8859-1");
		ActionContext.getContext().put("fileName", fileName);
//		fileName = URLEncoder.encode(fileName, "utf8");
		System.out.println("-----"+fileName);
		// 准备要下载的数据
		inputStream = new FileInputStream(path);
		return "download";
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

}
