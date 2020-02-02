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
 * Servlet implementation class CheckCriteria
 */
@WebServlet("/FetchCompany")
public class FetchCompany extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session ss=sf.openSession();
		
		int sid=0;
      
		
		Criteria cr=ss.createCriteria(CompanyDTO.class);
	       List<CompanyDTO>clist=cr.list();
	       pw.print("<br><br><br><center><h3>===========Upcoming Drive.===========</h3></center><br>");
	       pw.print("<h3><center><table border='1'><tr><th>Company Name</th><th>Percentage  Req.</th><th>Branch</th><th>Profile</th><th>YOP</th><th>No. of Vacancy</th><th>ADD Eligible Student</th><th>Dlete</th></tr>");
			
	       for(CompanyDTO cdto:clist) {
	    	 sid=cdto.getId();
	    	   pw.print("<tr><td><center>"+cdto.getCname()+"</center></td><td><center>"+cdto.getPtcr()+"</center></td><td><center>"+cdto.getBranch()+"</center></td><td><center>"+cdto.getProfile()+"</center></td><td>"+cdto.getYop()+"</td><td><center>"+cdto.getNv()+"</center></td><td><center><a href='CheckEligible?sid="+sid+"'>Add</a></center></td><td><a href='DeleteComp?cid="+cdto.getId()+"'>Delete</a></td></center></tr>");
			   
	    	   
	       }
	
	       pw.print("</table>");
	       pw.print("<center><a href='index.html'>Go To Home</a></center>");
	    //  pw.print("<h2>Add To Check Eligible Student<a href='CheckEligible?id='"+sid+"'>Eligible</a></h2>");
	
	
	}

}
