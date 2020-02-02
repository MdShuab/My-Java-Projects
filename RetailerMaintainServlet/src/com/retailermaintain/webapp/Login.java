package com.retailermaintain.webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		 String email=request.getParameter("email");
	      String password=request.getParameter("password");
	      RequestDispatcher rd;
	  	  ServletContext context=getServletContext();
	  	HttpSession ss;  
	      
	      try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/retailerproject?user=root&password=incapp");
			PreparedStatement pst=con.prepareStatement("select * from rdetail where remail=? and pass=? ");
			pst.setString(1, email);
			pst.setString(2, password);
			ResultSet rs= pst.executeQuery();
			
			if(rs.next()) {
				
			      ss=request.getSession();
		    	  ss.setAttribute("email", email);
		    	  context.setAttribute("name", rs.getString(2));
				
				pw.print("<h1 align='center' style='font:white'><pre><lebel style=\"background:green\">  LogIn Success!  </lebel></pre></h1>");
			   
				rd=request.getRequestDispatcher("HomeServlet");
			    rd.forward(request, response);
			}
			else {
				pw.print("<h1>Invalid User Name or password</h1>");
				rd=request.getRequestDispatcher("Login.html");
			    rd.include(request, response);
		
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
