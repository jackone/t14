package cn.bdqn.seriver;

import cn.bdqn.seriverImpl.Category.CategorySeriverImpl;
import cn.bdqn.seriverImpl.Datail.DatailSeriverImpl;
import cn.bdqn.seriverImpl.User.UserSeriverImpl;

/**
 * Seriver层工厂类，根据业务层传入的参数，获取要使用的Seriver层对象
 * @author Administrator
 *
 */
public class SeriverFactory {
   private  static SeriverFactory seriverFactory;
	   /**
		 * 静态代码块，加载类时即可获取seriverFactory对象
		 * 
		 */
	   static {
			   if (seriverFactory==null) {//双重所，处理高并发
				   synchronized (SeriverFactory.class) {
					if (seriverFactory==null) {
						seriverFactory=new SeriverFactory();
					}
				}
		   }
	   }
	   
	   /**
	    * 私有化构造
	    */
		   private SeriverFactory(){
			   
		   }
	   /**
		 * 根据业务层发送的参数，获取相应的Seriver层访问数据库对象
		 * @param  seriverSign对应Seriver层访问数据库对象的标记
		 * @return Seriver层访问数据库对象
		 */
		 public static ConSeriver getSeriverImpl(String seriverSign){
			 ConSeriver conSeriver=null;
			 if ("UserSeriverImpl".equals(seriverSign)) {
				 conSeriver=new UserSeriverImpl();
			}if ("CategorySeriverImpl".equals(seriverSign)) {
				 conSeriver=new CategorySeriverImpl();
			}if ("DatailSeriverImpl".equals(seriverSign)) {
				 conSeriver=new DatailSeriverImpl();
			}
			 
			 
			 return conSeriver;
		 }  
		   
		   
		   
		   
}
