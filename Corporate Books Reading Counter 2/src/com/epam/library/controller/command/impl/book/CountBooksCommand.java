package com.epam.library.controller.command.impl.book;
import org.apache.log4j.Logger;

import com.epam.library.controller.command.Command;
import com.epam.library.service.LibraryService;
import com.epam.library.service.exception.ServiceException;
import com.epam.library.service.factory.ServiceFactory;

/**
 * Services request from the counting books form.
 */
public class CountBooksCommand implements Command{
	private static final Logger loger = Logger.getLogger(CountBooksCommand.class);
    private String response = COUNTED_RESPONSE;

    public static final String COUNTED_RESPONSE = "The books have been successfully counted";
    public static final String ERROR_RESPONSE = "Sorry, an error occurred";
    
    @Override
    public String execute(String request) {
        loger.info("START counting books");
                
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        LibraryService libraryService = serviceFactory.getLibraryService();
        
        try {
            libraryService.countBooks();
            loger.info("END counting books");
        } catch (ServiceException e) {
            loger.error("Error while counting the books", e);
            response = ERROR_RESPONSE;
        }
        return response;
    }
}
