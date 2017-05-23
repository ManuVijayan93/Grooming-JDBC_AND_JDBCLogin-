package com.niit;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegAction")
public class RegAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegAction() {
		super();

	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public void destroy() {

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("uname");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		Connection mysqlcon = null;
		RequestDispatcher rd = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");

			mysqlcon = DriverManager.getConnection("jdbc:mysql://localhost:3306/javabase", "root", "");

			PreparedStatement pstmt = mysqlcon.prepareStatement("insert into User  values(?,?,?)");

			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, email);

			if (pstmt.executeUpdate() == 1) {
				rd=request.getRequestDispatcher("login.jsp");
				rd.include(request, response);

			} else {

				rd=request.getRequestDispatcher("reg.jsp");
				rd.include(request, response);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
