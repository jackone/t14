package cn.bdqn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.bean.Category;
import cn.bdqn.bean.Datail;
import cn.bdqn.seriver.SeriverFactory;
import cn.bdqn.seriver.Category.CategorySeriver;
import cn.bdqn.seriver.Datail.DatailSeriver;
import cn.bdqn.seriverImpl.Datail.DatailSeriverImpl;
@WebServlet("/FindCategoryServlet")
public class FindCategoryServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CategorySeriver seriver=(CategorySeriver) SeriverFactory.getSeriverImpl("CategorySeriverImpl");
         List<Category> list= seriver.getList(); 
         request.setAttribute("categorys", list);
         request.getRequestDispatcher("add.jsp").forward(request, response);
	}

}
