package com.botree.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Register() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		session.removeAttribute("update");
		session.removeAttribute("delete");
		session.removeAttribute("allEmp");
		
		
		session.setAttribute("register", "register");
		
		
		session.setAttribute("msg", "Registered");
		
		response.sendRedirect("home.jsp");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
