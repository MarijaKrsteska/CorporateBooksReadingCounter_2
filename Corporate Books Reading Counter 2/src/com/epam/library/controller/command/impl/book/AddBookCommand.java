package com.epam.library.controller.command.impl.book;
import com.epam.library.controller.command.Command;
import com.epam.library.domain.Book;
import com.epam.library.service.LibraryService;
import com.epam.library.service.exception.ServiceException;
import com.epam.library.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

/**
 * Services request from the adding book form.
 */
public class AddBookCommand implements Command {
    private static final Logger loger = Logger.getLogger(AddBookCommand.class);
    private String response = ADDED_RESPONSE;

    public static final String ADDED_RESPONSE = "The book has been successfully added";
    public static final String ERROR_RESPONSE = "Sorry, an error occurred";
    
    @Override
    public String execute(String request) {
        loger.info("START adding book");
        
        String[] parts = request.split(",");
        
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        LibraryService libraryService = serviceFactory.getLibraryService();
        
        try {
            libraryService.addBook(new Book(Integer.parseInt(parts[1].trim()), parts[2].trim(), parts[3].trim(), Integer.parseInt(parts[4].trim()), parts[5].trim()));
            loger.info("END adding book");
        } catch (ServiceException e) {
            loger.error("Error while adding the book", e);
            response = ERROR_RESPONSE;
        }
        return response;
    }
}
