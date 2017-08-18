package cn.bdqn.dao;

import java.util.List; 

import cn.bdqn.util.Page;


public interface ConDao<T> {
	/**
	 * 获取数据库数据总记录数
	 * @return
	 */
	Integer getTotalCount();
	
	/**
	 * 根据id从数据库获取对应的数据信息，封装成对象
	 * @param id 指定的id
	 * @return 封装成对象
	 */
	T getById(java.io.Serializable id);
	
	/**
	 * 从数据库获取对象列表
	 * @return 
	 */
	List<T> getList();
	
	/**
	 * 根据分页对象中分页信息，从数据库获取对象列表
	 * @param pageUtil 分页对象
	 * @param sql SQL语句
	 * @return 分页对象列表
	 */
	List<T> getList(Page page);
	
	/**
	 * 根据对象携带的信息（没有id），向数据库添加信息
	 * @param t 携带信息的对象
	 * @return 影响的行数
	 */
	int add(T t);
	
	/**
	 * 根据对象携带的id信息，从数据库删除对应信息
	 * @param t 携带id的对象
	 * @return 影响的行数
	 */
	int delete(T t);
	
	/**
	 * 根据对象携带的信息和id信息，在数据库修改信息
	 * @param t 携带信息和id信息的对象
	 * @param sql SQL语句
	 * @return 影响的行数
	 */
	int update(T t);
		
}
