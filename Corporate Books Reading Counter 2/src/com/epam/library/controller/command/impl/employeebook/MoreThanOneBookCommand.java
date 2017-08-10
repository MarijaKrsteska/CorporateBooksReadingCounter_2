package com.epam.library.controller.command.impl.employeebook;

import com.epam.library.controller.command.Command; 
import com.epam.library.service.LibraryService;
import com.epam.library.service.exception.ServiceException;
import com.epam.library.service.factory.ServiceFactory;
import org.apache.log4j.Logger;
import java.util.Map;

/**
 * Services request from the getting employees who have read more than one book form.
 */
public class MoreThanOneBookCommand implements Command {
    private static final Logger loger = Logger.getLogger(MoreThanOneBookCommand.class);
    public static final String ERROR_RESPONSE = "Sorry, but an error occurred";

    public static final String LINE_SEPARATOR = "line.separator";
    public static final String DELIM = "  -  ";

    @Override
    public String execute(String request) {
        loger.info("START getting employees who have read more than one book");
        
        Map<String, Integer> map = null;
        StringBuilder stringBuilder = new StringBuilder();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        LibraryService libraryService = serviceFactory.getLibraryService();

        try {
            map = libraryService.getEmployeesMoreThanOneBook();
            loger.info("END getting employees who have read more than one book");
        } catch (ServiceException e) {
            loger.error("Error while getting employees who have read more than one book", e);
            return ERROR_RESPONSE;
        }

        for (Map.Entry<String,Integer> pair : map.entrySet()) {
            stringBuilder.append(pair.getKey()).append(DELIM).append(pair.getValue()).append(System.getProperty(LINE_SEPARATOR));
        }

        return stringBuilder.toString();
    }
}
