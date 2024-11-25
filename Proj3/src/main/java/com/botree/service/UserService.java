package com.botree.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.botree.dao.UserDao;
import com.botree.model.DeleteUser;
import com.botree.model.Employee;
import com.botree.model.RegisterUser;
import com.botree.model.UpdateUser;
import com.botree.model.User;
import com.botree.util.DbUtil;

public class UserService {
	
	UserDao userDao = new UserDao();
	
	public boolean validate(RegisterUser u) {
		if(!u.pswd().equals(u.cpswd())) {
			return false;
		}else {
			userDao.registerUser(u);
			return true;
		}
	}
	
	
	
	public boolean authenticateUser(User user) {
		var u = userDao.getUser(user);
		
		return u!=null && u.name().equals(user.name())&& u.password().equals(user.password());
		
	}
	
	public boolean deleteUser(DeleteUser user) {
		userDao.deleteUser1(user);
		return true;
	}
	
	
	public boolean updateUser(Employee e) {
		userDao.updateUser1(e);
		return true;
	}
	
	
	
	
	
}
