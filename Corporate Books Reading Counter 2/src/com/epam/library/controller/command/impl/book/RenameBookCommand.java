package com.epam.library.controller.command.impl.book;

import com.epam.library.controller.command.Command;
import com.epam.library.service.LibraryService;
import com.epam.library.service.exception.ServiceException;
import com.epam.library.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

/**
 * Services request from the renaming book form.
 */
public class RenameBookCommand implements Command {
    public static final String OK_RESPONSE = "The book has been successfully renamed";
    public static final String ERROR_RESPONSE = "Sorry, an error occurred";
    private static final Logger loger = Logger.getLogger(RenameBookCommand.class);
    private String response = OK_RESPONSE;

    @Override
    public String execute(String request) {
        loger.info("START renaming book");
        String[] parts = request.split(",");
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        LibraryService libraryService = serviceFactory.getLibraryService();

        try {
            libraryService.renameBook(parts[1].trim(), parts[2].trim());
            loger.info("END renaming book");
        } catch (ServiceException e) {
            loger.error("Error while renaming book", e);
            response = ERROR_RESPONSE;
        }

        return response;
    }
}
