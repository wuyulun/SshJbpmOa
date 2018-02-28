package com.hyjcy.oa.install;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hyjcy.oa.domain.Privilege;
import com.hyjcy.oa.domain.User;

/**
 * 安装程序（初始化数据）
 * 
 * @author tyg
 * 
 */
@Component
public class Installer {

	@Resource
	private SessionFactory sessionFactory;

	@Transactional
	public void install() {
		Session session = sessionFactory.getCurrentSession();

		// =======================================================================
		// 1，超级管理员
		User user = new User();
		user.setLoginName("admin");
		user.setName("超级管理员");
		user.setPassword(DigestUtils.md5Hex("admin")); // 密码要使用MD5摘要
		session.save(user); // 保存

		// =======================================================================
		// 2，权限数据
		Privilege menu, menu1, menu2, menu3, menu4, menu5,menu6,menu7;

		menu = new Privilege("系统管理", null, null);
		menu1 = new Privilege("岗位管理", "/role_list", menu);
		menu2 = new Privilege("部门管理", "/department_list", menu);
		menu3 = new Privilege("用户管理", "/user_list", menu);

		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);

		session.save(new Privilege("岗位列表", "/role_list", menu1));
		session.save(new Privilege("岗位删除", "/role_delete", menu1));
		session.save(new Privilege("岗位添加", "/role_add", menu1));
		session.save(new Privilege("岗位修改", "/role_edit", menu1));

		session.save(new Privilege("部门列表", "/department_list", menu2));
		session.save(new Privilege("部门删除", "/department_delete", menu2));
		session.save(new Privilege("部门添加", "/department_add", menu2));
		session.save(new Privilege("部门修改", "/department_edit", menu2));

		session.save(new Privilege("用户列表", "/user_list", menu3));
		session.save(new Privilege("用户删除", "/user_delete", menu3));
		session.save(new Privilege("用户添加", "/user_add", menu3));
		session.save(new Privilege("用户修改", "/user_edit", menu3));
		session.save(new Privilege("用户初始化密码", "/user_initPassword", menu3));

		

		menu = new Privilege("技术运维", null, null);
		menu1 = new Privilege("发起申请", "/guzhangshenpi_shenqing", menu);
		menu2 = new Privilege("申报处理", "/guzhangshenpi_chuli", menu);
		menu3 = new Privilege("审批记录", "/guzhangshenpi_shenpijilu", menu);
		menu4 = new Privilege("申报记录", "/guzhangshenpi_jilu", menu);
		menu5 = new Privilege("设备信息", "/Device_list", menu);
		
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);
		session.save(menu4);
		session.save(menu5);
		
		menu = new Privilege("订餐管理", null, null);
		menu1 = new Privilege("我要订餐", "/dining_index", menu);
		menu2 = new Privilege("用餐统计", "/dining_statistics", menu);
		menu3 = new Privilege("用餐记录", "/dining_record", menu);
		
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);
		
		
		menu = new Privilege("物品领取", null, null);
		menu1 = new Privilege("物品申请", "/wupinshenpi_shenqing", menu);
		menu2 = new Privilege("待办申请..", "/wupinshenpi_chuli", menu);
		menu3 = new Privilege("审批记录..", "/wupinshenpi_shenpijilu", menu);
		menu4 = new Privilege("申请记录..", "/wupinshenpi_jilu", menu);
		
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);
		session.save(menu4);
		
		menu = new Privilege("用车管理", null, null);
		menu1 = new Privilege("用车申请", "/usecar_shenqing", menu);
		menu2 = new Privilege("待办申请.", "/usecar_lingdaochuli", menu);
		menu3 = new Privilege("审批记录.", "/usecar_lingdaoshenpijilu", menu);
		menu4 = new Privilege("申请记录", "/usecar_usecarjilu", menu);
		menu5 = new Privilege("待办申请", "/usecar_shoucheyuansp", menu);
		menu6 = new Privilege("审批记录", "/usecar_shoucheyuanjl", menu);
		menu7 = new Privilege("车辆信息", "/Car_list", menu);
		
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);
		session.save(menu4);
		session.save(menu5);
		session.save(menu6);
		session.save(menu7);

	}

	public static void main(String[] args) {
		System.out.println("正在初始化数据...");

		// 一定要从Spring容器中取出对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Installer installer = (Installer) ac.getBean("installer");
		// 执行安装
		installer.install();

		System.out.println("初始化数据完毕！");
	}

}
