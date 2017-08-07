package cn.bdqn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.bean.Category;
import cn.bdqn.bean.Datail;
import cn.bdqn.seriver.DatailSeriver;
import cn.bdqn.seriverImpl.DatailSeriverImpl;

public class FindCategoryServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         DatailSeriver seriver=new DatailSeriverImpl();
         List<Category> list= seriver.findCategory(); 
         request.setAttribute("categorys", list);
         request.getRequestDispatcher("add.jsp").forward(request, response);
	}

}
