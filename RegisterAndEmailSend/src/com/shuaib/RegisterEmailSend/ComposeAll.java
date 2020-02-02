package com.shuaib.RegisterEmailSend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ComposeAll
 */
@WebServlet("/ComposeAll")
public class ComposeAll extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.print("Welcome to Email Send");
		String yop=request.getParameter("yop");
		
		
	
	pw.print("<center><fieldset style=\"width:350px\"><form action=\"MaillAll\" method='post' ><pre>\r\n " + 
			"\r\n" + 
			"<pre>\r\n" + 
			"<h1><u>Send To All YOP:"+yop+"</u></h1><b>\r\n" +
			"  <input type='hidden' name='yop' value="+yop+"> <br>\r\n" +
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
