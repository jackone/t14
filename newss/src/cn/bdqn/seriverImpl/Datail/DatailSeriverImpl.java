package cn.bdqn.seriverImpl.Datail;

import java.io.Serializable;
import java.util.List;

import cn.bdqn.bean.Category;
import cn.bdqn.bean.Datail;
import cn.bdqn.dao.DaoFactory;
import cn.bdqn.dao.Datail.DatailDao;
import cn.bdqn.daoImpl.Datail.DatailDaoImpl;
import cn.bdqn.seriver.Datail.DatailSeriver;
import cn.bdqn.util.Page;

public class DatailSeriverImpl implements DatailSeriver {
	private DatailDao dao;
	public DatailSeriverImpl(){
		dao=(DatailDao)DaoFactory.getDaoImpl("DatailDaoImpl");
	}
	@Override
	public Integer getTotalCount() {
		
		return dao.getTotalCount();
	}

	@Override
	public Datail getById(Serializable id) {
		return dao.getById(id);
	}

	@Override
	public List<Datail> getList() {
		return dao.getList();
	}

	@Override
	public List<Datail> getList(Page page) {
		return dao.getList(page);
	}

	@Override
	public boolean add(Datail t) {
		boolean flag=false;
		if (dao.add(t)>0) {
			flag=true;
		}else {
			flag=false;
		}
		return flag;
	}

	@Override
	public boolean delete(Datail t) {
		boolean flag=false;
		if (dao.delete(t)>0) {
			flag=true;
		}else {
			flag=false;
		}
		return flag;
	}

	@Override
	public boolean update(Datail t) {
		boolean flag=false;
		if (dao.update(t)>0) {
			flag=true;
		}else {
			flag=false;
		}
		return flag;
	}
	
}
