package com.botree.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FilterTwo")
public class FilterTwo extends HttpServlet implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse res = (HttpServletResponse) response;
		response.getWriter().print("this is filterTwo request");
		chain.doFilter(request, response);

		response.getWriter().print("This is fiterTwo response ");

	}

}
