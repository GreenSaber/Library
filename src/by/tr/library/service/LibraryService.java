package by.tr.library.service;

import java.util.List;

import by.tr.library.bean.Book;
import by.tr.library.service.exception.ServiceException;

public interface LibraryService {
	Book findByTitle(String title)throws ServiceException ;
	boolean addBook(String titile, String author, String price)throws ServiceException ;
	List<Book> getCatalog()throws ServiceException ;
	boolean deleteBook(String title, String author)throws ServiceException;
}
