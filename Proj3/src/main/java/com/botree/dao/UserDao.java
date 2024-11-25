package com.botree.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.botree.model.DeleteUser;
import com.botree.model.Employee;
import com.botree.model.RegisterUser;
import com.botree.model.UpdateUser;
import com.botree.model.User;
import com.botree.util.DbUtil;

public class UserDao {

	public User getUser(User user) {

		User u = null;
		Connection conn = DbUtil.getConnection();

		try {
			PreparedStatement ps = conn.prepareStatement("select name,password from user where name=?");
			ps.setString(1, user.name());
			ResultSet rs = ps.executeQuery();
			rs.next();

			u = new User(rs.getString("name"), rs.getString("password"));
		} catch (Exception e) {
			return u;
		}
		return u;
	}

	public boolean registerUser(RegisterUser u) {

		Connection conn = DbUtil.getConnection();
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement("insert into user values(?,?)");
			ps.setString(1, u.username());
			ps.setString(2, u.pswd());
			ps.execute();
			return true;
		} catch (Exception e) {
			System.out.println("Error in insertion");
			return false;
		}
	}

	public boolean deleteUser1(DeleteUser user) {

		Connection conn = DbUtil.getConnection();
		PreparedStatement ps = null;
		try {

			ps = conn.prepareStatement("delete from employee where id=?");
			ps.setInt(1, user.id());
			ps.execute();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public boolean updateUser1(Employee e) {
		Connection conn = DbUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update employee set name=?, salary=? where id=?");
			ps.setString(1, e.getName() );
			ps.setInt(2, e.getSalary());
			ps.setInt(3, e.getId());
			ps.execute();
			return true;
		}catch(Exception e1) {
			return false;
		}
		
	}
	
	
	
}
