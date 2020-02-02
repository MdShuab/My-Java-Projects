package com.retailermaintain.webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.print("<html><body  style=\"background-color:lightblue;\">");
		pw.print("<center><h3><p style=\"background:Yellow\" style=\"width: 100px\" style=\"font-size:30\"> <b><font size='25'> My E-Commerce Website </font></b></p></h3></center>\r\n" + 
				"");

		HttpSession ss=request.getSession(false);
		if(ss!=null) {
		 ServletContext context=getServletContext();
			String name= (String) context.getAttribute("name");
			
			
			
			
			
			  pw.print("<hr><h1 align='center'>Welcome to Update</h1>");
			pw.print("<h3><font >Welcome Mr./Mrs. "+name+" </font> </h3><h3 align='right'><a href='CartView'>View Cart</a>|<a href='Profile'>Profile</a>|<a href='HomeServlet'>Home</a></h3><hr>");
		
			
			
			
			
			
			 String sname=request.getParameter("name");
		      String password=request.getParameter("password");
		      String cont=request.getParameter("cont");
		      String email=request.getParameter("email");
		      String add=request.getParameter("add");
		      String sid=request.getParameter("id");
		      int id=Integer.parseInt(sid);
		      RequestDispatcher rd;  
		      
		      try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/retailerproject?user=root&password=incapp");
				PreparedStatement pst=con.prepareStatement("update rdetail set rname=?,remail=?,rcont=?,radd=?,pass=? where rrid=?");
				pst.setString(1, sname);
				pst.setString(2, email);
				pst.setString(3, cont);
				pst.setString(4, add);
				pst.setString(5, password);
				pst.setInt(6, id);
				pst.execute();
				
				pw.print("<h1>Update Successful</h1>");
				 ss=request.getSession();
		    	  ss.setAttribute("email", email);
		    	  context.setAttribute("name", sname);
				
		     // response.sendRedirect("Profile");
				    
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				pw.print("SQL Excp");
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
