package com.shuaib.hibernateServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class BatchReg
 */
@WebServlet("/BatchReg")
public class BatchReg extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String bname=request.getParameter("bname");
		String fname=request.getParameter("fname");
		
		
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session ss=sf.openSession();
		
		BatchDTO bdto=new BatchDTO();
		bdto.setBname(bname);
		bdto.setBfname(fname);
		ss.save(bdto);
		ss.beginTransaction().commit();
		pw.print("Batch Created SuccessFully!");
		request.getRequestDispatcher("StudendReg").include(request, response);
	}

}
