package com.mauricio;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MiFilter implements Filter {

	public MiFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession httpSession=((HttpServletRequest)request).getSession();
		System.out.println("doFilter");
		
		if (httpSession.getAttribute("usuario")!=null) {
			//
			chain.doFilter(request, response);
			System.out.println("doFilter");
		}else {
			((HttpServletResponse) response).sendRedirect("/fiter/index.jsp");
			System.err.println("doFilter");
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
