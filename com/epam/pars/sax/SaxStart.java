package com.epam.pars.sax;

import java.io.IOException;
import java.util.List;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.epam.movies.Movie;

public class SaxStart {

	public static void main(String[] args) throws SAXException, IOException {
		XMLReader reader = XMLReaderFactory.createXMLReader();
		MoviesSaxHandler handler = new MoviesSaxHandler();
		reader.setContentHandler(handler);
		reader.parse(new InputSource("src\\movies.xml"));
		
		List<Movie> movies = handler.getMovieList();
		for (Movie m:movies){
			System.out.print(m.getId()+" "+m.getName()+" "+m.getCountry()+" "+m.getDate()+"\n");
		}
		
	}

}
