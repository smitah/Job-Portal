package org.example;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.w3c.dom.Node;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;

//import com.sun.java.util.jar.pack.Attribute.Layout.Element;
//import com.sun.xml.internal.txw2.Document;

//import jdk.internal.org.xml.sax.SAXException;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class jobData {
	public void data(Jobinfo jd) throws IOException, org.xml.sax.SAXException
	{
		String title = jd.getTitle();
		String skills = jd.getSkills();
		String category = jd.getCategory();
		String positions = Integer.toString(jd.getPositions());
		String preference   = jd.getPreference();
		String type  = jd.getType();
		String manager = jd.getManager_id();
		System.out.println("The manager id for the jobis " + manager);
	
	String filepath ="G:/Eclipse_Workspace/515_final/data/jobdataset.xml";
	File f = new File(filepath);
	try{
if(!f.exists())	
{
DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

// root elements
org.w3c.dom.Document doc = docBuilder.newDocument();
Element rootElement = doc.createElement("Jobdataset");
doc.appendChild(rootElement);

// staff elements
Element Job = doc.createElement("Job");
rootElement.appendChild(Job);

// set attribute to staff element
Attr attr = doc.createAttribute("id");
attr.setValue("1");
Job.setAttributeNode(attr);

// shorten way
// staff.setAttribute("id", "1");

// Name elements
Element Title = doc.createElement("Title");
Title.appendChild(doc.createTextNode(title));
Job.appendChild(Title);

// Email elements
Element Skills = doc.createElement("Skills");
Skills.appendChild(doc.createTextNode(skills));
Job.appendChild(Skills);

// Password elements
Element Category = doc.createElement("Category");
Category.appendChild(doc.createTextNode(category));
Job.appendChild(Category);

// Skills elements
Element Preference = doc.createElement("Preference");
Preference.appendChild(doc.createTextNode(preference));
Job.appendChild(Preference);

// Experience elements
	Element Type = doc.createElement("Type");
	Type.appendChild(doc.createTextNode(type));
	Job.appendChild(Type);
	
// Preference elements
	Element Positions = doc.createElement("Positions");
	Positions.appendChild(doc.createTextNode(positions));
	Job.appendChild(Positions);
	
// Manager elements
		Element Manager = doc.createElement("Manager");
		Manager.appendChild(doc.createTextNode(manager));
		Job.appendChild(Manager);
		
// Candidate elements
		Element Candidate = doc.createElement("Candidate");
		Candidate.appendChild(doc.createTextNode(" "));
		Job.appendChild(Candidate);
		

// write the content into xml file
TransformerFactory transformerFactory = TransformerFactory.newInstance();
Transformer transformer = transformerFactory.newTransformer();
DOMSource source = new DOMSource(doc);



StreamResult result = new StreamResult(f);

// Output to console for testing
// StreamResult result = new StreamResult(System.out);

transformer.transform(source, result);

System.out.println("New Job File Created!");
} 
else
{
	DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();
	org.w3c.dom.Document doc=documentBuilder.parse(filepath);
	NodeList list = doc.getElementsByTagName("Job");
	int a  = list.getLength();
	Element rootElement=doc.getDocumentElement();
	// staff elements
	Element Job = doc.createElement("Job");
	rootElement.appendChild(Job);
	
	a=a+1;
	 Attr attr =doc.createAttribute("id");
	 attr.setValue(Integer.toString(a));
	 Job.setAttributeNode(attr);
	 Element Title = doc.createElement("Title");
	 Title.appendChild(doc.createTextNode(title));
	 Job.appendChild(Title);

	 // Email elements
	 Element Skills = doc.createElement("Skills");
	 Skills.appendChild(doc.createTextNode(skills));
	 Job.appendChild(Skills);

	 // Password elements
	 Element Category = doc.createElement("Category");
	 Category.appendChild(doc.createTextNode(category));
	 Job.appendChild(Category);

	 // Skills elements
	 Element Preference = doc.createElement("Preference");
	 Preference.appendChild(doc.createTextNode(preference));
	 Job.appendChild(Preference);

	 // Experience elements
	 	Element Type = doc.createElement("Type");
	 	Type.appendChild(doc.createTextNode(type));
	 	Job.appendChild(Type);
	 	
	 // Preference elements
	 	Element Positions = doc.createElement("Positions");
	 	Positions.appendChild(doc.createTextNode(positions));
	 	Job.appendChild(Positions);
	 	
	 // Manager elements
	 		Element Manager = doc.createElement("Manager");
	 		Manager.appendChild(doc.createTextNode(manager));
	 		Job.appendChild(Manager);
	 	
	 		// Candidate elements
			Element Candidate = doc.createElement("Candidate");
			Candidate.appendChild(doc.createTextNode(" "));
			Job.appendChild(Candidate);	 		
	 		

	 // write the content into xml file
	 TransformerFactory transformerFactory = TransformerFactory.newInstance();
	 Transformer transformer = transformerFactory.newTransformer();
	 DOMSource source = new DOMSource(doc);
	
	 StreamResult result = new StreamResult(f);

	 // Output to console for testing
	 // StreamResult result = new StreamResult(System.out);

	 transformer.transform(source, result);

	 System.out.println("New Job added to the Jobset!");
	
}
} catch(ParserConfigurationException e) {
e.printStackTrace();
} catch(TransformerException t) {
t.printStackTrace();
}
try {
	String filepath1 = "G:/Eclipse_Workspace/515_final/data/jobdataset.xml";
	DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	org.w3c.dom.Document doc = docBuilder.parse(filepath1);

	NodeList list = doc.getElementsByTagName("Job");

	System.out.println("Total of jobs stored are : " + list.getLength());
	
	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

	

	System.out.println("----------------------------");

	for (int temp = 0; temp < list.getLength(); temp++) {

		Node nNode = list.item(temp);

		System.out.println("\nCurrent Job details :" + nNode.getNodeName());

		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;

			System.out.println("Job id : " + eElement.getAttribute("id"));
			System.out.println("Title : " + eElement.getElementsByTagName("Title").item(0).getTextContent());
			System.out.println("Skills: " + eElement.getElementsByTagName("Skills").item(0).getTextContent());
			System.out.println("Category : " + eElement.getElementsByTagName("Category").item(0).getTextContent());
			System.out.println("Preference : " + eElement.getElementsByTagName("Preference").item(0).getTextContent());
			System.out.println("Type : " + eElement.getElementsByTagName("Type").item(0).getTextContent());
			System.out.println("Positions : " + eElement.getElementsByTagName("Positions").item(0).getTextContent());
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
}
}


