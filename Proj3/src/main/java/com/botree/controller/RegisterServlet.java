package com.botree.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.botree.model.Employee;
import com.botree.service.RegisterService;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
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
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		String num=request.getParameter("id");
		String name=request.getParameter("name");
		String salary=request.getParameter("salary");
		String s = getServletConfig().getInitParameter("contact");
		System.out.println(s);

		
		HttpSession session  = request.getSession();
		
		
		Employee e = new Employee(Integer.parseInt(num),name, Integer.parseInt(salary));
		System.out.println(e);
		
		var registerService = new RegisterService();
		
		if(registerService.registerEmployee(e)) {
			session.setAttribute("msg", "registered");
			System.out.println("Registered");
			response.sendRedirect("home.jsp");

		}else {
			session.setAttribute("msg", "not registered");
			response.sendRedirect("home.jsp");

		}
	
		
	}

}
