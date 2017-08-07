package cn.bdqn.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.bdqn.bean.Category;
import cn.bdqn.bean.Datail;
import cn.bdqn.dao.DatailDao;
import cn.bdqn.util.BaseDao;

public class DatailDaoImpl extends BaseDao implements DatailDao {

	@Override
	public List<Datail> findDatailByList() {
		List<Datail> dList=new ArrayList<Datail>();
		String sql="select * from news_detail ";
		ResultSet rs = executeQuery(sql);
		
		try {
			while (rs.next()) {
				Datail datail=new Datail();
				datail.setId(rs.getInt("id"));
				datail.setCategoryId(rs.getInt("categoryId"));
				datail.setTitle(rs.getString("title"));
				datail.setSummary(rs.getString("summary"));
				datail.setContent(rs.getString("content"));
				datail.setPicPath(rs.getString("picPath"));
				datail.setAuthor(rs.getString("author"));
				datail.setCreateDate(rs.getDate("createDate"));
				datail.setModifyDate(rs.getDate("modifyDate"));
				dList.add(datail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeConnection();
		}
		return dList;
	}

	@Override
	public int delete(int id) {
		String sql="delete from news_detail where id=?";
		Object []params={id};
		return executeUpdate(sql, params);
	}
	//修改前，通过id查询修改前的信息
	@Override
	public Datail findById(int id) {
		String sql="select * from news_detail where id=?  ";
		Object[] params={id};
		ResultSet rs = executeQuery(sql,params);
		Datail datail=null;
		try {
			while (rs.next()) {
				datail=new Datail();
				datail.setId(rs.getInt("id"));
				datail.setCategoryId(rs.getInt("categoryId"));
				datail.setTitle(rs.getString("title"));
				datail.setSummary(rs.getString("summary"));
				datail.setContent(rs.getString("content"));
				datail.setPicPath(rs.getString("picPath"));
				datail.setAuthor(rs.getString("author"));
				datail.setCreateDate(rs.getDate("createDate"));
				datail.setModifyDate(rs.getDate("modifyDate"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return datail;
	}

	@Override
	public int updateDatail(Datail datail) {
		String sql="update news_detail set title=?,summary=? ,content=?,author=? where id=?";
		Object[] params={datail.getTitle(),datail.getSummary(),datail.getContent(),datail.getAuthor(),datail.getId()};
		  executeUpdate(sql,params);
		return executeUpdate(sql,params);
	}
	//添加新闻的DAO实现
	@Override
	public boolean addDatail(Datail datail) {
		boolean flag=false;
		String sql="insert into news_detail (categoryId,title,summary,content,picPath,author,createDate) values(?,?,?,?,?,?,?)";
		Object[] params={datail.getCategoryId(),datail.getTitle(),datail.getSummary(),datail.getContent(),datail.getPicPath(),
							datail.getAuthor(),datail.getCreateDate()};
		  int num = executeUpdate(sql,params);
		  if (num>0) {
			  flag=true;
		}else {
			flag=false;
		}
		return flag;
	}

	@Override
	public List<Category> findCategory() {
		String sql="select * from `news_category`";
		ResultSet rs = executeQuery(sql);
		List<Category> list=new ArrayList<Category>();
		try {
			while (rs.next()) {
				Category category=new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
			list.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeConnection();
		}
		return list;
	}

}
