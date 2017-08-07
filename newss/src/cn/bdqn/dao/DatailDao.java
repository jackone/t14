package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.bean.Category;
import cn.bdqn.bean.Datail;

public interface DatailDao {
	//查询所有新闻信息
	List<Datail> findDatailByList();

	int delete(int id);
	//通过ID 查询单条新闻信息
	Datail findById(int id);
	//修改信息
	int updateDatail(Datail datail);
	//添加新闻信息
	boolean addDatail(Datail datail);

	List<Category> findCategory();
		
}
