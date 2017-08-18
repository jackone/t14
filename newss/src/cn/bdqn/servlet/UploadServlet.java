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
 * �ļ�����
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
		   //��ȡ�ļ���
		   String picPath = request.getParameter("picPath");
		
		if (picPath!=null||!"".equals(picPath.trim())) {
			//��ȡ�ļ��ڷ�������Ŀ¼
		   String uploadPath = request.getSession().getServletContext().getRealPath("upload/");
		  //ƴ����ʵ�ļ���ַ
		   File saveFile=new File(uploadPath, picPath);
		   
		   if(saveFile.exists()){  
	            FileInputStream  fis = new FileInputStream(saveFile); 
	            
	            String filename=URLEncoder.encode(saveFile.getName(),"utf-8"); //��������ļ������غ����������  
	            byte[] b = new byte[fis.available()];// �ѿ����õ���Դ���������ֽ������� 
	            fis.read(b);  
	            response.setCharacterEncoding("utf-8");
	            //Content-Disposition �����õ�Content-Type ������ΪҪ���ص�����ʱ , �����Ϣͷ��������������ļ������ֺ����͡�
	            response.setHeader("Content-Disposition","attachment; filename="+filename+"");  
	            //��ȡ��Ӧ���������  
	            ServletOutputStream  out =response.getOutputStream();  
	            //���  
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
