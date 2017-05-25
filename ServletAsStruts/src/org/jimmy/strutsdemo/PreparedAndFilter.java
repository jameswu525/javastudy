package org.jimmy.strutsdemo;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jimmy.servlet.i.IStructsServlet;

/**
 * Servlet Filter implementation class PreparedAndFilter
 */
@WebFilter("/PreparedAndFilter")
public class PreparedAndFilter implements Filter {

    /**
     * Default constructor. 
     */
    public PreparedAndFilter() {
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
		HashMap<String, String> servlets = new HashMap<>();
		servlets.put("/login",  "org.jimmy.servlet.LoginServlet");
		servlets.put("/logout",  "org.jimmy.servlet.LogoutServlet");
		
		HttpServletRequest httpRequest=(HttpServletRequest)request;
		HttpServletResponse httpResponse=(HttpServletResponse)response;
		String path = httpRequest.getRequestURI();
		path = path.substring(httpRequest.getContextPath().length());
		String clz = servlets.get(path);
		System.out.println(path + ":" + clz);
		if(!"".equals(clz) && clz != null) {
			try {
				IStructsServlet o = (IStructsServlet)Class.forName(clz).newInstance();
				o.excute(httpRequest, httpResponse);
				httpRequest.getRequestDispatcher("index.jsp").forward(request, response);
			} catch (Exception e) {
				//e.printStackTrace();
			}
			
		} else {
			System.out.println("no path");
			httpRequest.getRequestDispatcher("error.jsp").forward(request, response);
		}
		

		// pass the request along the filter chain
		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
