package com.epam.library.controller.command.impl.employee;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.apache.log4j.Logger;
import com.epam.library.controller.command.Command;
import com.epam.library.domain.Employee;
import com.epam.library.service.LibraryService;
import com.epam.library.service.exception.ServiceException;
import com.epam.library.service.factory.ServiceFactory;

/**
 * Services request from the adding employee form.
 */
public class AddEmployeeCommand implements Command{
	private static final Logger loger = Logger.getLogger(AddEmployeeCommand.class);
    private String response = ADDED_RESPONSE;

    public static final String ADDED_RESPONSE = "The employee has been successfully added";
    public static final String ERROR_RESPONSE = "Sorry, an error occurred";
    
    @Override
    public String execute(String request) throws NumberFormatException, ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");		
		
        loger.info("START adding employee");
        
        String[] parts = request.split(",");
        
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        LibraryService libraryService = serviceFactory.getLibraryService();
        
        try {
            libraryService.addEmployee(new Employee(Integer.parseInt(parts[1].trim()), parts[2].trim(), formatter.parse(parts[3].trim()), parts[4].trim()));
            loger.info("END adding employee");
        } catch (ServiceException e) {
            loger.error("Error while adding the employee", e);
            response = ERROR_RESPONSE;
        }
        return response;
    }
}
