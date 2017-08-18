package cn.bdqn.dao;

import java.util.List; 

import cn.bdqn.util.Page;


public interface ConDao<T> {
	/**
	 * ��ȡ���ݿ������ܼ�¼��
	 * @return
	 */
	Integer getTotalCount();
	
	/**
	 * ����id�����ݿ��ȡ��Ӧ��������Ϣ����װ�ɶ���
	 * @param id ָ����id
	 * @return ��װ�ɶ���
	 */
	T getById(java.io.Serializable id);
	
	/**
	 * �����ݿ��ȡ�����б�
	 * @return 
	 */
	List<T> getList();
	
	/**
	 * ���ݷ�ҳ�����з�ҳ��Ϣ�������ݿ��ȡ�����б�
	 * @param pageUtil ��ҳ����
	 * @param sql SQL���
	 * @return ��ҳ�����б�
	 */
	List<T> getList(Page page);
	
	/**
	 * ���ݶ���Я������Ϣ��û��id���������ݿ������Ϣ
	 * @param t Я����Ϣ�Ķ���
	 * @return Ӱ�������
	 */
	int add(T t);
	
	/**
	 * ���ݶ���Я����id��Ϣ�������ݿ�ɾ����Ӧ��Ϣ
	 * @param t Я��id�Ķ���
	 * @return Ӱ�������
	 */
	int delete(T t);
	
	/**
	 * ���ݶ���Я������Ϣ��id��Ϣ�������ݿ��޸���Ϣ
	 * @param t Я����Ϣ��id��Ϣ�Ķ���
	 * @param sql SQL���
	 * @return Ӱ�������
	 */
	int update(T t);
		
}
