package com.niit;

import java.sql.Connection;
import java.sql.Statement;

import com.niit.util.JDBCUtil;

public class JDBC10 {

	public static void main(String[] args) {

		try {

			Connection mysqlcon = JDBCUtil.getMysqlConenction();

			Statement stmt = mysqlcon.createStatement();

			String sql = "DELETE FROM  STUDENT  WHERE st_Id=4";

			int number_rows_affected = stmt.executeUpdate(sql);

			System.out.println("number_rows_affected=" + number_rows_affected);
			System.out.println("Updated****");

		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
