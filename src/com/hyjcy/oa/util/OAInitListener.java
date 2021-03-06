package com.hyjcy.oa.util;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.hyjcy.oa.domain.Privilege;
import com.hyjcy.oa.service.PrivilegeService;

/**
 * 
 * @ClassName: OAInitListener
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @Author: wyxx
 * @Date: 2016年8月18日 下午3:29:03
 * @version V1.0
 */

public class OAInitListener implements ServletContextListener {

	private Log log = LogFactory.getLog(OAInitListener.class);

	// 初始化
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();

		// 从Spring的容器中取出PrivilegeService的对象实例.
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(application); // 获取Spring的监听器中创建的Spring容器对象
		PrivilegeService privilegeService = (PrivilegeService) ac.getBean("privilegeServiceImpl");

		// 1，查询所有顶级的权限列表并放到application作用域中
		List<Privilege> topPrivilegeList = privilegeService.findTopList();
		application.setAttribute("topPrivilegeList", topPrivilegeList);
//		System.out.println(topPrivilegeList+ "--------------------");
//		log.info("====== topPrivilegeList已经放到application作用域中了！ ======");
		
		// 2，查询出所有的权限的URL集合并放到application作用域中
		List<String> allPrivilegeUrls = privilegeService.getAllPrivilegeUrls();
		application.setAttribute("allPrivilegeUrls", allPrivilegeUrls);
//		log.info("====== allPrivilegeUrls已经放到application作用域中了！ ======");
	}

	// 销毁
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
