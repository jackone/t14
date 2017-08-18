package cn.bdqn.seriver;

import cn.bdqn.seriverImpl.Category.CategorySeriverImpl;
import cn.bdqn.seriverImpl.Datail.DatailSeriverImpl;
import cn.bdqn.seriverImpl.User.UserSeriverImpl;

/**
 * Seriver�㹤���࣬����ҵ��㴫��Ĳ�������ȡҪʹ�õ�Seriver�����
 * @author Administrator
 *
 */
public class SeriverFactory {
   private  static SeriverFactory seriverFactory;
	   /**
		 * ��̬����飬������ʱ���ɻ�ȡseriverFactory����
		 * 
		 */
	   static {
			   if (seriverFactory==null) {//˫����������߲���
				   synchronized (SeriverFactory.class) {
					if (seriverFactory==null) {
						seriverFactory=new SeriverFactory();
					}
				}
		   }
	   }
	   
	   /**
	    * ˽�л�����
	    */
		   private SeriverFactory(){
			   
		   }
	   /**
		 * ����ҵ��㷢�͵Ĳ�������ȡ��Ӧ��Seriver��������ݿ����
		 * @param  seriverSign��ӦSeriver��������ݿ����ı��
		 * @return Seriver��������ݿ����
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
