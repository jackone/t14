package cn.bdqn.seriverImpl.User;

import java.io.Serializable;
import java.util.List;

import cn.bdqn.bean.User;
import cn.bdqn.dao.DaoFactory;
import cn.bdqn.dao.User.UserDao;
import cn.bdqn.daoImpl.User.UserDaoImpl;
import cn.bdqn.seriver.User.UserSeriver;
import cn.bdqn.util.Page;

public class UserSeriverImpl implements UserSeriver {
	private  UserDao userDao;
	public UserSeriverImpl(){
		userDao=(UserDao) DaoFactory.getDaoImpl("UserDaoImpl");
	}
	@Override
	public User login(String name, String password) {
		
		return userDao.login(name, password);
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
	public boolean add(User t) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean delete(User t) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean update(User t) {
		// TODO Auto-generated method stub
		return false;
	}

}
