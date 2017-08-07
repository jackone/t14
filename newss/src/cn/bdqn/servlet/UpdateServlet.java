package cn.bdqn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.bean.Datail;
import cn.bdqn.seriver.DatailSeriver;
import cn.bdqn.seriverImpl.DatailSeriverImpl;

public class UpdateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
    	
    	int id=Integer.parseInt(request.getParameter("id"));
	  	DatailSeriver seriver=new DatailSeriverImpl();
	  	//通过id查询要修改的新闻信息
	  	Datail datail=new Datail();
	  	datail=seriver.findById(id);
	  	
	  	
	  	
    	datail.setAuthor(request.getParameter("author"));
    	datail.setContent(request.getParameter("content"));
    	datail.setSummary(request.getParameter("summary"));
    	datail.setTitle(request.getParameter("title"));
    	
    	
    	boolean flag=seriver.updateDatail(datail);
    		if(flag){
    			request.getRequestDispatcher("ListServlet").forward(request, response);
    			//response.sendRedirect("main.jsp");
    		}else{
    		
    			response.sendRedirect("update.jsp");
    		}
		
	}
	
	
}
