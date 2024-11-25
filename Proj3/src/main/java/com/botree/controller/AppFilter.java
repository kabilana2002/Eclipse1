package com.botree.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AppFilter
 */
public class AppFilter extends HttpServlet implements Filter {
	private static final long serialVersionUID = 1L;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		
		
		
		HttpServletRequest req = (HttpServletRequest)request;
		
		if(req.getRequestURI().contains("getAllEmp")) {
			HttpSession session = req.getSession();
			if(session.getAttribute("name").equals("kabi")) {
				session.setAttribute("role", "admin");
			}else {
				session.setAttribute("role", "user");
			}
		}
		
		chain.doFilter(request, response);
		
		
		
	}
    

}
