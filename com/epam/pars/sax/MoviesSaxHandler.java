package com.epam.pars.sax;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import com.epam.movies.Movie;

public class MoviesSaxHandler extends DefaultHandler {
	private List<Movie> movieList = new ArrayList<Movie>();
	private Movie movie;
	private StringBuilder text;
	
	public List<Movie> getMovieList(){
		return movieList;
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
		if (qName.equals("movie")){
			movie = new Movie();
			movie.setId(Integer.parseInt(attributes.getValue("id")));
		}
	}

	public void characters(char[] buffer, int start, int length) {
		text.append(buffer, start, length);
	}
	
	public void endElement(String uri, String localName, String qName) throws SAXException {
		MoviesTagName tagName = MoviesTagName.valueOf(qName.toUpperCase().replace("-", "_"));
		switch (tagName){
		case NAME:
			movie.setName(text.toString());
			break;
		case COUNTRY:
			movie.setCountry(text.toString());
			break;
		case DATE:
			movie.setDate(text.toString());
			break;
		case MOVIE:
			movieList.add(movie);
			movie=null;
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
