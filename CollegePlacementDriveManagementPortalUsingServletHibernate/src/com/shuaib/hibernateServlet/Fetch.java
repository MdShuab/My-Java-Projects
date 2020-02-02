package com.shuaib.hibernateServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class Fetch
 */
@WebServlet("/Fetch")
public class Fetch extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		pw.print("<body style=\"background-color:pink\">");
		String bname=request.getParameter("bname");
		int bid=0;
		String fname=null;
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session ss=sf.openSession();

		Query qry=ss.createQuery("from BatchDTO where bname='"+bname+"'");
		List<BatchDTO>list=qry.list();
		for(BatchDTO dto:list) {
			
			bid=dto.getBid();
			fname=dto.getBfname();
		}
		Query qry1=ss.createQuery("from StudentDTO where slist_bid='"+bid+"'");
	       List<StudentDTO>slist=qry1.list();
	       pw.print("<center><h1><u>Student Details</u></h1></center>");
	       pw.print("<h3><center><table border='1'><tr><th>ID</th><th>Name</th><th>Age</th><th>Address</th><th>Branch</th><th>Percentage</th><th>YOP</th><th>Email</th><th>Batch Name</th><th>Faculty Name</th></tr>");
	       for(StudentDTO sdto:slist) {   
	    	   pw.print("<tr><td>"+sdto.getSid()+"</td><td>"+sdto.getSname()+"</td><td>"+sdto.getSage()+"</td><td>"+sdto.getSadd()+"</td><td>"+sdto.getBranch()+"</td><td>"+sdto.getPtage()+"</td><td>"+sdto.getYop()+"</td><td>"+sdto.getSemail()+"</td><td>"+bname+"</td><td>"+fname+"</td></tr>");    	   
	       }
	       pw.print("</table>");
	       pw.print("To Add New Student: <a href='StudendReg'>"+"Click"+"<a><br>Click To Go<a href='Filter'> Back<a>|<a href='index.html'>Home<a></center></h3>");
		   
	       

	
	}

}
