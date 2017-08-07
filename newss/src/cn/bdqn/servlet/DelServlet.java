package cn.bdqn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.seriver.DatailSeriver;
import cn.bdqn.seriverImpl.DatailSeriverImpl;

public class DelServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("id"));
    	DatailSeriver datailSeriver=new DatailSeriverImpl();
    	int num=datailSeriver.delete(id);
    	if(num>0){
    	System.out.print("É¾³ý³É¹¦£¡");
    	request.getRequestDispatcher("ListServlet").forward(request, response);
    		//response.sendRedirect("/ListServlet");
    	}
	
	}
	
}
