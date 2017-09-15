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

public class previousjobs extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	         throws ServletException, IOException {
		HttpSession session3 = req.getSession();
		String candidate_name = (String) session3.getAttribute("candidate_name");
		HttpSession session1 = req.getSession();
		 String manager1 = (String) session1.getAttribute("managername");
		session1.invalidate();
		String manager = manager1.replaceAll("\\s+","");
		 String manager_id = "";
		 String candidate_id = "";
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
			 out.println("<table><tr><th>Job Title</th><th>Applicant_id</th></tr> ");
		
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
		
		
		try {
			String filepath1 = "G:/Eclipse_Workspace/515_final/data/jobdataset.xml";
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			org.w3c.dom.Document doc = docBuilder.parse(filepath1);

			NodeList list = doc.getElementsByTagName("Job");
			for (int temp = 0; temp < list.getLength(); temp++) {
	             
				Node nNode = list.item(temp);
			
				//System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					if(eElement.getElementsByTagName("Manager").item(0).getTextContent().equals(manager_id))
					{
						 out.println("<tr>");
						   
						    out.println("<td>" +eElement.getElementsByTagName("Title").item(0).getTextContent()+ "</td>" );
						    if(!eElement.getElementsByTagName("Candidate").item(0).getTextContent().contains(" "))
						    {
						    out.println("<td>" +eElement.getElementsByTagName("Candidate").item(0).getTextContent()+ "</td>" );
						    }
						    else
						    {
						    	out.println("<td>" + "No Applications recieved" + "</td>");
						    }
				           candidate_id = eElement.getElementsByTagName("Candidate").item(0).getTextContent();
				           System.out.println("The candidate id is " + candidate_id);
				           out.println("</tr>");
						
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
	System.out.println("The candidate id is " + candidate_id);
		
	
		out.println("</table></body></html>");	
		
		
		
	}
	
	
public void doPost(HttpServletRequest request,
             HttpServletResponse response)
throws ServletException, IOException {
doGet(request, response);
}
}
