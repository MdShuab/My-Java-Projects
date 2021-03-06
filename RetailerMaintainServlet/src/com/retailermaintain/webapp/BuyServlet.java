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
 * Servlet implementation class BuyServlet
 */
@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.print("<html><body  style=\"background-color:lightblue;\">");
		pw.print("<center><h3><p style=\"background:Yellow\" style=\"width: 100px\" style=\"font-size:30\"> <b> <font size='25'> My E-Commerce Website </font> </b></p></h3></center>\r\n" + 
				"");

		HttpSession ss=request.getSession(false);
		long ttotal=0;
		 String t=null;
		
		if(ss!=null) {
		 String email=(String) ss.getAttribute("email");
		 ServletContext context=getServletContext();
		String name= (String) context.getAttribute("name");
		pw.print("<hr><h3><font >Welcome Mr./Mrs. "+name+" </font></h3><h3 align='right'><a href='OrderDetail'>View My Order</a>|<a href='CartView'>View Cart</a>|<a href='Profile'>Profile</a>|<a href='HomeServlet'>Home</a>|<a href='Logout'>Logout</a></h3><hr>");
		
	String	pid=request.getParameter("id");
		RequestDispatcher rd;
	    int rid=0;
	    String pn=null;
	    String pp=null;
	    String pq=null;
	    String amtpay=null;
	    
	    int ppid=Integer.parseInt(pid);
	    
	  
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
			ResultSet rs1= st.executeQuery("select * from cart where productid='"+pid+"' and rid='"+rid+"'");
			rs1.next();
			rs1.getInt(1);
			pn=rs1.getString(2);
			pp=rs1.getString(3);
			pq=rs1.getString(4);
			rs1.getInt(5);
			
			int qty=Integer.parseInt(pq);
			int price=Integer.parseInt(pp);
			long total=(qty*price);
			amtpay=total+"";
			
			
			con.close();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/retailerproject?user=root&password=incapp");
			PreparedStatement pst=con.prepareStatement("insert into productorder (pname,pprice,qty,amtpayable,rid,pid) values(?,?,?,?,?,?)");
			pst.setString(1,pn);
			pst.setString(2,pp );
			pst.setString(3,pq );
			pst.setString(4, amtpay);
			pst.setInt(5,rid);
			pst.setInt(6,ppid);
		    pst.execute();
			
			pw.print("<h1>Buy Successfully!</h1>");
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			pw.print("Nothing to by first Add cart");
			
			
		}
		
		 try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/retailerproject?user=root&password=incapp");
				Statement st=con.createStatement();
				
				pw.print("<h1 align='center'>Order Details </h1>");	
			    pw.print("<center>");
				pw.print("<h3><table border='1'><tr><th>Order id</th><th> Product Name</th><th>Product Price</th><th>Product Qty.</th><th>Amount Payable</th><th>Retailer Id</th></tr>");
				
				ResultSet rs=st.executeQuery("Select * from productorder where rid='"+rid+"'");
			while(rs.next()) {
				
					pw.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td></tr>");
					  t=rs.getString(5);
				    long it=Long.parseLong(t);
				      ttotal+=it;
				
				}
				pw.print("<tr><td></td><td></td><td></td><td></td><td>Total ="+ttotal+"</td><td></td><td></td></tr>");
			
		
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
