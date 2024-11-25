package com.botree.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import com.botree.model.RegisterUser;
import com.botree.service.UserService;

/**
 * Servlet implementation class RegisterUserServlet
 */
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("username");
		String pswd = request.getParameter("password");
		String cpswd = request.getParameter("confirm password");

		var u = new RegisterUser(name, pswd, cpswd);

		HttpSession session = request.getSession();

		session.setAttribute("error", "user already existed");

		System.out.println(u.username());
		System.out.println(u.pswd());
		System.out.println(u.cpswd());

		var userSer = new UserService();

		if (userSer.validate(u)) {
			session.setAttribute("error", "user already existed");
			response.sendRedirect("registerUser.jsp");
		} else {

			response.sendRedirect("index.jsp");
		}
	}

}
