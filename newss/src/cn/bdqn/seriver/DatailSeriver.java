package cn.bdqn.seriver;

import java.util.List;

import cn.bdqn.bean.Category;
import cn.bdqn.bean.Datail;

public interface DatailSeriver {
	List<Datail> findDatailByList();
	int delete(int id);
	Datail findById(int id);
	
	boolean updateDatail(Datail datail);
	//���
	boolean addDatail(Datail datail);
	List<Category> findCategory();
	
	
}
