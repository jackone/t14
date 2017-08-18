package cn.bdqn.daoImpl.Category;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bdqn.bean.Category;
import cn.bdqn.dao.Category.CategoryDao;
import cn.bdqn.daoImpl.ResultSetUtils;
import cn.bdqn.util.BaseDao;
import cn.bdqn.util.Page;

public class CategoryDaoImpl extends BaseDao implements CategoryDao {

	@Override
	public Integer getTotalCount() {
		return null;
	}

	@Override
	public Category getById(Serializable id) {
		return null;
	}

	@Override
	public List<Category> getList() {
		String sql="select * from `news_category`";
		ResultSet rs = executeQuery(sql);
		List<Category> list=new ArrayList<Category>();
		try {
			list=ResultSetUtils.eachResultSet(rs, Category.class);
		}finally{
			closeConnection();
		}
		return list;
	}

	@Override
	public List<Category> getList(Page page) {
		return null;
	}

	@Override
	public int add(Category t) {
		return 0;
	}

	@Override
	public int delete(Category t) {
		return 0;
	}

	@Override
	public int update(Category t) {
		return 0;
	}

}
