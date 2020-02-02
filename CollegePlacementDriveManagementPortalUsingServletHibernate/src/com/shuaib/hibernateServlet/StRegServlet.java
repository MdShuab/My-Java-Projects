package com.shuaib.hibernateServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class StRegServlet
 */
@WebServlet("/StRegServlet")
public class StRegServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.print("<body style=\"background-color:pink\">");
		String name=request.getParameter("name");
		String Address=request.getParameter("Address");
		String sage=request.getParameter("age");
		String sptage=request.getParameter("ptage");
		String branch=request.getParameter("branch");
		String yop=request.getParameter("yop");
		String semail=request.getParameter("email");
		String bname=request.getParameter("bname");
		double ptage=Double.parseDouble(sptage);
		int age=Integer.parseInt(sage);
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session ss=sf.openSession();
		RequestDispatcher rd;
		int bid=0;
		String fname=null;

		StudentDTO sdto=new StudentDTO();
		sdto.setSname(name);
		sdto.setSadd(Address);
		sdto.setSage(age);
		sdto.setBranch(branch);
		sdto.setPtage(ptage);
		sdto.setSemail(semail);
		sdto.setYop(yop);
		
		Query qry=ss.createQuery("from BatchDTO where bname='"+bname+"'");
		List<BatchDTO>list=qry.list();
		for(BatchDTO dto:list) {
			
			bid=dto.getBid();
			
			fname=dto.getBfname();
		}
	
       BatchDTO bdto=ss.load(BatchDTO.class, bid);
		List<StudentDTO> slist=bdto.getSlist();
		slist.add(sdto);
		bdto.setSlist(slist);
		ss.saveOrUpdate(bdto);
		ss.beginTransaction().commit();
		pw.print("Success");
		rd=request.getRequestDispatcher("Fetch");
		rd.forward(request, response);
	  
	   
	   ss.close();
	   sf.close();
	
	}

}
