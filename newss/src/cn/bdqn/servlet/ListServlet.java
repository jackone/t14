package cn.bdqn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.bean.Datail;
import cn.bdqn.seriver.SeriverFactory;
import cn.bdqn.seriver.Datail.DatailSeriver;
import cn.bdqn.seriverImpl.Datail.DatailSeriverImpl;
import cn.bdqn.util.Page;
@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DatailSeriver datailSeriver=(DatailSeriver) SeriverFactory.getSeriverImpl("DatailSeriverImpl");
		Page page=new Page();
		page.setPageCount(datailSeriver.getTotalCount());
		request.setCharacterEncoding("utf-8");
		 String pageIndex = request.getParameter("pageIndex");
		if (pageIndex!=null&&!"".equals(pageIndex)) {
			page.setPageIndex(Integer.parseInt(pageIndex));
		}else {
			page.setPageIndex(1);
		}
		List <Datail> datails=datailSeriver.getList(page);
		
		
		//List <Datail> datails=datailSeriver.findDatailByList();
    	
		
		request.setAttribute("datails", datails);
    	request.setAttribute("page", page);
    	//response.sendRedirect("main.jsp");
    	request.getRequestDispatcher("main.jsp").forward(request, response);
		
	}
	
}
