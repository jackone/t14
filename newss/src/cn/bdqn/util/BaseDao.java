package cn.bdqn.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;






public class BaseDao  {
	/*
	 * 锟斤拷锟斤拷锟斤拷锟斤拷
	 * 
	 * 
	 */
	protected Connection connection=null;
	protected PreparedStatement ps=null;
	protected ResultSet rs=null;
	//properties 锟斤拷菘锟斤拷锟斤拷
	
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	//锟矫撅拷态锟斤拷锟斤拷榉斤拷锟斤拷锟斤拷锟�
	static{
		init();
	}
	/*
	 * 锟斤拷锟斤拷锟斤拷锟侥硷拷锟斤拷锟斤拷锟接诧拷锟斤拷
	 */
	public static void init(){
		Properties params=new Properties();
		String configFile="database.properties";
		//锟窖硷拷锟截碉拷锟斤拷锟斤拷锟侥硷拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
		InputStream is = BaseDao.class.getClassLoader().getResourceAsStream(configFile);
		try {
			//锟斤拷锟斤拷锟斤拷锟叫讹拷取锟斤拷锟斤拷锟叫憋拷
			params.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver=params.getProperty("driver");
		url=params.getProperty("url");
		user=params.getProperty("user");
		password=params.getProperty("password");
		
		
	}
	
	
	
	public boolean getConnection(){
		try {
			Class.forName(driver);
			/*Context ctx=new InitialContext();
			DataSource dataSource=(DataSource)ctx.lookup("java:com/env/jdbc/news");
			connection = dataSource.getConnection();*/
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	//锟酵凤拷锟斤拷源
		public void closeConnection() {
			try {
				if (rs!=null) {
					rs.close();
				}
				if (ps!=null) {
					ps.close();
				}
				if (connection!=null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		//锟斤拷删锟斤拷
		public int executeUpdate(String sql,Object...param) {
			int row = 0;
			if (getConnection()) {
				try {
					ps = connection.prepareStatement(sql);
					if (param!=null) {
					for (int i = 0; i < param.length; i++) {
						ps.setObject(i+1, param[i]);
					}
					}
					row = ps.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					closeConnection();
				}
			}
			return row;
		}
		//锟斤拷询
		public ResultSet executeQuery(String sql,Object...param) {
			if (getConnection()) {
				try {
					ps = connection.prepareStatement(sql);
					if (param!=null) {
					for (int i = 0; i < param.length; i++) {
						ps.setObject(i+1, param[i]);
					}
					}
					rs = ps.executeQuery();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
			return rs;
		}
	
	
	
}
