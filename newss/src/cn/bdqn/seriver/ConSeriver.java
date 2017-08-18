package cn.bdqn.seriver;

import java.io.Serializable;
import java.util.List;

import cn.bdqn.util.Page;

public interface ConSeriver<T> {

	/**
	 * ��ȡ���ݿ��ж������ݵ��ܼ�¼��
	 * @return
	 */ 
	Integer getTotalCount();
	
	/**
	 * ͨ��ID��ȡЯ����Ϣ�Ķ���
	 * @param id
	 * @return
	 */
	T getById(Serializable id);
	
	/**
	 * ��ȡ����Я����Ϣ�Ķ����б�
	 * @return
	 */
	List<T> getList();

	/**
	 * ͨ����ҳ�����ȡЯ����Ϣ�Ķ����б�
	 * @param pageUtil ��ҳ����
	 * @return
	 */
	List<T> getList(Page page);

	/**
	 * ��Я���û�������Ϣ�Ķ��󣬲�����id�����ݸ����ݷ��ʲ㲢����
	 * @param T   Я���û�������Ϣ�Ķ���
	 * @return
	 */
	boolean add(T t);

	/**
	 * ��Я��id��Ϣ�Ķ��󣬴��ݸ����ݷ��ʲ㲢ִ��ɾ���ö������Ϣ
	 * @param t Я��id��Ϣ�Ķ���
	 * @return
	 */
	boolean delete(T t);

	/**
	 * ��Я���û�������Ϣ�Ķ��󣬰���id�����ݸ����ݷ��ʲ㲢ͨ��id�޸�ָ���Ķ�����Ϣ
	 * @param t   Я���û�������Ϣ�Ķ��󣬰���id
	 * @return
	 */
	boolean update(T t);
	
	
	
}
