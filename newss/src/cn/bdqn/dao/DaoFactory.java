package cn.bdqn.dao;

import cn.bdqn.daoImpl.Category.CategoryDaoImpl;
import cn.bdqn.daoImpl.Datail.DatailDaoImpl;
import cn.bdqn.daoImpl.User.UserDaoImpl;


/**
 * Dao�㹤���࣬����ҵ��㴫��Ĳ�������ȡҪʹ�õ�Dao�����
 * @author Administrator
 *
 */
public class DaoFactory {
	private static DaoFactory daoFactory;
	/**
	 * ��̬����飬������ʱ���ɻ�ȡdaoFactory����
	 * 
	 */
	static{
		if (daoFactory==null) {//˫����������߲���
			synchronized (DaoFactory.class) {
				if (daoFactory==null) {
					daoFactory=new DaoFactory();
				}
			}
		}
	}
	/**
	 * ˽�л�����
	 */
	private DaoFactory(){
		
	}
	/**
	 * ����ҵ��㷢�͵Ĳ�������ȡ��Ӧ��Dao��������ݿ����
	 * @param  daoSign��ӦDao��������ݿ����ı��
	 * @return Dao��������ݿ����
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
