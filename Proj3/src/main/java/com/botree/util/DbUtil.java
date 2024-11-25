package com.botree.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	public DbUtil() {
		super();
	}

	public static Connection getConnection() {

		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing", "kabilan", "Bsipl@123");
		} catch (Exception e) {
			return null;
		}
		return conn;
	}


}
