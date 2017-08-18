package cn.bdqn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.bean.Datail;
import cn.bdqn.seriver.SeriverFactory;
import cn.bdqn.seriver.Datail.DatailSeriver;
import cn.bdqn.seriverImpl.Datail.DatailSeriverImpl;
@WebServlet("/UpdateServlet")
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
	  	DatailSeriver seriver=(DatailSeriver) SeriverFactory.getSeriverImpl("DatailSeriverImpl");
	  	//通过id查询要修改的新闻信息
	  	Datail datail=new Datail();
	  	datail.setId(id);
	  	datail.setCategoryId(Integer.parseInt(request.getParameter("categoryId")));
	  	System.out.println("新闻类别ID"+Integer.parseInt(request.getParameter("categoryId")));
    	datail.setAuthor(request.getParameter("author"));
    	datail.setContent(request.getParameter("content"));
    	datail.setSummary(request.getParameter("summary"));
    	datail.setTitle(request.getParameter("title"));
    	boolean flag=seriver.update(datail);
    		if(flag){
    			request.getRequestDispatcher("ListServlet").forward(request, response);
    			//response.sendRedirect("main.jsp");
    		}else{
    		
    			response.sendRedirect("update.jsp");
    		}
		
	}
	
	
}
