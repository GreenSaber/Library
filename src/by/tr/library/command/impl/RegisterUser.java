package by.tr.library.command.impl;


import by.tr.library.bean.Request;
import by.tr.library.bean.Response;
import by.tr.library.command.Command;
import by.tr.library.command.exception.CommandException;
import by.tr.library.service.ClientService;
import by.tr.library.service.ServiceFactory;
import by.tr.library.service.exception.ServiceException;

public class RegisterUser implements Command {

	@Override
	public Response execute(Request request) throws CommandException {
		String login = request.getLogin();
		String password = request.getPassword();
		
		ServiceFactory factory = ServiceFactory.getInstance();
		ClientService service = factory.getClientService();
		
		Response response = new Response();
		try {
			boolean result = service.registration(login, password);
			if (result){
				response.setErrorMessage(null);
				response.setMessage("Registration is OK");
			}
			else{
				response.setErrorMessage("Registration fail");
				response.setMessage(null);
			}
		} catch (ServiceException e) {
			throw new CommandException("command message", e);

		}
		return response;
	}

}
