package cn.bdqn.dao;

import cn.bdqn.bean.User;

public interface UserDao {
	User login(String name,String  password);
	
}
