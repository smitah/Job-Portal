package org.example;

import javax.servlet.http.HttpServlet;
import org.example.registration;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.example.Jobinfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
public class mainJob extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	         throws ServletException, IOException {
		 HttpSession session1 = req.getSession();
		 String manager1 = (String) session1.getAttribute("managername");
		session1.invalidate();
		 //String manager1  = req.getParameter("name");
		 
		 String manager = manager1.replaceAll("\\s+","");
		 String manager_id = "";
		
		  try {
				String filepath1 = "G:/Eclipse_Workspace/515_final/data/allusersdata.xml";
				DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
				org.w3c.dom.Document doc = docBuilder.parse(filepath1);

				NodeList list = doc.getElementsByTagName("User");

				for (int temp = 0; temp < list.getLength(); temp++) {

					Node nNode = list.item(temp);

					//System.out.println("\nCurrent Element :" + nNode.getNodeName());

					if (nNode.getNodeType() == Node.ELEMENT_NODE) {

						Element eElement = (Element) nNode;
						System.out.println("The outer if loop");
						System.out.println("The name of maner is" + eElement.getElementsByTagName("Name").item(0).getTextContent());
						
						if((eElement.getElementsByTagName("Name").item(0).getTextContent()).contains(manager))
						{   
							manager_id = eElement.getAttribute("id");
							break;
						}
		
					}
				}

			} catch (ParserConfigurationException pce) {
				pce.printStackTrace();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			} catch (org.xml.sax.SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		
		
		 Jobinfo job = new Jobinfo();
        job.setTitle(req.getParameter("JobTitle"));
        job.setSkills(req.getParameter("skills"));
        job.setCategory(req.getParameter("category"));
        job.setType(req.getParameter("preference"));
        job.setPreference(req.getParameter("experience"));
        job.setPositions(Integer.parseInt(req.getParameter("positions")));
        job.setManager_id(manager_id);
       
        //System.out.println(req.getParameter("category") + req.getParameter("JobTitle"));
        //String managername = req
        
        
        jobData jd = new jobData();
        try {
			jd.data(job);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     // Set response content type
		   resp.setContentType("text/html");

	      PrintWriter out = resp.getWriter();
	      
		  
	      String docType =
	      "<!doctype html public \"-//w3c//dtd html 4.0 " +
	      "transitional//en\">\n";
	      out.println(docType +
	                "<html>\n" +
	                "<head><title>"+"</title></head>\n" +
	                "<body bgcolor=\"#f0f0f0\">\n" +
	                "<p><b>Thankyou for using the job portal. Your job is successfully posted.</b></p>"+
	                "</body></html>");
	}
}
