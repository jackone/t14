package cn.bdqn.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 文件下载
 * @author Administrator
 *
 */
@WebServlet("/UploadServlet")
public class UploadServlet  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@SuppressWarnings("null")
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   request.setCharacterEncoding("utf-8");
		   //获取文件名
		   String picPath = request.getParameter("picPath");
		
		if (picPath!=null||!"".equals(picPath.trim())) {
			//获取文件在服务器的目录
		   String uploadPath = request.getSession().getServletContext().getRealPath("upload/");
		  //拼接真实文件地址
		   File saveFile=new File(uploadPath, picPath);
		   
		   if(saveFile.exists()){  
	            FileInputStream  fis = new FileInputStream(saveFile); 
	            
	            String filename=URLEncoder.encode(saveFile.getName(),"utf-8"); //解决中文文件名下载后乱码的问题  
	            byte[] b = new byte[fis.available()];// 把可利用的资源数保存在字节数组中 
	            fis.read(b);  
	            response.setCharacterEncoding("utf-8");
	            //Content-Disposition 的作用当Content-Type 的类型为要下载的类型时 , 这个信息头会告诉浏览器这个文件的名字和类型。
	            response.setHeader("Content-Disposition","attachment; filename="+filename+"");  
	            //获取响应输出流对象  
	            ServletOutputStream  out =response.getOutputStream();  
	            //输出  
	            out.write(b);  
	            out.flush();  
	            out.close(); 
	            request.getRequestDispatcher("ListServlet").forward(request, response);
	        } else{
	        	
	        	request.getRequestDispatcher("ListServlet").forward(request, response);
	        }    
	          
	    }else {
	    	request.getRequestDispatcher("ListServlet").forward(request, response);
		}
	}   
		   
	
	
}
