package org.example;
import org.example.Jobinfo;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class apply extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	         throws ServletException, IOException {
		
		String job_id = req.getParameter("jobid");
		String [] jobids = job_id.split(",");
		
		String candidate = (String) req.getAttribute("candidate");
		//System.out.println("The job id which wwe got is " + jobids);
		HttpSession session = req.getSession();
		
		String candidate_id = (String) session.getAttribute("candidate_id");
		session.invalidate();
		//System.out.println("The candidate id in apply is " + candidate_id);
		
		try {
			String filepath1 = "G:/Eclipse_Workspace/515_final/data/jobdataset.xml";
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			org.w3c.dom.Document doc = docBuilder.parse(filepath1);
           boolean flag = false;
			NodeList list = doc.getElementsByTagName("Job");
			for (int temp = 0; temp < list.getLength(); temp++) {
				
				Node nNode = list.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					for (int i = 0;i<jobids.length;i++)
					{
						System.out.println("The jobs to which candidate has applied to is " +jobids[i]);
						
						
					
									
					if(eElement.getAttribute("id").equals(jobids[i]))
						
					{ 
		                 eElement.getElementsByTagName("Candidate").item(0).setTextContent(candidate_id);
						 System.out.println("The title of job is " + eElement.getElementsByTagName("Title").item(0).getTextContent());
					}
					}								
				}
				
			} 
			
			 // write the content into xml file
			 TransformerFactory transformerFactory = TransformerFactory.newInstance();
			 Transformer transformer = transformerFactory.newTransformer();
			 DOMSource source = new DOMSource(doc);
			
			 StreamResult result = new StreamResult(filepath1);

			 // Output to console for testing
			 // StreamResult result = new StreamResult(System.out);

			 transformer.transform(source, result);
		
		}catch (ParserConfigurationException pce) {
				pce.printStackTrace();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			} catch (org.xml.sax.SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformerConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		resp.setContentType("text/html");
        
	      PrintWriter out = resp.getWriter();
	      String docType =
	      "<!doctype html public \"-//w3c//dtd html 4.0 " +
	      "transitional//en\">\n";
	      out.println(docType +
	                "<html>\n" +
	                "<head></head>\n" +
	                "<body bgcolor=\"#f0f0f0\">\n" + 
	                "You are successfully Logged out of the system. <p>Thank you for applying\n </p>"+ " <br> <br> <br><a href ='http://localhost:8080/515_final/'><button>Sign again</button></a>"+
	               	"</body></html>");
		
	}

}
