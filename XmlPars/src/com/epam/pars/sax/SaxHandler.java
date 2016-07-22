package com.epam.pars.sax;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import com.epam.countries.Country;


public class SaxHandler extends DefaultHandler {
	private List<Country> countryList = new ArrayList<Country>();
	private Country country;
	private StringBuilder text;
	
	public List<Country> getCountryList(){
		return countryList;
	}

	public void startDocument() throws SAXException {
		System.out.println("Start parsing.");
	}

	public void endDocument() throws SAXException {
		System.out.println("Parsing ended.");
	}
	
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
//		System.out.println("start element -> "+"uri: "+uri+", localName: "+localName+" ,qName: "+qName);
		text=new StringBuilder();
		if (qName.equals("country")){
			country = new Country();
			country.setId(Integer.parseInt(attributes.getValue("id")));
		}
	}

	public void characters(char[] buffer, int start, int length) {
		text.append(buffer, start, length);
	}
	
	public void endElement(String uri, String localName, String qName) throws SAXException {
		TagName tagName = TagName.valueOf(qName.toUpperCase().replace("-", "_"));
		switch (tagName){
		case NAME:
			country.setName(text.toString());
			break;
		case CAPITAL:
			country.setCapital(text.toString());
			break;
		case POPULATION:
			country.setPopulation(text.toString());
			break;
		case COUNTRY:
			countryList.add(country);
			country=null;
			break;
		}
	}

	public void warning(SAXParseException exception) {
			System.err.println("WARNING: line " + exception.getLineNumber() + ": "+ exception.getMessage());
		}

	public void error(SAXParseException exception) {
		System.err.println("ERROR: line: " + exception.getLineNumber() + ": "+ exception.getMessage());
		}

	public void fatalError(SAXParseException exception) throws SAXParseException {
		System.err.println("FATAL: line " + exception.getLineNumber() + ": "+ exception.getMessage());
		throw (exception);
	}	
		
		
}