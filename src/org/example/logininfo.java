package org.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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

public class logininfo extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	         throws ServletException, IOException {
		String username = req.getParameter("userid");
		String password = req.getParameter("psw");
		
		System.out.println("The password is " + password);
		
		try {
			String filepath1 = "G:/Eclipse_Workspace/515_final/data/allusersdata.xml";
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			org.w3c.dom.Document doc = docBuilder.parse(filepath1);
           boolean flag = false;
			NodeList list = doc.getElementsByTagName("User");

			System.out.println("Total of elements stored are : " + list.getLength());
		
			for (int temp = 0; temp < list.getLength(); temp++) {

				Node nNode = list.item(temp);

				//System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
										
					if((eElement.getElementsByTagName("Name").item(0).getTextContent()).equals(username))
					{   flag = true;
						System.out.println("The name is matching");
						if((eElement.getElementsByTagName("Password").item(0).getTextContent()).equals(password))
						{
							if((username).equals("Manager1")||(username).equals("Manager2")||(username).equals("Manager3")||(username).equals("Manager4")||(username).equals("Manager5"))
							{   
                                HttpSession session1 = req.getSession();
								
								session1.setAttribute("managername",username);
								req.setAttribute("managername", username);
								req.getRequestDispatcher("/Managerbasic.jsp").forward(req, resp);
								//RequestDispatcher rd=req.getRequestDispatcher("/managerPage.jsp");  
					            //rd.include(req, resp);
					            break;
							}
							else
							{
								String candidate_id = eElement.getAttribute("id");
								req.setAttribute("candidate", candidate_id );
								String candidate_name = eElement.getElementsByTagName("Name").item(0).getTextContent();
								
								HttpSession session = req.getSession();
								session.setAttribute("candidate_id",candidate_id);
								//request.setAttribute("name", "value");
								//request.getRequestDispatcher("page.jsp").forward(request, response);
							//System.out.println("The user is present");
							//RequestDispatcher rd=req.getRequestDispatcher("/candidate_jobinfo");  
				            //rd.include(req, resp);
							
							resp.sendRedirect("candidatePage.jsp");
				            break;
							}
						}
						
						else
						{
							System.out.println("Invalid credentials");
							resp.setContentType("text/html");

						      PrintWriter out = resp.getWriter();
						      String docType =
						      "<!doctype html public \"-//w3c//dtd html 4.0 " +
						      "transitional//en\">\n";
						      out.println(docType +
						                "<html>\n" +
						                "<head></head>\n" +
						                "<body bgcolor=\"#f0f0f0\">\n" + username +  
						                ", Incorrect password, please try again.\n "+ " <a href ='http://localhost:8080/515_final/'><button>Try again</button></a>"+
						               	"</body></html>");
						      break;
						}
						
					}
					
	
				}
			}
			if(flag == false)
			{
					resp.setContentType("text/html");

				      PrintWriter out = resp.getWriter();
				      String docType =
				      "<!doctype html public \"-//w3c//dtd html 4.0 " +
				      "transitional//en\">\n";
				      out.println(docType +
				                "<html>\n" +
				                "<head></head>\n" +
				                "<body bgcolor=\"#f0f0f0\">" +"Username: "+ username +  
				                "<p>Does not exist in database. Please signup \n "+ " <a href ='http://localhost:8080/515_final/'><button>Signup</button></a>" + 
				               	"</body></html>");
	
			}
			
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (org.xml.sax.SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
	// Method to handle POST method request.
	  public void doPost(HttpServletRequest request,
	                     HttpServletResponse response)
	      throws ServletException, IOException {
	     doGet(request, response);
	  }
}
