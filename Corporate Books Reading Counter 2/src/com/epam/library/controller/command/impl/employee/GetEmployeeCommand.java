package com.epam.library.controller.command.impl.employee;
import java.text.ParseException;
import org.apache.log4j.Logger;
import com.epam.library.controller.command.Command;
import com.epam.library.service.LibraryService;
import com.epam.library.service.exception.ServiceException;
import com.epam.library.service.factory.ServiceFactory;

/**
 * Services request from the getting employee form.
 */
public class GetEmployeeCommand implements Command{
	private static final Logger loger = Logger.getLogger(AddEmployeeCommand.class);
    private String response = GOT_RESPONSE;

    public static final String GOT_RESPONSE = "The employee has been successfully found";
    public static final String ERROR_RESPONSE = "Sorry, an error occurred";
    
    @Override
    public String execute(String request) throws NumberFormatException, ParseException {		
        loger.info("START searching for the employee");
        
        String[] parts = request.split(",");
        
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        LibraryService libraryService = serviceFactory.getLibraryService();
        
        try {
            libraryService.getEmployee(Integer.parseInt(parts[1]));
            loger.info("END finding employee");
        } catch (ServiceException e) {
            loger.error("Error while finding the employee", e);
            response = ERROR_RESPONSE;
        }
        return response;
    }
}
