package cn.bdqn.seriverImpl;

import java.util.List;

import cn.bdqn.bean.Category;
import cn.bdqn.bean.Datail;
import cn.bdqn.dao.DatailDao;
import cn.bdqn.daoImpl.DatailDaoImpl;
import cn.bdqn.seriver.DatailSeriver;

public class DatailSeriverImpl implements DatailSeriver {
	DatailDao datailDao=new DatailDaoImpl();
	@Override
	public List<Datail> findDatailByList() {
		// TODO Auto-generated method stub
		return datailDao.findDatailByList();
	}
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return datailDao.delete(id);
	}
	//通过id 查询要修改的新闻信息
	@Override
	public Datail findById(int id) {
		// 
		return datailDao.findById(id);
	}
	@Override
	public boolean updateDatail(Datail datail) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if (datailDao.updateDatail(datail)>0) {
			flag=true;
		}else {
			flag=false;
		}
		return flag;
	}
	
	//添加
	public boolean addDatail(Datail datail) {
		// TODO Auto-generated method stub
		return datailDao.addDatail(datail);
	}
	@Override
	public List<Category> findCategory() {
		
		return datailDao.findCategory();
	}
}
