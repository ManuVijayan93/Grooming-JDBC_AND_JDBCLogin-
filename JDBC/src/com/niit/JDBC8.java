package com.niit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.niit.util.JDBCUtil;

public class JDBC8 {

	public static void main(String[] args) {
		Connection mysqlcon = null;
		try {

			mysqlcon = JDBCUtil.getMysqlConenction();
			Scanner sc = new Scanner(System.in);

			PreparedStatement pstmt = mysqlcon.prepareStatement("select * from student where st_Id=?");
			System.out.println("enter the st_Id");
			int st_id = sc.nextInt();

			pstmt.setInt(1, st_id);

			ResultSet result = pstmt.executeQuery();

			while (result.next()) {

				System.out.println(result.getString(1) + "\t" + result.getString(2) + "\t" + result.getInt(3));

			}

		}

		catch (Exception e) {

		}
	}
}
