package com.epam.library.controller.command.impl.employeebook;

import com.epam.library.controller.command.Command;
import com.epam.library.domain.Employee;
import com.epam.library.service.LibraryService;
import com.epam.library.service.exception.ServiceException;
import com.epam.library.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import java.util.Map;

/**
 * Services request from the getting employees who have read more or equal to two books form.
 */
public class TwoOrMoreBooksCommand implements Command {
    private static final Logger loger = Logger.getLogger(TwoOrMoreBooksCommand.class);
    public static final String ERROR_RESPONSE = "Sorry, an error occurred";

    public static final String LINE_SEPARATOR = "line.separator";
    public static final String DELIM = "  -  ";

    @Override
    public String execute(String request) {
        loger.info("START getting employees who have read less than two books");
        Map<Employee, Integer> map = null;
        StringBuilder stringBuilder = new StringBuilder();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        LibraryService libraryService = serviceFactory.getLibraryService();
        try {
            map = libraryService.getEmployeesTwoOrMoreBooks();
            loger.info("END getting employees who have read less than two books");
        } catch (ServiceException e) {
            loger.error("Error while getting employees who have read less than two books", e);
            return ERROR_RESPONSE;
        }

        for (Map.Entry<Employee,Integer> pair : map.entrySet()) {
            stringBuilder.append(pair.getKey().getName());
            stringBuilder.append(DELIM);
            stringBuilder.append(pair.getKey().getDateOfBirth());
            stringBuilder.append(DELIM);
            stringBuilder.append(pair.getValue());
            stringBuilder.append(System.getProperty(LINE_SEPARATOR));
        }

        return stringBuilder.toString();
    }
}
