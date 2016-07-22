package by.tr.library.start;

import by.tr.library.bean.Request;
import by.tr.library.bean.Response;
import by.tr.library.controller.Controller;
import by.tr.library.service.exception.ServiceException;

public class Start {

	public static void main(String[] args) throws ServiceException{
		Controller controller = new Controller();
		
		Request request = new Request();
		request.setIsAdmin(true);
		request.setCommandName("ADD_BOOK_COMMAND");
		
		request.setTitle("Fight Club");
		request.setAuthor("Chuck Palahniuk");
		request.setPrice("50");
		request.setLogin("login");
		request.setPassword("password");
		
		Response response = controller.doAction(request);
		
		if(response.getErrorMessage() != null){
			System.out.println(response.getErrorMessage());
		}else{
			System.out.println(response.getMessage());
		}
		response.printListBook();
	}

}