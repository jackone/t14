package cn.bdqn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.bean.Datail;
import cn.bdqn.bean.User;
import cn.bdqn.seriver.DatailSeriver;
import cn.bdqn.seriver.UserSeriver;
import cn.bdqn.seriverImpl.DatailSeriverImpl;
import cn.bdqn.seriverImpl.UserSeriverImpl;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
    	String name=request.getParameter("username");
    	String password=request.getParameter("password");
    	UserSeriver userSeriver=new UserSeriverImpl();
    	User user=userSeriver.login(name, password);
    	if(user==null){
    		response.sendRedirect("login.jsp");
    	}else{
    	request.getSession().setAttribute("user", user);
    	request.getRequestDispatcher("ListServlet").forward(request, response);
    	}
		
		
		
	}

}
