package com.retailermaintain.webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EditInfo
 */
@WebServlet("/EditInfo")
public class EditInfo extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.print("<html><body  style=\"background-color:lightblue;\">");
		pw.print("<center><h3><p style=\"background:Yellow\" style=\"width: 100px\" style=\"font-size:30\"> <b><font size='25'> My E-Commerce Website </font> </b></p></h3></center>\r\n" + 
				"");

		HttpSession ss=request.getSession(false);
		if(ss!=null) {
		 ServletContext context=getServletContext();
			String name= (String) context.getAttribute("name");
			String rid=request.getParameter("id");
			int id=Integer.parseInt(rid);
			 String email=(String) ss.getAttribute("email");
				
			  pw.print("<hr><h1 align='center'>Welcome to Edit Profile</h1>");
			pw.print("<h3><font >Welcome Mr./Mrs. "+name+" </font></h3><h3 align='right'><a href='CartView'>View Cart</a>|<a href='Profile'>Profile</a>|<a href='HomeServlet'>Home</a></h3><hr>");
		
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/retailerproject?user=root&password=incapp");
				Statement st=con.createStatement();
			    ResultSet rs=st.executeQuery("select * from rdetail where rrid='"+id+"'");
			    rs.next();
			    pw.print("<h1 align='center'>Update Page</h1>");
			    pw.print("<h4 align='center'><form action=\"UpdateServlet\" >\r\n" + 
			    		"<input type='hidden' name='id' value='"+rs.getInt("rrid")+"'>\r\n"+
			    		"<input type=\"text\" name=\"name\" value='"+rs.getString("rname")+"'><br>\r\n" +
			    		"<input type=\"password\" name=\"password\" value='"+rs.getString("pass")+"'><br>\r\n" + 
			    		"<input type=\"email\" name=\"email\" value='"+rs.getString("remail")+"'><br>\r\n" + 
			    		"<input type=\"text\" name=\"add\" value='"+rs.getString("radd")+"'><br>\r\n" + 
			    		"<input type=\"text\" name=\"cont\" value='"+rs.getString("rcont")+"'><br>\r\n" + 
			    		"<input type=\"submit\" value=\"Update\" >\r\n" + 
			    		"</form></h4>");
			 
				
				
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			
			}
		}
		else
			pw.print("Login First.");
	
	}

}
