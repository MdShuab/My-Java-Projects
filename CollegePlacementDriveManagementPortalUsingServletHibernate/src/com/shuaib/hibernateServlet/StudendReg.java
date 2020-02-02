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
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class StudendReg
 */
@WebServlet("/StudendReg")
public class StudendReg extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		pw.print("<body style=\"background-color:pink\">");

		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session ss=sf.openSession();
		

		
		
		Criteria cr=ss.createCriteria(BatchDTO.class);
		List<BatchDTO>  list= cr.list();
		
		pw.print("<center>\r\n" + 
				"<fieldset style=\"width:350px\">\r\n" + 
				"<form action=\"StRegServlet\"   >\r\n" + 
				"<pre>");

		pw.print("<h1>\r\n" + 
				
				" <label >Batch Name:</label> <select name=\"bname\" id=\"\">\r\n" + 
				"    <option value=\"\" selected disabled>Select</option>"); 
		for(BatchDTO dto:list) {  pw.print("<option value="+dto.getBname()+">"+dto.getBname()+"</option>");}
				pw.print("</select> </h1>"); 
			
		
				pw.print("<h1>Student Details</h1><h3>\r\n" + 
				"Name:        <input type=\"text\" name=\"name\"  required=\"required\"><br>\r\n" + 
				"Address:     <input type=\"text\" name=\"Address\"  required=\"required\"><br>\r\n" + 
				"Age:         <input type=\"number\" name=\"age\"  required=\"required\"><br>\r\n" + 
				"Percentage:  <input type=\"number\" name=\"ptage\"  required=\"required\"><br>\r\n" +
				"Branch:      <input type=\"text\" name=\"branch\"  required=\"required\"><br>\r\n" + 
				"YOP:         <input type=\"text\" name=\"yop\"  required=\"required\"><br>\r\n" + 
				"Email:       <input type=\"email\" name=\"email\"  required=\"required\"><br>\r\n" + 
				"<input  type=\"submit\" value=\"Register\">\r\n" + 
				"</h3></pre>\r\n" + 
				"</form>\r\n" + 
				"</fieldset>\r\n" + 
				"</center>");
     pw.print("<h3><center>To Add New Student: <a href='StudendReg'>"+"Click"+"<a><br>Click To Go<a href='Filter'> Back<a>|<a href='index.html'>Home<a></center></h3>");
					 
	
	
	}

}
