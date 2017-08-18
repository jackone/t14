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
@WebServlet("/DelServlet")
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
		DatailSeriver datailSeriver=(DatailSeriver) SeriverFactory.getSeriverImpl("DatailSeriverImpl");
    	Datail t=new Datail();
    	t.setId(id);
    	if(datailSeriver.delete(t)){
    	System.out.print("É¾³ý³É¹¦£¡");
    	request.getRequestDispatcher("ListServlet").forward(request, response);
    		//response.sendRedirect("/ListServlet");
    	}
	
	}
	
}
