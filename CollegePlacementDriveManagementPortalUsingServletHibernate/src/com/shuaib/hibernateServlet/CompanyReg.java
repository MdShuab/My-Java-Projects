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
 * Servlet implementation class CompanyReg
 */
@WebServlet("/CompanyReg")
public class CompanyReg extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.print("hii");
		String cname=request.getParameter("cname");
		String Branch=request.getParameter("Branch");
		String YOP=request.getParameter("YOP");
		String sPercentage=request.getParameter("Percentage");
		String Profile=request.getParameter("Profile");
		String snv=request.getParameter("nv");
		double ptcr=Double.parseDouble(sPercentage);
		int nv=Integer.parseInt(snv);
		
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session ss=sf.openSession();
		
		CompanyDTO cdto=new CompanyDTO();
		cdto.setCname(cname);
		cdto.setBranch(Branch);
		cdto.setYop(YOP);
		cdto.setPtcr(ptcr);
		cdto.setNv(nv);
		cdto.setProfile(Profile);
		ss.save(cdto);
		ss.beginTransaction().commit();
		
		request.getRequestDispatcher("FetchCompany").forward(request, response);
		
		ss.close();
		sf.close();
	
	}

}
