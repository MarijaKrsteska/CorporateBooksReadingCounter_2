package com.epam.library.controller;
import java.text.ParseException;

import com.epam.library.controller.command.Command;

/**
 * Controller of the whole application.
 */
public final class Controller {
    private final char paramDelimeter = ' ';
    private final CommandProvider provider = new CommandProvider();

    public String executeTask(String request) throws ParseException{
        String commandName;
        Command command;

        commandName = request.substring(0, request.indexOf(paramDelimeter));
        command = provider.getCommand(commandName);

        String response;
        response = command.execute(request);
        return response;
    }
}