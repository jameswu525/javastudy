package org.jimmy.demo01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet 
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//		System.out.println("doGet");
		// 设置response的编码
		response.setCharacterEncoding("UTF-8");
		if (this.getServletContext().getInitParameter("author").equals(request.getParameter("username"))) {
			// 请求redirect跳转
			response.sendRedirect("register.html");
		} else if ("include".equals(request.getParameter("username"))) {
			// 请求包含
			
			response.getWriter().append("<meta charset=\"UTF-8\">");
			response.getWriter().append("<h1>重新注册</h1>");
			request.getRequestDispatcher("hello").include(request, response);
		} else if ("forward".equals(request.getParameter("username"))) {
			// 请求forward重定向
			response.getWriter().append("<h1>包含的头部内容</h1>");
			request.getRequestDispatcher("hello").forward(request, response);
		} else {
			// 请求响应
			response.getWriter().append("Served at: ").append(request.getContextPath()).append(" <br/> ")
					.append(this.getServletContext().getInitParameter("author"));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//		System.out.println("doPost");
		doGet(request, response);
	}

}
