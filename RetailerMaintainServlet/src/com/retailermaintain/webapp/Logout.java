package com.retailermaintain.webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.print("<html><body  style=\"background-color:lightblue;\">");
		pw.print("<center><h3><p style=\"background:Yellow\" style=\"width: 100px\" style=\"font-size:30\"> <b> <font size='25'> My E-Commerce Website </font> </b></p></h3></center>\r\n" + 
				"");

		HttpSession ss=request.getSession(false);
		 if(ss!=null)
	      {
		 String email=(String) ss.getAttribute("email");
		 ServletContext context=getServletContext();
		String name= (String) context.getAttribute("name");
		pw.print("<hr><h3 align='right'><a href='OrderDetail'>View My Order</a>|<a href='CartView'>View Cart</a>|<a href='Profile'>Profile</a>|<a href='HomeServlet'>Home</a></h3><hr>");
	
		
		     context.setAttribute("name", "");
	    	  pw.print("<h1 align='center' >LogOut Successful "+name+"</h1>");
	    	  ss.invalidate();
	    	  request.getRequestDispatcher("Login.html").include(request, response);
	    
	      }
		 else {
	    	 pw.print("<h1 align='center'>Login First</h1>");
	    	 pw.print("<h3 align='right'><a href='OrderDetail'>View My Order</a>|<a href='CartView'>View Cart</a>|<a href='Profile'>Profile</a>|<a href='HomeServlet'>Home</a>|<a href='Logout'>Logout</a></h3><hr>");
				 pw.print("<hr>");
	    	  request.getRequestDispatcher("Login.html").include(request, response);
	    
	     }
	
	
	}

}
