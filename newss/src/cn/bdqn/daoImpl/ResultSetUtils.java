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
	 * @param rs ResultSet�����
	 * @param clazz δȷ����
	 * @return T���󼯺�
	 */
	public static <T> List<T> eachResultSet(ResultSet rs,Class<T> clazz){
		List<T> list=new ArrayList<T>();
		//ѭ��Result 01���Ȼ�ȡ���� 02.ѭ�����Ը�ֵ 03.��ӵ�����
		try {
			while (rs.next()) {
				T object=clazz.newInstance();//ʵ��������
				Field[] files = clazz.getDeclaredFields();//�õ������ֶεļ���
				for (Field f : files) {
					f.setAccessible(true);//���Է���˽�л��ֶΣ�����ֵ
					f.set(object, rs.getObject(f.getName()));
				}
				list.add(object);//�Ž�����
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
	 * @param rs ResultSet�����
	 * @param clazz δȷ����
	 * @return T����
	 */
	public static <T> T eachResult(ResultSet rs,Class<T> clazz){
		
		//ѭ��Result 01���Ȼ�ȡ���� 02.ѭ�����Ը�ֵ 
		T object=null;
		try {
			while (rs.next()) {
				object=clazz.newInstance();//ʵ��������
				Field[] files = clazz.getDeclaredFields();//�õ������ֶεļ���
				for (Field f : files) {
					f.setAccessible(true);//���Է���˽�л��ֶΣ�����ֵ
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
