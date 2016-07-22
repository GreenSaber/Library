package by.tr.library.dao.impl;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import by.tr.library.bean.Book;
import by.tr.library.bean.User;
import by.tr.library.dao.AdminDao;
import by.tr.library.dao.exception.DAOException;

public class FileAdminDao implements AdminDao {

	
	@Override
	public boolean addNewBook(Book book) throws DAOException {	
		
		ArrayList<Book> catalog = FileUserDao.makeCatalog();
		for (int i = 0; i < catalog.size(); i++){
			if (((catalog.get(i).getTitle()).equals(book.getTitle())) && ((catalog.get(i).getAuthor()).equals(book.getAuthor()))){
				return false;
			}
		}

		writeToFile(book.toString(), FileUserDao.getFilename(), true);
		return true;
	}
	
	public static void writeToFile(String line, String filename, boolean append) throws DAOException{
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, append))){	
			if (append){
				bw.newLine();
			}	
			bw.write(line);
		} catch(IOException e){
			throw new DAOException("Some problems with : " + filename);
		}
	}


	@Override
	public boolean deleteBook(String title, String author) throws DAOException {
		boolean res = false;
		ArrayList<Book> catalog = FileUserDao.makeCatalog();
		for (int i = 0; i < catalog.size(); i++){
			if (((catalog.get(i).getTitle()).equals(title)) && ((catalog.get(i).getAuthor()).equals(author))){
				catalog.remove(i);
				res = true;
			}
		}
		if (res){
			boolean append = false;
			for (int i = 0; i < catalog.size(); i++){
				writeToFile(catalog.get(i).toString(), FileUserDao.getFilename(), append);
				append = true;
			}
		}
		return res;
	}

}