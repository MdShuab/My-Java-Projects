package com.retailermaintain.webapp;

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
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter	pw=response.getWriter();
		pw.print("<html><body  style=\"background-color:lightblue;\">");
		pw.print("<center><h3><p style=\"background:Yellow\" style=\"width: 100px\" style=\"font-size:30\"> <b> <font size='25'> My E-Commerce Website </font> </b></p></h3></center>\r\n" + 
				"");

		
		String Name=request.getParameter("Name");
		String address=request.getParameter("address");
		String contact=request.getParameter("contact");
		String password=request.getParameter("password");
		String Email=request.getParameter("Email");
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/retailerproject?user=root&password=incapp");
			PreparedStatement pst=con.prepareStatement("insert into rdetail (rname,remail,rcont,radd,pass) values(?,?,?,?,?)");
			pst.setString(1, Name);
			pst.setString(2, Email);
			pst.setString(3, contact);
			pst.setString(4, address);
			pst.setString(5, password);
			pst.execute();
			
			pw.print("<h1 align='center'><lebel style=\"background:green\">Registration Successful</lebel></h1><hr>");
			 request.getRequestDispatcher("Login.html").include(request, response);
			    
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}

}
