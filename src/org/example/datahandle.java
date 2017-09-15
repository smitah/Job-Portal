package org.example;
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

public class datahandle {
	
	public void data(registration reg) throws IOException, org.xml.sax.SAXException
	{
	String name = reg.getName();
	String email = reg.getEmail();
	String skills = reg.getSkills();
	String password = reg.getPassword();
	String experience  = reg.getExperience();
	String preference  = reg.getPreference();
	  
    
    	
    	String filepath ="G:/Eclipse_Workspace/515_final/data/filedata1.xml";
		File f = new File(filepath);
		try{
	if(!f.exists())	
	{
	DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

	// root elements
	org.w3c.dom.Document doc = docBuilder.newDocument();
	Element rootElement = doc.createElement("Users");
	doc.appendChild(rootElement);

	// staff elements
	Element candidate = doc.createElement("Candidate");
	rootElement.appendChild(candidate);

	// set attribute to staff element
	Attr attr = doc.createAttribute("id");
	attr.setValue("1");
	candidate.setAttributeNode(attr);

	// shorten way
	// staff.setAttribute("id", "1");

	// Name elements
	Element name1 = doc.createElement("Name");
	name1.appendChild(doc.createTextNode(name));
	candidate.appendChild(name1);

	// Email elements
	Element email1 = doc.createElement("Email");
	email1.appendChild(doc.createTextNode(email));
	candidate.appendChild(email1);

	// Password elements
	Element password1 = doc.createElement("Password");
	password1.appendChild(doc.createTextNode(password));
	candidate.appendChild(password1);

	// Skills elements
	Element skills1 = doc.createElement("Skills");
	skills1.appendChild(doc.createTextNode(skills));
	candidate.appendChild(skills1);
	
	// Experience elements
		Element experience1 = doc.createElement("Experience");
		experience1.appendChild(doc.createTextNode(experience));
		candidate.appendChild(experience1);
		
	// Preference elements
		Element preference1 = doc.createElement("Preference");
		preference1.appendChild(doc.createTextNode(preference));
		candidate.appendChild(preference1);
			

	// write the content into xml file
	TransformerFactory transformerFactory = TransformerFactory.newInstance();
	Transformer transformer = transformerFactory.newTransformer();
	DOMSource source = new DOMSource(doc);
	String filename  = "./data/filedata1.xml";
	
	
	StreamResult result = new StreamResult(f);

	// Output to console for testing
	// StreamResult result = new StreamResult(System.out);

	transformer.transform(source, result);

	System.out.println("New File Created!");
	} 
	else
	{
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();
		org.w3c.dom.Document doc=documentBuilder.parse(filepath);
		NodeList list = doc.getElementsByTagName("Candidate");
		int a  = list.getLength();
		Element rootElement=doc.getDocumentElement();
		// staff elements
		Element candidate = doc.createElement("Candidate");
		rootElement.appendChild(candidate);
		
		a=a+1;
		 Attr attr =doc.createAttribute("id");
		 attr.setValue(Integer.toString(a));
		 candidate.setAttributeNode(attr);
		 Element name1 = doc.createElement("Name");
			name1.appendChild(doc.createTextNode(name));
			candidate.appendChild(name1);

			// Email elements
			Element email1 = doc.createElement("Email");
			email1.appendChild(doc.createTextNode(email));
			candidate.appendChild(email1);

			// Password elements
			Element password1 = doc.createElement("Password");
			password1.appendChild(doc.createTextNode(password));
			candidate.appendChild(password1);

			// Skills elements
			Element skills1 = doc.createElement("Skills");
			skills1.appendChild(doc.createTextNode(skills));
			candidate.appendChild(skills1);
			
			// Experience elements
				Element experience1 = doc.createElement("Experience");
				experience1.appendChild(doc.createTextNode(experience));
				candidate.appendChild(experience1);
				
			// Preference elements
				Element preference1 = doc.createElement("Preference");
				preference1.appendChild(doc.createTextNode(preference));
				candidate.appendChild(preference1);
				// write the content into xml file
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				//String filename  = "G:/Eclipse_Workspace/515_final/data/filedata1.xml";
				
				
				StreamResult result = new StreamResult(f);

				// Output to console for testing
				// StreamResult result = new StreamResult(System.out);

				transformer.transform(source, result);
				
				System.out.println("The file is updated with new record!");
		
	}
 } catch(ParserConfigurationException e) {
	e.printStackTrace();
 } catch(TransformerException t) {
	t.printStackTrace();
 }
		
		try{
			String filepath1 ="G:/Eclipse_Workspace/515_final/data/allusersdata.xml";
			File f1 = new File(filepath1);
			if(f1.exists())
			{

				DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();
				org.w3c.dom.Document doc=documentBuilder.parse(filepath1);
				NodeList list = doc.getElementsByTagName("User");
				int a  = list.getLength();
				Element rootElement=doc.getDocumentElement();
				// staff elements
				Element User = doc.createElement("User");
				rootElement.appendChild(User);
				
				a=a+1;
				 Attr attr =doc.createAttribute("id");
				 attr.setValue(Integer.toString(a));
				 User.setAttributeNode(attr);
				 Element name1 = doc.createElement("Name");
					name1.appendChild(doc.createTextNode(name));
					User.appendChild(name1);

					// Password elements
					Element Password = doc.createElement("Password");
					Password.appendChild(doc.createTextNode(password));
					User.appendChild(Password);
		
						// write the content into xml file
						TransformerFactory transformerFactory = TransformerFactory.newInstance();
						Transformer transformer = transformerFactory.newTransformer();
						DOMSource source = new DOMSource(doc);
						//String filename  = "G:/Eclipse_Workspace/515_final/data/filedata1.xml";
						
						
						StreamResult result = new StreamResult(f1);

						// Output to console for testing
						// StreamResult result = new StreamResult(System.out);

						transformer.transform(source, result);
						
						System.out.println("The user login information is updated!");
				
			}
		}catch(ParserConfigurationException e) {
			e.printStackTrace();
		 } catch(TransformerException t) {
			t.printStackTrace();
		 }

    try {
		String filepath1 = "G:/Eclipse_Workspace/515_final/data/filedata1.xml";
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		org.w3c.dom.Document doc = docBuilder.parse(filepath1);

		NodeList list = doc.getElementsByTagName("Candidate");

		System.out.println("Total of elements stored are : " + list.getLength());
	
		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

		

		System.out.println("----------------------------");

		for (int temp = 0; temp < list.getLength(); temp++) {

			Node nNode = list.item(temp);

			//System.out.println("\nCurrent Element :" + nNode.getNodeName());

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;
/*
				System.out.println("Candidate id : " + eElement.getAttribute("id"));
				System.out.println("Candidate Name : " + eElement.getElementsByTagName("Name").item(0).getTextContent());
				System.out.println("Email_id: " + eElement.getElementsByTagName("Email").item(0).getTextContent());
				System.out.println("Skills : " + eElement.getElementsByTagName("Experience").item(0).getTextContent());
				System.out.println("Preference : " + eElement.getElementsByTagName("Preference").item(0).getTextContent());
*/
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
