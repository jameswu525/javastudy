package org.jimmy.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class CompileXML {

	String path = "";

	public CompileXML(String path) {
		this.path = path;
	}

	public HashMap<String, ServletElement> getServletsMap() {
		File xmlFile = new File(path);
		HashMap<String, ServletElement> hm = new HashMap<>();
		HashMap<String, String> h1 = new HashMap<>();
		HashMap<String, String> h2 = new HashMap<>();
		if (!xmlFile.exists()) {
			return hm;
		}
		// FileInputStream is = new FileInputStream(xmlFile);
		// StringBuilder sb = new StringBuilder();
		// byte[] b = new byte[1024];
		// int len = -1;
		// while ((len = is.read(b)) != -1) {
		// sb.append(new String(b, 0, len));
		// }
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse(xmlFile);
			NodeList nl = doc.getElementsByTagName("servlet");
			for (int i = 0; i < nl.getLength(); i++) {
				Node n = nl.item(i);
				String servletName = n.getFirstChild().getNextSibling().getFirstChild().getNodeValue();
				String servletClass = n.getFirstChild().getNextSibling().getNextSibling().getNextSibling()
						.getFirstChild().getNodeValue();
				h1.put(servletName, servletClass);
			}

			nl = doc.getElementsByTagName("servlet-mapping");
			for (int i = 0; i < nl.getLength(); i++) {
				Node n = nl.item(i);
				String servletName = n.getFirstChild().getNextSibling().getFirstChild().getNodeValue();
				String servletClass = n.getFirstChild().getNextSibling().getNextSibling().getNextSibling()
						.getFirstChild().getNodeValue();
				h2.put(servletName, servletClass);
			}
			
			for(String key : h1.keySet()) {
				ServletElement ele = new ServletElement();
				ele.servletName = key;
				ele.setServletClz(h1.get(key));
				ele.servletUrl = h2.get(key);
				hm.put(ele.servletUrl, ele);
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return hm;
	}
}
