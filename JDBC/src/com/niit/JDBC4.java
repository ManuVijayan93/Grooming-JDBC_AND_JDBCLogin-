package com.niit;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.niit.util.JDBCUtil;

public class JDBC4 {

	public static void main(String[] args) {

		try {

			Connection mysqlcon = JDBCUtil.getMysqlConenction();

			PreparedStatement pstmt = mysqlcon.prepareStatement("insert into student values(?,?,?)");

			pstmt.setString(1, "prince");
			pstmt.setString(2, "Ton");
			pstmt.setInt(3, 30455);

			pstmt.executeUpdate();

			System.out.println("Done*****");

		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
