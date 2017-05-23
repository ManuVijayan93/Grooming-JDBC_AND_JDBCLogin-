package com.niit;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginAction() {
		super();

	}

	public void init(ServletConfig config) throws ServletException {

	}

	public void destroy() {
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("uname");
		String password = request.getParameter("password");
		RequestDispatcher rd = null;
		try {

			Connection mysqlcon = JDBCUtil.getMysqlConenction();

			Statement stmt = mysqlcon.createStatement();

			String sql = "SELECT * FROM User WHERE username='" + username + "'" + "and password='" + password + "'";

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				if (rs.getString(1).equals(username) && rs.getString(2).equals(password)) {

					rd = request.getRequestDispatcher("home.jsp");
					rd.include(request, response);

				}

				else {

					rd = request.getRequestDispatcher("login.jsp");
					rd.include(request, response);

				}
			}

		}

		catch (

		Exception e) {
			e.printStackTrace();
		}

	}

}
