package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.bean.Category;
import cn.bdqn.bean.Datail;

public interface DatailDao {
	//��ѯ����������Ϣ
	List<Datail> findDatailByList();

	int delete(int id);
	//ͨ��ID ��ѯ����������Ϣ
	Datail findById(int id);
	//�޸���Ϣ
	int updateDatail(Datail datail);
	//���������Ϣ
	boolean addDatail(Datail datail);

	List<Category> findCategory();
		
}
