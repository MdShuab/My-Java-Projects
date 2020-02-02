package com.shuaib.hibernateServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class Filter
 */
@WebServlet("/Filter")
public class Filter extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.print("<body style=\"background-color:pink\">");
		//pw.print("Hello");

		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session ss=sf.openSession();
		
		Criteria cr=ss.createCriteria(BatchDTO.class);
		List<BatchDTO>  list= cr.list();
		
		pw.print("<center>\r\n" + 
				"<fieldset style=\"width:350px\">\r\n" + 
				"<form action=\"Fetch\" >\r\n" + 
				"<pre>");

		pw.print("<h1>\r\n" + 
				
				" <label >Batch Name:</label> <select name=\"bname\" id=\"\">\r\n" + 
				"    <option value=\"\" selected disabled>Select</option>"); 
		for(BatchDTO dto:list) { 
			pw.print("<option value="+dto.getBname()+">"+dto.getBname()+"</option>");
			}
				pw.print("</select> </h1>"); 
			pw.print("<input  type=\"submit\" value=\"Fetch\"></pre>\r\n" + 
				"</form>\r\n" + 
				"</fieldset>\r\n" + 
				"</center>");
			  pw.print("<h3><center>To Add New Student: <a href='StudendReg'>"+"Click"+"<a><br>Click To Go<a href='Filter'> Back<a>|<a href='index.html'>Home<a></center></h3>");
				
		
	}

}
