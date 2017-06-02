package org.jimmy.javaweb;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class Loginservlet implements Servlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("请求过来啦'");
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		
		System.out.println(name + " : " +  password);
		
		if ("1".equals(name)) {
			System.out.println("成功");
			HttpServletRequest httpReq = (HttpServletRequest) req;
			httpReq.getSession().setAttribute("isLogin", true);
			req.getRequestDispatcher("index.jsp").forward(req, res);
		} else {
			System.out.println("失败");
			req.getRequestDispatcher("login.jsp").forward(req, res);
		}
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
