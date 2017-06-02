package org.jimmy.javaweb;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class CheckSession
 */
@WebFilter("/CheckSession")
public class CheckSession implements Filter {

    /**
     * Default constructor. 
     */
    public CheckSession() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("过滤啦");
		HttpServletRequest httpreq = (HttpServletRequest) request;
		boolean result = "/login.do".equals(httpreq.getServletPath());
		Object obj = httpreq.getSession().getAttribute("isLogin");
		if (obj != null) {
			result = (boolean)obj || result;
		}
		System.out.println(result);
		if (!result) {
			System.out.println("需要登录，转至登陆界面");
			request.getRequestDispatcher("/login2.do").forward(request, response);
		} else {
			chain.doFilter(request, response);
		}

		// pass the request along the filter chain
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
