package by.tr.library.command;

import by.tr.library.bean.Request;
import by.tr.library.bean.Response;
import by.tr.library.command.exception.CommandException;
import by.tr.library.service.exception.ServiceException;

public interface Command {
	Response execute(Request request) throws CommandException, ServiceException;
}
