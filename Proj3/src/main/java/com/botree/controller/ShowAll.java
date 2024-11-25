package com.botree.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.botree.dao.EmployeeDao;
import com.botree.model.Employee;

public class ShowAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowAll() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Show all is working");

		HttpSession session = request.getSession();

		EmployeeDao empDao = new EmployeeDao();

		List<Employee> list = empDao.getAllEmp();

		System.out.println("All employee list" + list);
		session.setAttribute("empList", list);

		response.sendRedirect("showAll.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Show all is working");

		HttpSession session = request.getSession();

		EmployeeDao empDao = new EmployeeDao();

		List<Employee> list = empDao.getAllEmp();
		session.setAttribute("empList", list);
		
		

		response.sendRedirect("showAll.jsp");
	}

}
