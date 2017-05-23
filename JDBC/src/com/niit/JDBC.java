package com.niit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC {

	public static void main(String[] args) {

		try {

			System.out.println("step1/Load the Driver class**");

			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("step2/get the Connection **");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javabase", "root", "");

			System.out.println("step3/ create the statement**");
			Statement stmt = conn.createStatement();

			System.out.println("step4/compose  SQL query");

			String sql = "create table Student( st_firstName varchar(25),st_lastName varchar(25),st_Id int)";
			System.out.println("step5/Trigger   the SQL query");

			stmt.execute(sql);

			System.out.println("Table created**");

		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
