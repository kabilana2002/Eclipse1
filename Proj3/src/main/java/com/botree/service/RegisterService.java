package com.botree.service;

import com.botree.dao.EmployeeDao;
import com.botree.model.Employee;

public class RegisterService {
	
	EmployeeDao empDao = new EmployeeDao();
	
	public boolean registerEmployee (Employee employee) {
		empDao.employeeRegister(employee);
		return true;
	}
	
}
