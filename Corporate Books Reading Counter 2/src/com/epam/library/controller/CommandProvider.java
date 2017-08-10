package com.epam.library.controller;
import com.epam.library.controller.command.Command; 
import com.epam.library.controller.command.CommandName;
import com.epam.library.controller.command.impl.*;
import com.epam.library.controller.command.impl.book.*;
import com.epam.library.controller.command.impl.employee.*;
import com.epam.library.controller.command.impl.employeebook.*;
import org.apache.log4j.Logger;
import java.util.HashMap;
import java.util.Map;

/**
 * Contains and gives all commands in the system.
 */
public final class CommandProvider {
    private static final Logger loger = Logger.getLogger(CommandProvider.class);
    private final Map<CommandName, Command> commands = new HashMap<>();

    CommandProvider() {
    	commands.put(CommandName.ADD_BOOK, new AddBookCommand()); 	
    	commands.put(CommandName.DELETE_BOOK_WITH_ID, new DeleteBookCommand()); 
    	
    	commands.put(CommandName.RENAME_BOOK, new RenameBookCommand());
    	
    	commands.put(CommandName.ADD_EMPLOYEE, new AddEmployeeCommand()); 	
    	commands.put(CommandName.DELETE_EMPLOYEE_WITH_ID, new DeleteEmployeeCommand()); 
    	commands.put(CommandName.GET_EMPLOYEE_WHERE_ID, new GetEmployeeCommand()); 
    	
    	commands.put(CommandName.COUNT_BOOKS, new CountBooksCommand());
    	commands.put(CommandName.COUNT_EMPLOYEES, new CountEmployeesCommand());
    	
    	commands.put(CommandName.READ_MORE_THAN_ONE_BOOK, new MoreThanOneBookCommand());
    	commands.put(CommandName.READ_TWO_OR_MORE_BOOKS, new TwoOrMoreBooksCommand());
    	
    	commands.put(CommandName.WRONG_REQUEST, new WrongRequestCommand());
    }


    /**
     * Returns {@link Command} by given name
     * @param name command name
     * @return command by given {@code command} name or {@code null}
     */
    Command getCommand(String name) {
        CommandName commandName = null;
        Command command = null;

        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = commands.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            loger.error("Error while parsing command name", e);
            command = commands.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }
}
