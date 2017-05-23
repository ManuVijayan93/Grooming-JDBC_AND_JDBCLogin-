package com.niit;

import java.sql.Connection;
import java.sql.Statement;

import com.niit.util.JDBCUtil;

public class JDBC3 {

	public static void main(String[] args) {

		try {

			Connection mysqlcon = JDBCUtil.getMysqlConenction();

			Statement stmt = mysqlcon.createStatement();

			String sql = "insert into student values('harichandana','lastname',30433)";

			int number_rows_affected = stmt.executeUpdate(sql);

			System.out.println("number_rows_affected=" + number_rows_affected);

		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
