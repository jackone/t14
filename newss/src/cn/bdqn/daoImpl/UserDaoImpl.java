package cn.bdqn.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.bdqn.bean.User;
import cn.bdqn.dao.UserDao;
import cn.bdqn.util.BaseDao;

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

}
