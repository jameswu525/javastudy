package org.jimmy.mvc.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.jimmy.mvc.entity.Entity;

/**
 * Servlet Filter implementation class ValidateLoginInfo
 */
@WebFilter("/ValidateLoginInfo.do")
public class ValidateLoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ValidateLoginFilter() {
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
		HttpServletRequest httpReq = (HttpServletRequest)request;
		String url = httpReq.getServletPath();
		System.out.println(new Date().toLocaleString() + " ==> " + httpReq.getLocalAddr() + " // " + url);
		if (!"/login.do".equals(url) && !"/login.jsp".equals(url)) {
			Entity entity = (Entity)httpReq.getSession().getAttribute("login_infor");
			System.out.println(entity);
			if (entity == null) {
				System.out.println("no session");
				httpReq.getRequestDispatcher(httpReq.getServletContext().getInitParameter("home")).forward(request, response);
			} else {
				chain.doFilter(request, response);
			}
		} else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
