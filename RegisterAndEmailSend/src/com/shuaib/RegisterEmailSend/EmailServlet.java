package com.shuaib.RegisterEmailSend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmailServlet
 */
@WebServlet("/EmailServlet")
public class EmailServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.print("Welcome to Email Send");
		String email=request.getParameter("id");
		
		
	
	pw.print("<center><fieldset style=\"width:350px\"><form action=\"Send\" method='post' ><pre>\r\n " + 
			"\r\n" + 
			"<pre>\r\n" + 
			"<h1><u>Compose</u></h1><b>\r\n" +
			"<input type='hidden' name='email' value='"+email+"'>\r\n"+
			"To:       <label>"+email+"</label><br><br>\r\n" + 
			"Subject:  <input type=\"text\" name=\"sub\"  required=\"required\"><br><br>\r\n" +
			"Text:     <input type=\"text\" name=\"text\"  required=\"required\"><br><br>\r\n" +
			"<input  type=\"submit\" value=\"Send\">" + 
			"</b></pre>\r\n" + 
			"\r\n" + 
			"</form>\r\n" + 
			"</fieldset>\r\n" + 
			"</center>");
		
		
	
	}

}
