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

import com.epam.movies.Movie;

public class StaxMoviesParser {
	
	public static void main(String[] args) throws SAXException, IOException {
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		try {
			InputStream input = new FileInputStream("src\\movies.xml");
			XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
			List<Movie> movies = process(reader);
			
			for (Movie m:movies){
				System.out.print(m.getId()+" "+m.getName()+" "+m.getCountry()+" "+m.getDate()+"\n");
			}
			}catch (XMLStreamException e){
				e.printStackTrace();
		}
	}

	private static List<Movie> process(XMLStreamReader reader) throws XMLStreamException {
		List<Movie> movies = new ArrayList<Movie>();
		Movie movie = null;
		MoviesTagName elementName = null;
		while (reader.hasNext()){
			int type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				elementName = MoviesTagName.getElementTagName(reader.getLocalName());
				switch (elementName) {
				case MOVIE:
					movie = new Movie();
					Integer id = Integer.parseInt(reader.getAttributeValue(null, "id"));
					movie.setId(id);
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
					movie.setName(text);
					break;
				case COUNTRY:
					movie.setCountry(text);
					break;
				case DATE:
					movie.setDate(text);
					break;
				}
				break;
			case XMLStreamConstants.END_ELEMENT:
				elementName= MoviesTagName.getElementTagName(reader.getLocalName());
				switch (elementName){
				case MOVIE:
					movies.add(movie);
				}
			}
		}
		return movies;
	}
}
