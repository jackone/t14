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
			//��ΪServletRequest��HttpServletRequest�ĸ��ӿڣ��ӱȸ������㣬Ҫ����ת��
			HttpServletRequest req=(HttpServletRequest) request;
			HttpServletResponse resp=(HttpServletResponse) response;
			//��ȡ�û�ǰ̨��·��
			String path=req.getRequestURI();
			//��session�л�ȡ�Ƿ��ж���
			User user= (User) req.getSession().getAttribute("user");
			//��ֹ��ʽ��ʧ�����ù�����ʽ
			if (path.indexOf("login")>-1||user!=null||(path.contains(".css")||path.contains(".js")&&(!path.contains(".jsp")))) {
				//����
				chain.doFilter(request, response);
			}else {
				resp.sendRedirect("login.jsp");
			}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
