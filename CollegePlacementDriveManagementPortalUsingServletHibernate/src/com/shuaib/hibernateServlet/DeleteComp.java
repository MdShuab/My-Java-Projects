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
 * Servlet implementation class DeleteComp
 */
@WebServlet("/DeleteComp")
public class DeleteComp extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String scid=request.getParameter("cid");
		int cid=Integer.parseInt(scid);
		
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session ss=sf.openSession();
	
		CompanyDTO cdto=ss.load(CompanyDTO.class, cid);
		ss.delete(cdto);
		ss.beginTransaction().commit();
		response.sendRedirect("FetchCompany");
	
	}

}
