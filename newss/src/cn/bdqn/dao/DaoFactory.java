package cn.bdqn.dao;

import cn.bdqn.daoImpl.Category.CategoryDaoImpl;
import cn.bdqn.daoImpl.Datail.DatailDaoImpl;
import cn.bdqn.daoImpl.User.UserDaoImpl;


/**
 * Dao层工厂类，根据业务层传入的参数，获取要使用的Dao层对象
 * @author Administrator
 *
 */
public class DaoFactory {
	private static DaoFactory daoFactory;
	/**
	 * 静态代码块，加载类时即可获取daoFactory对象
	 * 
	 */
	static{
		if (daoFactory==null) {//双重所，处理高并发
			synchronized (DaoFactory.class) {
				if (daoFactory==null) {
					daoFactory=new DaoFactory();
				}
			}
		}
	}
	/**
	 * 私有化构造
	 */
	private DaoFactory(){
		
	}
	/**
	 * 根据业务层发送的参数，获取相应的Dao层访问数据库对象
	 * @param  daoSign对应Dao层访问数据库对象的标记
	 * @return Dao层访问数据库对象
	 */
	public static ConDao getDaoImpl(String daoSign ){
		ConDao conDao=null;
		if ("UserDaoImpl".equals(daoSign)) {
			conDao=new UserDaoImpl();
		}else if ("DatailDaoImpl".equals(daoSign)) {
			conDao=new DatailDaoImpl();
		}else if ("CategoryDaoImpl".equals(daoSign)) {
			conDao=new CategoryDaoImpl();
		}
		return conDao;
	}
	
	
	
}
