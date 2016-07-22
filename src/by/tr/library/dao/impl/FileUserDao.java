package by.tr.library.dao.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import by.tr.library.bean.Book;
import by.tr.library.dao.UserDao;
import by.tr.library.dao.exception.DAOException;

public class FileUserDao implements UserDao{
	
	private static final String filename = "books.txt";
	
	@Override
	public ArrayList<Book> getCatalog() throws DAOException{
		ArrayList<Book> catalog = makeCatalog();
		return catalog;
	}
	
	@Override
	public Book getBookByTitle(String title) throws DAOException {
		ArrayList<Book> catalog = makeCatalog();
		for (int i = 0; i < catalog.size(); i++){
			if ((catalog.get(i).getTitle()).equals(title)){
				return catalog.get(i);		
			}
		}
		return null;
	}
		
	public static String getFilename(){
		return filename;
	}
	
	public static ArrayList<Book> makeCatalog() throws DAOException{
		
		ArrayList<Book> catalog = new ArrayList<Book>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(filename))){
			String s;
			while ((s = br.readLine()) != null){
				StringTokenizer tokens = new StringTokenizer(s);
				String title = tokens.nextToken();
				String author = tokens.nextToken();
				String price = tokens.nextToken();
				catalog.add(new Book(title, author, Integer.parseInt(price)));
			}
			
		}catch (IOException e){
			throw new DAOException("Some problems with :" + filename);
		}catch (NoSuchElementException e){
			throw new DAOException("Some problems with :" + filename);
		}
		return catalog;
	}

	
}