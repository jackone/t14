package cn.bdqn.daoImpl.Datail;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cn.bdqn.bean.Datail;
import cn.bdqn.dao.Datail.DatailDao;
import cn.bdqn.daoImpl.ResultSetUtils;
import cn.bdqn.util.BaseDao;
import cn.bdqn.util.Page;

public class DatailDaoImpl extends BaseDao implements DatailDao {
	@Override
	public Integer getTotalCount() {
		String sql="select count(1) from news_detail";
		ResultSet rs = executeQuery(sql);
		int num=0;
		try {
			if (rs.next()) {
				num=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeConnection();
		}
		return num;
	}

	@Override
	public Datail getById(Serializable id) {
		String sql="select * from news_detail where id=?  ";
		Object[] params={id};
		ResultSet rs = executeQuery(sql,params);
		Datail datail=null;
		try {
			datail=ResultSetUtils.eachResult(rs, Datail.class);
		}finally{
			closeConnection();
		}
		return datail;
	}

	@Override
	public List<Datail> getList() {
		List<Datail> dList=new ArrayList<Datail>();
		String sql="select * from news_detail ";
		ResultSet rs = executeQuery(sql);
		try {
			dList=ResultSetUtils.eachResultSet(rs, Datail.class);
		} finally{
			closeConnection();
		}
		return dList;
		
		
	}

	@Override
	public List<Datail> getList(Page page) {

		List<Datail> dList=new ArrayList<Datail>();
		String sql="select * from news_detail limit ?,?";
		Object []params={(page.getPageIndex()-1)*page.getPageSize(),page.getPageSize()};
		ResultSet rs = executeQuery(sql, params);
		try {
			dList=ResultSetUtils.eachResultSet(rs, Datail.class);
			
		}finally{
			closeConnection();
		}
		return dList;
	}

	@Override
	public int add(Datail datail) {
		
		String sql="insert into news_detail (categoryId,title,summary,content,picPath,author,createDate) values(?,?,?,?,?,?,?)";
		Object[] params={datail.getCategoryId(),datail.getTitle(),datail.getSummary(),datail.getContent(),datail.getPicPath(),
							datail.getAuthor(),datail.getCreateDate()};
		  int num = executeUpdate(sql,params);
		return num;
	}

	@Override
	public int delete(Datail datail) {
		String sql="delete from news_detail where id=?";
		Object []params={datail.getId()};
		return executeUpdate(sql, params);
	}

	@Override
	public int update(Datail datail) {
		String sql="update news_detail set categoryId=?, title=?,summary=? ,content=?,author=? where id=?";
		Object[] params={datail.getCategoryId(),datail.getTitle(),datail.getSummary(),datail.getContent(),datail.getAuthor(),datail.getId()};
		  executeUpdate(sql,params);
		return executeUpdate(sql,params);
	}
}
