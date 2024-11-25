package com.botree.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.botree.dao.EmployeeDao;
import com.botree.dao.UserDao;
import com.botree.model.DeleteUser;
import com.botree.model.Employee;
import com.botree.model.User;
import com.botree.service.UserService;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

PrintWriter pw = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("input id"));
		DeleteUser user= new DeleteUser(id);
		
		var userSer = new UserService();
		if(userSer.deleteUser(user)) {
			pw.print("Deleted");
		}else {
			pw.print("not deleted");
		}
	}
	


}
