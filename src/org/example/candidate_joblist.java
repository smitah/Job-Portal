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

public class candidate_joblist extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	         throws ServletException, IOException {
		String a = req.getParameter("candidate");
	
	HttpSession session = req.getSession();
	 String candidate_id = (String) session.getAttribute("candidate_id"); 
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
	
	try {
		String filepath1 = "G:/Eclipse_Workspace/515_final/data/jobdataset.xml";
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		org.w3c.dom.Document doc = docBuilder.parse(filepath1);
       boolean flag = false;
		NodeList list = doc.getElementsByTagName("Job");
		
		 out.println("<table><tr><th>Job Title</th><th> Current Status</th></tr> ");
			
		for (int temp = 0; temp < list.getLength(); temp++) {

			Node nNode = list.item(temp);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;
				
				 if((eElement.getElementsByTagName("Candidate").item(0).getTextContent()).equals(candidate_id))
					{
					
						 
						 out.println("<tr><td>" +eElement.getElementsByTagName("Title").item(0).getTextContent()+ "</td> <td> Pending </td></tr>" );
						 
						
					}
				}
					
				}
		out.println("</table></body></html>");								
			}
			
		 catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (org.xml.sax.SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	session.invalidate();
	}		
	 public void doPost(HttpServletRequest request,
             HttpServletResponse response)
throws ServletException, IOException {
doGet(request, response);
}
	
}
