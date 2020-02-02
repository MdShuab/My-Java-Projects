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
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.print("<html><body  style=\"background-color:lightblue;\">");
		pw.print("<center><h3><p style=\"background:Yellow\" style=\"width: 100px\" style=\"font-size:30\"> <b> <font size='25'> My E-Commerce Website </font> </b></p></h3></center>\r\n" + 
				"");

		HttpSession ss=request.getSession(false);
		if(ss!=null) {
		RequestDispatcher rd;
		 ServletContext context=getServletContext();
			String name= (String) context.getAttribute("name");
			pw.print("<hr><h3><font >Welcome Mr./Mrs. "+name+" </font></h3><h3 align='right'><a href='OrderDetail'>View My Order</a>|<a href='CartView'>View Cart</a>|<a href='Profile'>Profile</a>|<a href='HomeServlet'>Home</a>|<a href='Logout'>Logout</a></h3><hr>");
			
		
		 String email=(String) ss.getAttribute("email");
		 
	//	String qty=request.getParameter("qty");
		String sid=request.getParameter("Productid");
		String qty=request.getParameter("qty");
		int pid=Integer.parseInt(sid);
		String pn=null;
		String pp=null;
		int rid=0;
	
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/retailerproject?user=root&password=incapp");
			Statement st=con.createStatement();
			ResultSet rs1= st.executeQuery("select rrid from rdetail where remail='"+email+"'");
			rs1.next();
			 rid=rs1.getInt(1);
			
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/retailerproject?user=root&password=incapp");
			Statement st=con.createStatement();
			
			ResultSet rs2=st.executeQuery("select * from productdetail where productid='"+pid+"'");
			rs2.next();
			 pn=rs2.getString(2);
			 pp=rs2.getString(3);
			
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/retailerproject?user=root&password=incapp");
			PreparedStatement pst=con.prepareStatement("insert into cart (productid,productname,productprice,qty,rid) values(?,?,?,?,?)");
			pst.setInt(1,pid );
			pst.setString(2,pn );
			pst.setString(3,pp );
			pst.setString(4,qty );
			pst.setInt(5,rid );
		    pst.execute();
		   
			//pw.print("Successful Cart added");
			pw.print("<h1 align='center'><lebel style=\"background:grey\"><font color='yellow'>Product Successful Cart added</font></lebel></h1>");
		//	request.getRequestDispatcher("CartView").include(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			//pw.print("Product Already added! Add Another Record.");
			//pw.print("<h1 align='center'><lebel style=\"background:green\">Product Already added! Add Another Record.</lebel></h1>");
			response.sendRedirect("CartView");
			
			
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
