package com.hibernate.demo.entity;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class TestJdbc {
	public static void main(String[] args) {
		String jdbcurl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "hbstudent";
		String password = "hbstudent";
		try {
			System.out.println("Connecting to database "+jdbcurl);
			Connection mConnection = (Connection) DriverManager.getConnection(jdbcurl, user, password);
			System.out.println("Connection Successful!!!!");
		} catch (Exception e) {
		}
	}

}
