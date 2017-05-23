package com.niit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.niit.util.JDBCUtil;

public class JDBC5 {

	public static void main(String[] args) {
		Connection mysqlcon = null;
		try {

			Scanner sc = new Scanner(System.in);
			mysqlcon = JDBCUtil.getMysqlConenction();

			// Bulk Operations
			PreparedStatement pstmt = mysqlcon.prepareStatement("insert into student values(?,?,?)");

			String decider = null;

			do {

				System.out.println("enter  firstName***");
				String firstName = sc.next();
				System.out.println("enter  lastName***");
				String lastName = sc.next();
				System.out.println("enter  stId***");
				int st_Id = sc.nextInt();

				pstmt.setString(1, firstName);
				pstmt.setString(2, lastName);
				pstmt.setInt(3, st_Id);

				pstmt.executeUpdate();

				System.out.println("Do you wish to contine y/n ");
				decider = sc.next();

			} while (decider.equalsIgnoreCase("y"));

			System.out.println("Done*****");

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {

			JDBCUtil.closeMysqlConenction(mysqlcon);
		}
	}
}
