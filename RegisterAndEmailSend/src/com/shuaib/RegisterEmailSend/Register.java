package com.shuaib.RegisterEmailSend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String username=request.getParameter("username");
		String gender=request.getParameter("gender");
		String yop=request.getParameter("yop");
		String email=request.getParameter("email");
		
		
		pw.print("From register");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ust?user=root&password=incapp");
			PreparedStatement pst=con.prepareStatement("insert into register_email (name,gender,yop,email) values(?,?,?,?)");
			pst.setString(1, username);
			pst.setString(2, gender);
			pst.setString(3, yop);
			pst.setString(4, email);
			pst.execute();
			pw.print("Registration Successfully!");
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

}
