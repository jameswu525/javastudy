package org.jimmy.mvcdemo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jimmy.mvc.servlet.BasicServlet;
import org.jimmy.mvcdemo.entity.UserEntity;
import org.jimmy.mvcdemo.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends BasicServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("user");
		String upwd =request.getParameter("pwd");
		LoginService service = new LoginService();
		UserEntity entity = service.validateUser(uname, upwd);
		if (entity.isSuccess()) {
			request.getSession().setAttribute("login_infor", entity);
			request.getRequestDispatcher(this.getServletConfig().getInitParameter("page")).forward(request, response);
		} else {
			request.setAttribute("message", entity.getMessage());
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
