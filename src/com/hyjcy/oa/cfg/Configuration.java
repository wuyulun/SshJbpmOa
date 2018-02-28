package com.hyjcy.oa.cfg;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @ClassName: Configuration
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @Author: wyxx
 * @Date: 2016年8月19日 下午4:00:19
 * @version V1.0
 */

public class Configuration {

	private static int pageSize = 10;

	static {
		InputStream in = null;
		try {
			
			// 加载default.properties配置文件
			Properties props = new Properties();
			in = Configuration.class.getClassLoader().getResourceAsStream("default.properties");
			props.load(in);

			// 获取配置的值
			pageSize = Integer.parseInt(props.getProperty("pageSize"));
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

	public static int getPageSize() {
		return pageSize;
	}

	public static void setPageSize(int pageSize) {
		Configuration.pageSize = pageSize;
	}

}