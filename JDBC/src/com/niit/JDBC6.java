package com.niit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.niit.util.JDBCUtil;

public class JDBC6 {

	public static void main(String[] args) {
		Connection mysqlcon = null;
		try {

			mysqlcon = JDBCUtil.getMysqlConenction();

			Statement stmt = mysqlcon.createStatement();
			ResultSet result = stmt.executeQuery("select * from student");

			while (result.next()) {

				System.out.println(result.getString(1) + "\t" + result.getString(2) + "\t" + result.getInt(3));

			}

		}

		catch (Exception e) {

		}
	}
}
