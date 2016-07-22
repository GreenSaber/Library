package com.epam.pars.sax;

import java.io.IOException;
import java.util.List;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.epam.countries.Country;

public class SaxStart {

	public static void main(String[] args) throws SAXException, IOException {
		XMLReader reader = XMLReaderFactory.createXMLReader();
		SaxHandler handler = new SaxHandler();
		reader.setContentHandler(handler);
		reader.parse(new InputSource("src\\countries.xml"));
		
		List<Country> countries = handler.getCountryList();
		for (Country c:countries){
			System.out.print(c.getId()+" "+c.getName()+" "+c.getCapital()+" "+c.getPopulation()+"\n");
		}
		
	}

}