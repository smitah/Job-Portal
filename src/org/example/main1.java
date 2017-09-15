package org.example;
import org.example.registration;
import org.xml.sax.SAXException;
import org.example.datahandle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class main1 extends HttpServlet {
  
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	         throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String skills = req.getParameter("skills");
		String preference = req.getParameter("preference");
		String experience = req.getParameter("experience");
		// Set response content type
		   resp.setContentType("text/html");

	      PrintWriter out = resp.getWriter();
	      /*
		  String title = "The Registration information is :";
	      String docType =
	      "<!doctype html public \"-//w3c//dtd html 4.0 " +
	      "transitional//en\">\n";
	      out.println(docType +
	                "<html>\n" +
	                "<head><title>" + title + "</title></head>\n" +
	                "<body bgcolor=\"#f0f0f0\">\n" +
	                "<h1 align=\"center\">" + title + "</h1>\n" +
	                "<ul>\n" +
	                "  <li><b>First Name</b>: "
	                + name + "\n" +
	                "  <li><b>Email</b>: "
	                + email + "\n" +
	                "  <li><b>password</b>: "
	                + password + "\n" +
	                "  <li><b>Skills</b>: "
	                + skills + "\n" +
	                "  <li><b>Experience</b>: "
	                + experience + "\n" +
	                "  <li><b>Job Preference</b>: "
	                + preference + "\n" +
	                "</ul>\n" +
	                "</body></html>");
		resp.getWriter().println(new Date());*/
		String temp = null;       
         registration reg = new registration();
         reg.setName(req.getParameter("name"));
         reg.setEmail(req.getParameter("email"));
         reg.setPassword(req.getParameter("password"));
         reg.setSkills(req.getParameter("skills"));
         reg.setExperience(req.getParameter("experience"));
         reg.setPreference(req.getParameter("preference"));
         datahandle dh = new datahandle();
         try {
			dh.data(reg);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        
      		RequestDispatcher rd=req.getRequestDispatcher("/candidatePage.jsp");  
            rd.include(req, resp);
      	 
	}
	public void doPost(HttpServletRequest req,
            HttpServletResponse resp)
throws ServletException, IOException {
doGet(req, resp);
}
       
	}

