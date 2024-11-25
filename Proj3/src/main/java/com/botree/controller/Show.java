package com.botree.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.botree.dao.EmployeeDao;
import com.botree.model.Employee;

@WebServlet("/Show")
public class Show extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Show() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Show is working");

		HttpSession session = request.getSession();

		session.removeAttribute("register");
		session.removeAttribute("update");
		session.removeAttribute("delete");

		session.setAttribute("allEmp", "allEmp");

		EmployeeDao empDao = new EmployeeDao();

		List<Employee> list = empDao.getAllEmp();
		session.setAttribute("empList", list);
		
		

		response.sendRedirect("home.jsp");

	}
}
