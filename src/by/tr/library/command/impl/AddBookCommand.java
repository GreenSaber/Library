package by.tr.library.command.impl;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import by.tr.library.bean.Request;
import by.tr.library.bean.Response;
import by.tr.library.command.Command;
import by.tr.library.command.exception.CommandException;
import by.tr.library.service.LibraryService;
import by.tr.library.service.ServiceFactory;
import by.tr.library.service.exception.ServiceException;

public class AddBookCommand implements Command {
	
	@Override
	public Response execute(Request request) throws CommandException, ServiceException {
		
		String title = request.getTitle();
		String author = request.getAuthor();
		String price = request.getPrice();
		
		ServiceFactory factory = ServiceFactory.getInstance();
		LibraryService service = factory.getLibraryService();
		
		Response response = new Response();
//		try {
//		if (request.isAdmin() == true){
			boolean result = service.addBook(title, author, price);
			if (result){
				response.setMessage("Book added.");
			}
//			else{
//				response.setErrorMessage("Only Admin can add a book.");
//			}
//		}
//		} catch (ServiceException e){
//			throw new CommandException("command message", e);
//		}
		return response;
	}

}
