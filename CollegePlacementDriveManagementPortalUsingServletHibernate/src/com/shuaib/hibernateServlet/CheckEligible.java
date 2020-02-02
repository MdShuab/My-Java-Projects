package com.shuaib.hibernateServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 * Servlet implementation class CheckEligible
 */
@WebServlet("/CheckEligible")
public class CheckEligible extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String scid=request.getParameter("sid");
		int cid=Integer.parseInt(scid);
		
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session ss=sf.openSession();
		
		CompanyDTO cdto=ss.load(CompanyDTO.class, cid);
		Criteria cr=ss.createCriteria(StudentDTO.class);
		cr.add(Restrictions.ilike("branch", cdto.getBranch()));
		cr.add(Restrictions.ge("ptage", cdto.getPtcr()));
		cr.add(Restrictions.ilike("yop", cdto.getYop()));
		List<StudentDTO>slist=cr.list();
	  	int flag=0,i=0,j=0;
	  	pw.print("<body style=\"background-color:#2E8B57\">");
	  	pw.print("<br><br><center><h1>==========Eligible Students==========</h1></center>");
	  	pw.print("<center><div ><form action='ComposeSelectedSt'>");
		 pw.print("<h3><center><table border='1'><tr><th>ID</th><th>Name</th><th>Age</th><th>Address</th><th>Branch</th><th>Percentage</th><th>YOP</th><th>Email</th><th>Send Email</th><th>Select</th></tr>");
		
		for (StudentDTO sdto : slist) {
		
		//	if((sdto.getBranch().equalsIgnoreCase(st.nextToken()))&&(sdto.getPtage()>=cdto.getPtcr())&&(sdto.getYop().equalsIgnoreCase(cdto.getYop()))) {
				  pw.print("<tr><td><center>"+sdto.getSid()+"</center></td><td><center>"+sdto.getSname()+"</center></td>"
				  		+ "<td><center>"+sdto.getSage()+"</center></td><td><center>"+sdto.getSadd()+"</center></td>"
				  				+ "<td><center>"+sdto.getBranch()+"</center></td><td><center>"+sdto.getPtage()+"</center></td>"
				  						+ "<td><center>"+sdto.getYop()+"</center></td><td><center>"+sdto.getSemail()+"</center></td>"
				  								+ "<td><center><a href='ComposeMail?sid="+sdto.getSid()+"'>Send</a></center>"
				  								+ "<td><center><input type='checkbox' name='cemail' value="+sdto.getSemail()+"></center></td></tr>");
					StringArr.arr[i++]=sdto.getSemail();
				flag++;
		}
		
		 pw.print("</table>");
		 if(flag!=0) {
			  pw.print("<center><br><h3><input type='submit' value='Send Mail To Selected Student'></h3></form>"
			  		+ "<h3><a href='ComposeAll'>Send To All Mail</a>||<a href='index.html'> Go To Home</a></h3></div></center>");	
			   
		 }
		 if(flag==0) {
			 pw.print("<h3>Does'nt Exist Eligible Student.</h3>");
		 }
		  pw.print("</body>");
	
	}

}
