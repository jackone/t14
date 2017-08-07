package cn.bdqn.seriverImpl;

import cn.bdqn.bean.User;
import cn.bdqn.dao.UserDao;
import cn.bdqn.daoImpl.UserDaoImpl;
import cn.bdqn.seriver.UserSeriver;

public class UserSeriverImpl implements UserSeriver {
	UserDao newDao=new UserDaoImpl();
	@Override
	public User login(String name, String password) {
		
		return newDao.login(name, password);
	}

}
