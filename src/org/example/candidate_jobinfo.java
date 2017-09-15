package org.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.example.Jobinfo;
public class candidate_jobinfo extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	         throws ServletException, IOException {

		 HttpSession session = req.getSession();
		 String candidate_id = (String) session.getAttribute("candidate_id");
		 	
	
	try {
		String filepath1 = "G:/Eclipse_Workspace/515_final/data/jobdataset.xml";
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		org.w3c.dom.Document doc = docBuilder.parse(filepath1);

		NodeList list = doc.getElementsByTagName("Job");

		System.out.println("Total of elements stored are : " + list.getLength());
	
		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
	      
		 out.println("<html><head><style>table {"+
    "font-family: arial, sans-serif;"+
    "border-collapse: collapse;"+
    "width: 100%;"+
"}"+

"td, th {"+
    "border: 1px solid #dddddd;"+
    "text-align: left;"+
    "padding: 8px;"+
"}"+

"tr:nth-child(even) {"+
    "background-color: #dddddd;"+
"}"+
"</style>"+
"</head><body>");
		 out.println("<h3> <u>Current Openings</u></h3>"+
"<table><tr><th>Job Id</th><th>Title</th><th>Skills</th><th>Category</th><th>Type</th></tr>");

		System.out.println("----------------------------");

		for (int temp = 0; temp < list.getLength(); temp++) {
             
			Node nNode = list.item(temp);

			//System.out.println("\nCurrent Element :" + nNode.getNodeName());

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;
				Jobinfo ji = new Jobinfo();
				ji.setCategory(eElement.getElementsByTagName("Category").item(0).getTextContent());
				ji.setTitle(eElement.getElementsByTagName("Title").item(0).getTextContent());
				ji.setPositions(Integer.parseInt(eElement.getElementsByTagName("Positions").item(0).getTextContent()));
				ji.setPreference(eElement.getElementsByTagName("Preference").item(0).getTextContent());
				ji.setCategory(eElement.getElementsByTagName("Category").item(0).getTextContent());
				ji.setType(eElement.getElementsByTagName("Type").item(0).getTextContent());
				ji.setSkills(eElement.getElementsByTagName("Skills").item(0).getTextContent());
			    out.println("<tr>");
			    out.println("<td>"+eElement.getAttribute("id")+"</td>");
			    out.println("<td>" +eElement.getElementsByTagName("Title").item(0).getTextContent()+ "</td>" );
			    out.println("<td>" +eElement.getElementsByTagName("Skills").item(0).getTextContent()+ "</td>" );
			    out.println("<td>" +eElement.getElementsByTagName("Category").item(0).getTextContent()+ "</td>" );
			    out.println("<td>" +eElement.getElementsByTagName("Type").item(0).getTextContent()+ "</td>" );
			  System.out.println("The value of job id in candidate info i " + eElement.getAttribute("id"));
			 
				
				
/*
				System.out.println("Candidate id : " + eElement.getAttribute("id"));
				System.out.println("Candidate Name : " + eElement.getElementsByTagName("Name").item(0).getTextContent());
				System.out.println("Email_id: " + eElement.getElementsByTagName("Email").item(0).getTextContent());
				System.out.println("Skills : " + eElement.getElementsByTagName("Experience").item(0).getTextContent());
				System.out.println("Preference : " + eElement.getElementsByTagName("Preference").item(0).getTextContent());
*/
			}
		}
		out.println("</tr><table><body><html>");
		out.println("<html><body><br> <br><form action = 'apply' method = 'get'>"
				+ " <pre>Please enter the job Id you wish to apply:     <input type= 'text' name = 'jobid'></pre> <br> <br><input type = 'submit'></form></body></html>");
		
	

	} catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	} catch (IOException ioe) {
		ioe.printStackTrace();
	} catch (org.xml.sax.SAXException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
	//HttpSession session1 = req.getSession();
	//req.setAttribute("job_id",candidate_id);
	}
}
