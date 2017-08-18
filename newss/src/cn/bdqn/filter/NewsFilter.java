package cn.bdqn.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.bean.User;
@WebFilter("/*")
public class NewsFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
			request.setCharacterEncoding("utf-8");
			//因为ServletRequest是HttpServletRequest的父接口，子比父更优秀，要向下转化
			HttpServletRequest req=(HttpServletRequest) request;
			HttpServletResponse resp=(HttpServletResponse) response;
			//获取用户前台的路径
			String path=req.getRequestURI();
			//从session中获取是否有对象
			User user= (User) req.getSession().getAttribute("user");
			//防止样式丢失。不用过滤样式
			if (path.indexOf("login")>-1||user!=null||(path.contains(".css")||path.contains(".js")&&(!path.contains(".jsp")))) {
				//放行
				chain.doFilter(request, response);
			}else {
				resp.sendRedirect("login.jsp");
			}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
