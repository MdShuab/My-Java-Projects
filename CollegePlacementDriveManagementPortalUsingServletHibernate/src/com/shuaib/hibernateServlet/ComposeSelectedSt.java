package com.shuaib.hibernateServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ComposeSelectedSt
 */
@WebServlet("/ComposeSelectedSt")
public class ComposeSelectedSt extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.print("Welcome to Compose Email..");
		String[] sid=request.getParameterValues("cemail");
		int i=0;
		for (String string : sid) {
			
			StringArr.Sarr[i++]=string;
			System.out.println(string);
		}
		
		pw.print("<center><h2><fieldset style=\"width:350px\"><form action=\"SendSelected\" method='get' ><pre>\r\n " + 
			"\r\n" + 
			"<h1>Compose Mail To Selected Student</h1><pre>\r\n" + 
			
			//"  <input type='hidden' name='cemail' value="+sid+"> <br>\r\n" +
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
