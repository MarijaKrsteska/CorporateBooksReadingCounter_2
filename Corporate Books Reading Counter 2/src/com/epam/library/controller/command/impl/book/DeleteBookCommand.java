package com.epam.library.controller.command.impl.book;
import com.epam.library.controller.command.Command;
import com.epam.library.service.LibraryService;
import com.epam.library.service.exception.ServiceException;
import com.epam.library.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

/**
 * Services request from the deleting book form.
 */
public class DeleteBookCommand implements Command {
    private static final Logger loger = Logger.getLogger(DeleteBookCommand.class);
    private String response = DELETED_RESPONSE;
    
    public static final String DELETED_RESPONSE = "The book has been successfully deleted";
    public static final String ERROR_RESPONSE = "Sorry, an error occurred";
    
    @Override
    public String execute(String request) {
        loger.info("START deleting book");
        String[] parts = request.split(" ");
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        LibraryService libraryService = serviceFactory.getLibraryService();
        try {
            libraryService.deleteBook(Integer.parseInt(parts[1]));
            loger.info("END deleting book");
        } catch (ServiceException e) {
            loger.error("Error while deleting book", e);
            response = ERROR_RESPONSE;
        }
        return response;
    }
}
