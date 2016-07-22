package com.epam.pars.stax;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.xml.sax.SAXException;

import com.epam.countries.Country;

public class StaxParser {
	
	public static void main(String[] args) throws SAXException, IOException {
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		try {
			InputStream input = new FileInputStream("src\\countries.xml");
			XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
			List<Country> countries = process(reader);
			
			for (Country c:countries){
				System.out.print(c.getId()+" "+c.getName()+" "+c.getCapital()+" "+c.getPopulation()+"\n");
			}
			}catch (XMLStreamException e){
				e.printStackTrace();
		}
	}

	private static List<Country> process(XMLStreamReader reader) throws XMLStreamException {
		List<Country> countries = new ArrayList<Country>();
		Country country = null;
		TagName elementName = null;
		while (reader.hasNext()){
			int type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				elementName = TagName.getElementTagName(reader.getLocalName());
				switch (elementName) {
				case COUNTRY:
					country = new Country();
					Integer id = Integer.parseInt(reader.getAttributeValue(null, "id"));
					country.setId(id);
					break;
				}
				break;
			
			case XMLStreamConstants.CHARACTERS:
				String text = reader.getText().trim();
				
				if (text.isEmpty()){
					break;
				}
				switch (elementName){
				case NAME:
					country.setName(text);
					break;
				case CAPITAL:
					country.setCapital(text);
					break;
				case POPULATION:
					country.setPopulation(text);
					break;
				}
				break;
			case XMLStreamConstants.END_ELEMENT:
				elementName= TagName.getElementTagName(reader.getLocalName());
				switch (elementName){
				case COUNTRY:
					countries.add(country);
				}
			}
		}
		return countries;
	}
}
