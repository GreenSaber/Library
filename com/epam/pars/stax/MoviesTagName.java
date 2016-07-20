package com.epam.pars.stax;

import org.xml.sax.SAXException;


public enum MoviesTagName {
	NAME,COUNTRY,DATE,MOVIE,MOVIES_LIST;

	public static MoviesTagName getElementTagName(String element){
		switch (element) {
		case "movie":
			return MOVIE;
		
		case "name":
			return NAME;
		case "country":
			return COUNTRY;
		case "date":
			return DATE;
		case "movies-list":
			return MOVIES_LIST;
		default:
			throw new EnumConstantNotPresentException(MoviesTagName.class, element);
		}
	}
}
