package com.retailermaintain.webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.print("<html><body  style=\"background-color:lightblue;\">");
		pw.print("<center><h3><p style=\"background:Yellow\" style=\"width: 100px\" style=\"font-size:30\"> <font size='25'> <b>Welcom To My E-Commerce Website</b></font></p></h3></center>\r\n" + 
				"");
		RequestDispatcher rd; 
		 HttpSession ss=request.getSession(false);
		 if(ss!=null) {
						 String email=(String) ss.getAttribute("email");
						 ServletContext context=getServletContext();
						 String name= (String) context.getAttribute("name");
						 pw.print("<p style='background:red' ><hr>");
						  pw.print("<h3><font >Welcome Mr./Mrs. "+name+" </font></h3><h3 align='right'><form action='Search'><input type='text' name='preq' placeholder=\"Search Product\" required/><input type='submit' value='search'></form></h3>");
						  pw.print("<h3 align='right'><a href='OrderDetail'>View My Order</a>|<a href='CartView'>View Cart</a>|<a href='Profile'>Profile</a>|<a href='HomeServlet'>Home</a>|<a href='Logout'>Logout</a></h3><hr>");
						  pw.print("</p>");
								
		 
		 
		 
		
		 
		 try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/retailerproject?user=root&password=incapp");
				Statement st=con.createStatement();
				
				ResultSet rs1=st.executeQuery("select rrid from rdetail where email='"+email+"' ");
				rs1.next();
				int rid=rs1.getInt(1);
				con.close();
		 }
		 catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		 
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/retailerproject?user=root&password=incapp");
			Statement st=con.createStatement();
			
			pw.print("<h1 align='center'>Available Product </h1>");	
		    pw.print("<center>");
			pw.print("<h3><table border='1'><tr><th>Product id</th><th> Product Name</th><th>Product Price</th><th>Add Cart</th></tr>");
			
			ResultSet rs=st.executeQuery("Select * from productdetail");
		while(rs.next()) {
			
				pw.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td><a href='QtyServlet?id="+rs.getInt(1)+"'>Add Cart</a></form></td></tr>");
		}
		
	
		pw.print("</table>");
		 pw.print("</center>");
		 con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 }
		 else {
	    	 pw.print("<h1 align='center'>Login First</h1>");
	    	 pw.print("<h3 align='right'><a href='OrderDetail'>View My Order</a>|<a href='CartView'>View Cart</a>|<a href='Profile'>Profile</a>|<a href='HomeServlet'>Home</a>|<a href='Logout'>Logout</a></h3><hr>");
				
	    	 pw.print("<hr>");
	    	  request.getRequestDispatcher("Login.html").include(request, response);
	    
	     }
			

	}

}
