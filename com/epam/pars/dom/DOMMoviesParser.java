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

import com.epam.movies.Movie;

public class DOMMoviesParser {

	public static void main(String[] args) throws SAXException, IOException {
		DOMParser parser =new DOMParser();
		parser.parse("src\\movies.xml");
		Document document = parser.getDocument();
		Element root = document.getDocumentElement();
		List<Movie> movies = new ArrayList<Movie>();
			
			NodeList movieNodes = root.getElementsByTagName("movie");
			Movie movie = null;
			for (int i = 0; i<movieNodes.getLength();i++){
				movie=new Movie();
				Element movieElement = (Element) movieNodes.item(i);
				movie.setId(Integer.parseInt(movieElement.getAttribute("id")));
				movie.setName(getSingleChild(movieElement,"name").getTextContent().trim());
				movie.setCountry(getSingleChild(movieElement,"country").getTextContent().trim());
				movie.setDate(getSingleChild(movieElement,"date").getTextContent().trim());
				movies.add(movie);	
			}
			for (Movie m:movies){
				System.out.print(m.getId()+" "+m.getName()+" "+m.getCountry()+" "+m.getDate()+"\n");

			}	
	}

	private static Element getSingleChild(Element element, String childName) {
		NodeList nlist = element.getElementsByTagName(childName);
		Element child = (Element) nlist.item(0);
		return child;
	}

}
