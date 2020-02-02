package com.shuaib.RegisterEmailSend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Filter
 */
@WebServlet("/Filter")
public class Filter extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.print("Welcome to filter");
		String yop=request.getParameter("yop");
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ust?user=root&password=incapp");
			PreparedStatement pst=con.prepareStatement("Select * from register_email where yop=?");
			pst.setString(1, yop);
			ResultSet rs= pst.executeQuery();
			pw.print("<br><br>");
			pw.print("<h3><center><table border='1'><tr><th>Name</th><th>Gender</th><th>YOP</th><th>Email</th></tr>");
			
			while(rs.next()) {
				
				pw.print("<tr><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td><a href='EmailServlet?id="+rs.getString(5)+"'>"+rs.getString(5)+"<a></td></tr>");
		      
		
		}
			
			pw.print("</table></center></h3>");
			pw.print("<center><form action=\"ComposeAll\" method=\"get\"><input type='hidden' name='yop' value='"+yop+"'>"
					+ "<h3>Send Mail To All: <input type='submit' value='Click Here'></h3></form></center>");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
