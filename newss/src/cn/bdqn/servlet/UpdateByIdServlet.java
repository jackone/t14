package cn.bdqn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.bean.Datail;
import cn.bdqn.seriver.DatailSeriver;
import cn.bdqn.seriverImpl.DatailSeriverImpl;

public class UpdateByIdServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		  String id1=request.getParameter("id");
		  	int id=Integer.parseInt(id1);
		  	DatailSeriver seriver=new DatailSeriverImpl();
		  	//通过id查询要修改的新闻信息
		  	Datail datail=seriver.findById(id);
		  	request.setAttribute("datail", datail);
			request.getRequestDispatcher("update.jsp").forward(request, response);
		  	
	}

}
