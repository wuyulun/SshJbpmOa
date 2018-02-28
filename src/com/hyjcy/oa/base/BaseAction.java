package com.hyjcy.oa.base;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.hyjcy.oa.domain.User;
import com.hyjcy.oa.service.CarService;
import com.hyjcy.oa.service.DepartmentService;
import com.hyjcy.oa.service.DeviceService;
import com.hyjcy.oa.service.DiningService;
import com.hyjcy.oa.service.FaultFormService;
import com.hyjcy.oa.service.FlowService;
import com.hyjcy.oa.service.GoodsformService;
import com.hyjcy.oa.service.GuzhangshenpiService;
import com.hyjcy.oa.service.PrivilegeService;
import com.hyjcy.oa.service.ProcessDefinitionService;
import com.hyjcy.oa.service.RoleService;
import com.hyjcy.oa.service.TemplateService;
import com.hyjcy.oa.service.UsecarFormService;
import com.hyjcy.oa.service.UsecarService;
import com.hyjcy.oa.service.UserService;
import com.hyjcy.oa.service.WupinshenpiService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class BaseAction extends ActionSupport{
	
	// ===================== 声明Service ====================
	@Resource
	protected RoleService roleService;
	@Resource
	protected DepartmentService departmentService;
	@Resource
	protected UserService userService;
	@Resource
	protected PrivilegeService privilegeService;
	@Resource
	protected ProcessDefinitionService processDefinitionService;
	@Resource
	protected TemplateService templateService;
	@Resource
	protected FlowService flowService;
	@Resource
	protected GuzhangshenpiService guzhangshenpiService;
	@Resource
	protected WupinshenpiService wupinshenpiService;
	@Resource
	protected DiningService diningService;
	@Resource
	protected FaultFormService faultFormService;
	@Resource
	protected GoodsformService goodsformservice;
	@Resource
	protected UsecarService usecarService;
	@Resource
	protected UsecarFormService usecarFormService;
	@Resource
	protected CarService carService;
	@Resource
	protected DeviceService deviceService;
	
	// ========================= 对分页的支持 =========================

		protected int pageNum = 1; // 当前页，默认为第1页

		public int getPageNum() {
			return pageNum;
		}

		public void setPageNum(int pageNum) {
			this.pageNum = pageNum;
		}

		// ========================== 工具方法 ==========================

		/**
		 * 获取当前登录的用户
		 */
		public User getCurrentUser() {//actioncontext用来得到action中的对象（application..）,返回map对象，线程安全threadlocal
			return (User) ActionContext.getContext().getSession().get("user");//实现方式二Action类可通过实现SessionAware接口
		}

		/**
		 * 获取客户户的IP地址
		 * 
		 * @return
		 */
		public String getRequestIP() {//servletactioncontext用于获得servlet api 优先使用actioncontext让action与web无关
			return ServletActionContext.getRequest().getRemoteAddr();
		}

		/**
		 * 保存上传的文件，并放回在服务端的真实的存储路径
		 * 
		 * @param upload
		 * @return
		 */
		protected String saveUploadFile(File upload) {
			// >> 1,得到在保存的文件路径的真是地址

			// 获取文件时间
			SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd");
			// 将文件保存到指定的路径
			String basePath = ServletActionContext.getServletContext().getRealPath(
					"/WEB-INF/upload_files");
 
			String datePath = sdf.format(new Date());
			// >> 2, 如果文件夹不存在，就创建
			File file = new File(basePath + datePath);
			if (!file.exists()) {
				file.mkdirs();
			}

			// 注意同名的问题，可以使用uuid做为文件名
			String path = basePath + datePath + "/" + UUID.randomUUID().toString();
			File destFile = new File(path);

			// >> 3, 移动文件
			upload.renameTo(destFile);

			return path;

		}

		/**
		 * 保存上传的图片，并放回在服务端的真实的存储路径
		 * 
		 * @param upload
		 * @return
		 */
		protected String saveImage(File upload) {
			// >> 1,得到在保存的文件路径的真是地址

			// 获取文件时间，用于防止一个文件夹里面检索时间太慢
			SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd");
			// 将文件保存到指定的路径
			String basePath = ServletActionContext.getServletContext().getRealPath(
					"Image_files");

			String datePath = sdf.format(new Date());
			// >> 2, 如果文件夹不存在，就创建
			File file = new File(basePath + datePath);
			if (!file.exists()) {
				file.mkdirs();//递归创建，mkdir只创建最后一层
			}

			String fileName = upload.getName();
			System.out.println(fileName);
			String suffix = fileName.substring(fileName.lastIndexOf("."));

			System.out.println(suffix);
			// 注意同名的问题，可以使用uuid做为文件名
			String path = basePath + datePath + "/" + UUID.randomUUID().toString()
					+ "." + "jpg";
			File destFile = new File(path);

			// >> 3, 移动文件
			upload.renameTo(destFile);

			return path;

		}

}
