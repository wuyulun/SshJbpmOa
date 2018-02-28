package com.hyjcy.oa.base;

import java.lang.reflect.ParameterizedType;

import com.opensymphony.xwork2.ModelDriven;

public class ModelDrivenBaseAction<T> extends BaseAction implements ModelDriven<T> {
	// ===================== 对ModelDriven的支持====================
	protected T model;

	public ModelDrivenBaseAction() {
		System.out.println("----------> BaseAction.BaseAction()");
		try {
			// 通过反射获取T的真实类型
			ParameterizedType pt = (ParameterizedType) this.getClass()
					.getGenericSuperclass();
			Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];
			// 通过反射创建model的实体
			model = clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public T getModel() {
		return model;
	}


}
