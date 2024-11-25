package com.botree.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import com.botree.model.User;
import com.botree.service.UserService;
import com.botree.util.DbUtil;

/**
 * Servlet implementation class LoginServlet
 */
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String name = request.getParameter("name");
		String pswd = request.getParameter("password");
		PrintWriter pw = response.getWriter();
		/*
		 * if(name.equals("kabi")&& pswd.equals("123")){
		 * response.sendRedirect("home.html"); }else {
		 * response.sendRedirect("index.html"); }
		 */
		HttpSession session = request.getSession();

		session.setAttribute("name", name);
		String n = (String) session.getAttribute("name");

		pw.write(n);

		getServletContext().setAttribute(pswd, "password");
		String m = (String) getServletContext().getAttribute("pswd");
		pw.write(m);

	}

	@Override
	public void init() {
		System.out.println("Init method called");
	}

	public void service() {
		System.out.println("Service method called");
	}

	@Override
	public void destroy() {
		System.out.println("Destroy method called");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s = getServletConfig().getInitParameter("contact");
		System.out.println(s);

		String name = request.getParameter("name");
		String pswd = request.getParameter("password");
		PrintWriter pw = response.getWriter();

		User user = new User(name, pswd);

		var userSer = new UserService();
		/*
		 * if(userSer.authenticateUser(user)) { response.sendRedirect("home.html");
		 * }else { response.sendRedirect("Index.html"); }
		 */

		HttpSession session = request.getSession();

		System.out.println(session.getId());
		Date d = new Date(session.getCreationTime());
		System.out.println(d);


		System.out.println(session.getId() + "last accessed " + new Date(session.getCreationTime()));

		session.setAttribute("name", name);

		System.out.println(session.isNew());
		System.out.println(session.getMaxInactiveInterval());

		session.setAttribute("name", name);
		String n = (String) session.getAttribute("name");

		pw.write(n);

		Cookie cookie = new Cookie("name", name);
		response.addCookie(cookie);

		getServletContext().setAttribute("pswd", pswd);
		String m = (String) getServletContext().getAttribute("pswd");
		pw.write(m);

		if (userSer.authenticateUser(user)) {

			response.sendRedirect("home.jsp");
		} else {
			session.setAttribute("error", "Invalid username or password");
			response.sendRedirect("index.jsp");
		}

	}

}
