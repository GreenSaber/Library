package com.epam.pars.dom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.epam.countries.Country;

public class CountryDOMParser {

	public static void main(String[] args) throws SAXException, IOException {
		DOMParser parser =new DOMParser();
		parser.parse("src\\countries.xml");
		Document document = parser.getDocument();
		Element root = document.getDocumentElement();
		List<Country> countries = new ArrayList<Country>();
			
			NodeList countryNodes = root.getElementsByTagName("country");
			Country country = null;
			for (int i = 0; i<countryNodes.getLength();i++){
				country=new Country();
				Element countryElement = (Element) countryNodes.item(i);
				country.setId(Integer.parseInt(countryElement.getAttribute("id")));
				country.setName(getSingleChild(countryElement,"name").getTextContent().trim());
				country.setCapital(getSingleChild(countryElement,"country").getTextContent().trim());
				country.setPopulation(getSingleChild(countryElement,"population").getTextContent().trim());
				countries.add(country);	
			}
			for (Country c:countries){
				System.out.print(c.getId()+" "+c.getName()+" "+c.getCapital()+" "+c.getPopulation()+"\n");

			}	
	}

	private static Element getSingleChild(Element element, String childName) {
		NodeList nlist = element.getElementsByTagName(childName);
		Element child = (Element) nlist.item(0);
		return child;
	}

}