package cn.bdqn.daoImpl;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * 
 *
 */
public class ResultSetUtils {
	/**
	 * 
	 * @param rs ResultSet结果集
	 * @param clazz 未确定类
	 * @return T对象集合
	 */
	public static <T> List<T> eachResultSet(ResultSet rs,Class<T> clazz){
		List<T> list=new ArrayList<T>();
		//循环Result 01，先获取对象 02.循环属性赋值 03.添加到集合
		try {
			while (rs.next()) {
				T object=clazz.newInstance();//实例化对象
				Field[] files = clazz.getDeclaredFields();//得到所有字段的集合
				for (Field f : files) {
					f.setAccessible(true);//可以访问私有化字段，并赋值
					f.set(object, rs.getObject(f.getName()));
				}
				list.add(object);//放进集合
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	/**
	 * 
	 * @param rs ResultSet结果集
	 * @param clazz 未确定类
	 * @return T对象
	 */
	public static <T> T eachResult(ResultSet rs,Class<T> clazz){
		
		//循环Result 01，先获取对象 02.循环属性赋值 
		T object=null;
		try {
			while (rs.next()) {
				object=clazz.newInstance();//实例化对象
				Field[] files = clazz.getDeclaredFields();//得到所有字段的集合
				for (Field f : files) {
					f.setAccessible(true);//可以访问私有化字段，并赋值
					f.set(object, rs.getObject(f.getName()));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return object;
	}
}
