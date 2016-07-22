package by.tr.library.controller;


import by.tr.library.bean.Request;
import by.tr.library.bean.Response;
import by.tr.library.command.Command;
import by.tr.library.command.exception.CommandException;
import by.tr.library.service.exception.ServiceException;

public class Controller {
	private final CommandHelper helper = new CommandHelper();
	public Controller(){}
	
	
	
	public Response doAction(Request request) throws ServiceException{
		
		String commandName = request.getCommandName();
		Command command = helper.getCommand(commandName);
		Response response;
		try {
			response = command.execute(request);
		} catch (CommandException e) {
			response = new Response();
			response.setErrorMessage("error message");
		}
		return response;
		
		
	}

}
