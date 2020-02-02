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
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.print("<html><body  style=\"background-color:lightblue;\">");
		pw.print("<center><h3><p style=\"background:Yellow\" style=\"width: 100px\" style=\"font-size:30\"> <b> <font size='25'> My E-Commerce Website </font> </b></p></h3></center>\r\n" + 
				"");

		 ServletContext context=getServletContext();
			String name= (String) context.getAttribute("name");
			pw.print("<hr><h3><font >Welcome Mr./Mrs. "+name+" </font></h3><h3 align='right'><a href='CartView'>View Cart</a>|<a href='Profile'>Profile</a>|<a href='HomeServlet'>Home</a></h3><hr>");
			
		RequestDispatcher rd;
		 HttpSession ss=request.getSession(false);
		 String email=(String) ss.getAttribute("email");
		 
		String n=request.getParameter("preq");
		int pid=Integer.parseInt(n);
		 pw.print("<center>");
		 int rid=0;
		
		 
		 
		 
		 try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/retailerproject?user=root&password=incapp");
				Statement st=con.createStatement();
				ResultSet rs1=st.executeQuery("select rrid from rdetail where email='"+email+"' ");
				rs1.next();
				rid=rs1.getInt(1);
				
					
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 
			

		 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/retailerproject?user=root&password=incapp");
			PreparedStatement pst=con.prepareStatement("select * from productdetail where productid=?");
			pst.setInt(1, pid);
			ResultSet rs= pst.executeQuery();
			
			
			if(rs.next()) {
				//rd=request.getRequestDispatcher("HomeServlet");
				//rd.include(request, response);
				pw.print("<br><h3>Searched Product</h3>");
				pw.print("<h3 ><table border='1'><tr><th>Product id</th><th> Product Name</th><th>Product Price</th><th>Product Qty.</th><th>Add Cart</th></tr>");
				
				pw.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+"<input type='text' name='qty' required='required'>"+"</td><td><a href='AddServlet?id="+rid+"'>Add Cart</a></td></tr>");
								
				
	
			}
			else {
				
				pw.print("<h1 >Product Is Not Available</h1>");
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 pw.print("</center>");
		

	
	}

}
