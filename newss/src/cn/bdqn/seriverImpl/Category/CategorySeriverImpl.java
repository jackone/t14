package cn.bdqn.seriverImpl.Category;

import java.io.Serializable;
import java.util.List;

import cn.bdqn.bean.Category;
import cn.bdqn.dao.DaoFactory;
import cn.bdqn.dao.Category.CategoryDao;
import cn.bdqn.seriver.Category.CategorySeriver;
import cn.bdqn.util.Page;

public class CategorySeriverImpl implements CategorySeriver {
	private CategoryDao categoryDao;
	public CategorySeriverImpl(){
		categoryDao=(CategoryDao) DaoFactory.getDaoImpl("CategoryDaoImpl");
		
	}
	@Override
	public Integer getTotalCount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category getById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getList() {
		
		return categoryDao.getList();
	}

	@Override
	public List<Category> getList(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Category t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Category t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Category t) {
		// TODO Auto-generated method stub
		return false;
	}

}
