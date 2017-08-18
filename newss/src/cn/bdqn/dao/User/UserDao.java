package cn.bdqn.dao.User;

import cn.bdqn.bean.User;
import cn.bdqn.dao.ConDao;

public interface UserDao extends ConDao<User>{
	User login(String name,String  password);
	
}
