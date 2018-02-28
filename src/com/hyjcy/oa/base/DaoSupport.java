package com.hyjcy.oa.base;

import java.util.List;

import com.hyjcy.oa.domain.PageBean;
import com.hyjcy.oa.util.QueryHelper;

public interface DaoSupport<T> {

	/**
	 * 保存实体
	 * @param entity
	 */
	void save(T entity);
	void merge(T entity);
	/**
	 * 删除实体
	 * @param id
	 */
	void delete(Long id);

	/**
	 * 更新实体
	 * @param entity
	 */
	void update(T entity);

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	T getById(Long id);
	
	/**
	 * 根据id数组查询多个
	 * @param ids
	 * @return
	 */
	List<T> getByIds(Long[] ids);


	/**
	 * 查询所有
	 * @return
	 */
	List<T> findAll();
	/**
	 * @param pageNum
	 * @param queryHelper
	 * @return
	 */
	
	/**
	 * 公共的查询分页信息的方法（最终版）
	 * 
	 * @param pageNum
	 * @param queryHelper
	 *            查询语句 + 参数列表
	 * @return
	 */
	PageBean getPageBean(int pageNum, QueryHelper queryHelper);
	
	T getByCondition(String condition);


}