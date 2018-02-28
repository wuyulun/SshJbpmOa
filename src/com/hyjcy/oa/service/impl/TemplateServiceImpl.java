package com.hyjcy.oa.service.impl;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.hyjcy.oa.base.DaoSupportImpl;
import com.hyjcy.oa.domain.Template;
import com.hyjcy.oa.service.TemplateService;

/**
 * @ClassName: TemplateServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @Author: wyxx
 * @Date: 2016年8月22日 下午5:30:44
 * @version V1.0
 */

@Controller
@Transactional
public class TemplateServiceImpl extends DaoSupportImpl<Template> implements TemplateService{
	
	public void delete(Long id){
		
		Template template=getById(id);
		
		//删除文件记录
		File file=new File(template.getPath());
		//判断文件是否存在，如果存在就删除
		if (file.exists()) {
			file.delete();
		}
		// 删除数据库记录
		getSession().delete(template);
	}
}
