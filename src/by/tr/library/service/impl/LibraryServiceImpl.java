package by.tr.library.service.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import by.tr.library.bean.Book;
import by.tr.library.dao.AdminDao;
import by.tr.library.dao.DAOFactory;
import by.tr.library.dao.UserDao;
import by.tr.library.dao.exception.DAOException;
import by.tr.library.service.LibraryService;
import by.tr.library.service.exception.ServiceException;

public class LibraryServiceImpl implements LibraryService{
	
	@Override
	public Book findByTitle(String title) throws ServiceException {
		if (title == null || title.isEmpty()){
			return null;
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		UserDao userDao = factory.getUserDao();
		
		Book book;
		try {
			book = userDao.getBookByTitle(title);
		} catch (DAOException e) {
			throw new ServiceException("service message", e);
		}	
		return book;
}
	@Override
	public boolean addBook(String titile, String author, String price) throws ServiceException {
		//validation
		
		Book book = new Book();// Book(title, author)
		
		DAOFactory factory = DAOFactory.getInstance();
		AdminDao adminDAo = factory.getAdminDao();
		
		// call method check
		try {
			adminDAo.addNewBook(book);
		} catch (DAOException e) {
			throw new ServiceException("service message", e);
		}
		
		return false;
	}

	@Override
	public List<Book> getCatalog() throws ServiceException {
		
		DAOFactory factory = DAOFactory.getInstance();
		UserDao userDao = factory.getUserDao();
		
		List<Book> listBook;
		try {
			listBook = userDao.getCatalog();
		} catch (DAOException e) {
			throw new ServiceException("service message", e);
		}
		
		return listBook;
	}
	
	@Override
	public boolean deleteBook(String title, String author)throws ServiceException {
		
		if (title == null || title.isEmpty()){
			return false;
		}
		
		if (author == null || author.isEmpty()){
			return false;
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		AdminDao aDao = factory.getAdminDao();
		
		boolean result;
		try {
			result = aDao.deleteBook(title, author);
		} catch (DAOException e) {
			throw new ServiceException("service message", e);
		}
		
		return result;
	}
}

















