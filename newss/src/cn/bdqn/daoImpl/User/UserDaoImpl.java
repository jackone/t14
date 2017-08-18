package cn.bdqn.daoImpl.User;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cn.bdqn.bean.User;
import cn.bdqn.dao.User.UserDao;
import cn.bdqn.util.BaseDao;
import cn.bdqn.util.Page;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public User login(String name, String password)  {
		String sql="select * from news_user where userName=? and password=? ";
		Object []params={name,password};
		ResultSet rs = executeQuery(sql,params);
		User user=null;
		try {
			if (rs.next()) {
				user=new User();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setUserType(rs.getInt("userType"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeConnection();
		}
		return user;
	}

	@Override
	public Integer getTotalCount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getList(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(User t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(User t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(User t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
