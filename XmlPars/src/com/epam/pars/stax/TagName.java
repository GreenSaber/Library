package com.epam.pars.stax;

import org.xml.sax.SAXException;


public enum TagName {
	NAME,CAPITAL,POPULATION,COUNTRY,COUNTRIES_LIST;

	public static TagName getElementTagName(String element){
		switch (element) {
		case "country":
			return COUNTRY;
		
		case "name":
			return NAME;
		case "capital":
			return CAPITAL;
		case "population":
			return POPULATION;
		case "countries-list":
			return COUNTRIES_LIST;
		default:
			throw new EnumConstantNotPresentException(TagName.class, element);
		}
	}
}
