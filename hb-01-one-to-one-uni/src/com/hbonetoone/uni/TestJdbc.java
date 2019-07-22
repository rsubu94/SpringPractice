package com.hbonetoone.uni;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class TestJdbc {
	public static void main(String[] args) {
		String jdbcUrl="jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSl=false";
		String username="hbstudent";
		String password="hbstudent";
		try {
			Connection connection = (Connection) DriverManager.getConnection(jdbcUrl, username, password);
			System.out.println(connection);		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
