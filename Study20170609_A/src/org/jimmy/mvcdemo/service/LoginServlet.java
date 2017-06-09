package org.jimmy.mvcdemo.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jimmy.mvc.pojo.PojoCache;
import org.jimmy.mvc.service.Service;
import org.jimmy.mvcdemo.pojo.LoginPojo;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends Service {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("user");
		String upwd =request.getParameter("pwd");
		LoginPojo pojo = new LoginPojo();
		PojoCache cache = pojo.validateUser(uname, upwd);
		if (!cache.hasError()) {
			request.getSession().setAttribute("login_infor", cache.getEntity());
			request.getRequestDispatcher(this.getServletConfig().getInitParameter("page")).forward(request, response);
		} else {
			request.setAttribute("message", cache.getMessage());
			request.getRequestDispatcher(getServletContext().getInitParameter("home")).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
