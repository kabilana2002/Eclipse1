package com.botree.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.botree.model.Employee;
import com.botree.util.DbUtil;

public class EmployeeDao {
	
	PreparedStatement ps=null;
	
	public boolean employeeRegister(Employee e) {
		Connection conn = DbUtil.getConnection();
		try {
			ps =conn.prepareStatement("insert into employee values(?,?,?)");
			ps.setInt(1, e.getId());
			ps.setString(2, e.getName());
			ps.setInt(3, e.getSalary());
			ps.execute();
			
		}catch(Exception e1){
			System.out.println("failed");
		}
		System.out.println(conn);
		return true;
	}
	public List<Employee> getAllEmp(){
		List<Employee> list = new ArrayList<>();
		Connection conn = DbUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("select * from employee");
			rs = ps.executeQuery();
			while(rs.next()) {
				var e = new Employee(rs.getInt("id"),rs.getString("name"),rs.getInt("salary"));
				list.add(e);
			}
		}catch(Exception e) {
			return list;
		}
		
		return list;
	}
	
}
