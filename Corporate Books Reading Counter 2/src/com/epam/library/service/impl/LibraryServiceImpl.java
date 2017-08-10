package com.epam.library.service.impl;
import com.epam.library.dao.BookDAO;
import com.epam.library.dao.EmployeeBookDAO;
import com.epam.library.dao.EmployeeDAO;
import com.epam.library.dao.exception.DAOException;
import com.epam.library.dao.factory.DAOFactory;
import com.epam.library.domain.Book;
import com.epam.library.domain.Employee;
import com.epam.library.service.LibraryService;
import com.epam.library.service.exception.ServiceException;
import java.util.Map;

/**
 * Provides a logic with the {@link Employee}, {@link Book}, {@link EmployeeBook} entities and relate with them.
 */
public class LibraryServiceImpl implements LibraryService {
    public static final String ERROR_WHILE_ADDING_BOOK = "Exception while adding a new book";
    public static final String ERROR_WHILE_DELETING_BOOK = "Exception while deleting the book";
    
    public static final String ERROR_WHILE_ADDING_EMPLOYEE = "Exception while adding a new employee";
    public static final String ERROR_WHILE_DELETING_EMPLOYEE = "Exception while deleting the employee";
    public static final String ERROR_WHILE_GETTING_EMPLOYEE = "Exception while getting the employee";

    
    public static final String ERROR_WHILE_COUNTING_BOOKS = "Exception while counting the books";
    public static final String ERROR_WHILE_COUNTING_EMPLOYEES = "Exception while counting the employees";
    
	public static final String INCORRECT_OLDNAME = "Incorrect oldName";
    public static final String INCORRECT_NEWNAME = "Incorrect newName";
    public static final String RENAME_ERROR = "Exception while renaming the book";
    
    public static final String GET_MORE_THAN_ONE_ERROR = "Exception while getting employees who have read more than one book";
    public static final String GET_TWO_OR_MORE_ERROR = "Exception while getting employees who have read two or more books";

	/**
	 * Adds a new book into the data source.
	 *
	 * @param book a Book object for insertion.
	 * @throws DAOException in case of some exception with the data source or connection with it
	 */
    @Override
    public void addBook(Book book) throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        BookDAO bookDAO = daoFactory.getBookDAO();
        try {
            bookDAO.addBook(book);
        } catch (DAOException e) {
            throw new ServiceException(ERROR_WHILE_ADDING_BOOK, e);
        }
    }
    
	/**
     * Deletes a book from the data source by bookID.
     *
     * @param bookID the ID of deleting book.
     * @throws DAOException in case of some exception with the data source or connection with it.
     */
    @Override
    public void deleteBook(int bookID) throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        BookDAO bookDAO = daoFactory.getBookDAO();
        try {
            bookDAO.deleteBook(bookID);
        } catch (DAOException e) {
            throw new ServiceException(ERROR_WHILE_DELETING_BOOK, e);
        }
    }
    
	/**
	 * Adds a new employee into the data source.
	 *
	 * @param employee an Employee object for insertion.
	 * @throws DAOException in case of some exception with the data source or connection with it.
	 */
    @Override
	public void addEmployee(Employee employee) throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
	    EmployeeDAO employeeDAO = daoFactory.getEmployeeDAO();
	    try {
	    	employeeDAO.addEmployee(employee);
	    } catch (DAOException e) {
	    	throw new ServiceException(ERROR_WHILE_ADDING_BOOK, e);
	    }		
	}

	/**
     * Deletes an employee from the data source by employeeID.
     *
     * @param employeeID the ID of deleting employee.
     * @throws DAOException in case of some exception with the data source or connection with it.
     */
	@Override
	public void deleteEmployee(int employeeID) throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
	    EmployeeDAO employeeDAO = daoFactory.getEmployeeDAO();
	    try {
	    	employeeDAO.deleteEmployee(employeeID);
	    } catch (DAOException e) {
	        throw new ServiceException(ERROR_WHILE_DELETING_EMPLOYEE, e);
	    }		
	}
	
	/**
     * Gets an employee from the data source by ID.
     *
     * @param employeeID the ID of deleting employee.
     * @throws DAOException in case of some exception with the data source or connection with it.
     */
	@Override
	public Employee getEmployee(int employeeID) throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
	    EmployeeDAO employeeDAO = daoFactory.getEmployeeDAO();
	    try {
	    	return employeeDAO.getEmployee(employeeID);
	    } catch (DAOException e) {
	        throw new ServiceException(ERROR_WHILE_DELETING_EMPLOYEE, e);
	    }		
	}
            
	/**
     * Counts books from the data source.
     * @throws DAOException in case of some exception with the data source or connection with it.
     */
	@Override
	public int countBooks() throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
        BookDAO bookDAO = daoFactory.getBookDAO();
        try {
        	return bookDAO.countBooks();
        } catch (DAOException e) {
            throw new ServiceException(ERROR_WHILE_COUNTING_BOOKS, e);
        }
	}

    /**
     * Counts employees from the data source.
     * @return 
     * @throws DAOException in case of some exception with the data source or connection with it.
     */
	@Override
	public int countEmployees() throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
	    EmployeeDAO employeeDAO = daoFactory.getEmployeeDAO();
        try {
        	return employeeDAO.countEmployees();
        } catch (DAOException e) {
            throw new ServiceException(ERROR_WHILE_COUNTING_EMPLOYEES, e);
        }
	}
	
	/**
     * Renames a book in the data source.
     *
     * @param oldName the old Title of the book.
     * @param newName the new Title of the book.
     * @throws DAOException in case of some exception with the data source or connection with it.
     */	
    @Override
    public void renameBook(String oldName, String newName) throws ServiceException {

        if (oldName == null || oldName.isEmpty()) {
            throw new ServiceException(INCORRECT_OLDNAME);
        }

        if (newName == null || newName.isEmpty()) {
            throw new ServiceException(INCORRECT_NEWNAME);
        }

        DAOFactory daoFactory = DAOFactory.getInstance();
        BookDAO bookDAO = daoFactory.getBookDAO();
        try {
            bookDAO.renameBook(oldName, newName);
        } catch (DAOException e) {
            throw new ServiceException(RENAME_ERROR, e);
        }

    }

    /**
     * Gives a map of employees' names who have read more than one book.
     *
     * @return a {@link Map} of employees who have read more than one book sorted out by the number of books in descending order.
     * @throws DAOException in case of some exception with the data source or connection with it.
     */
    @Override
    public Map<String, Integer> getEmployeesMoreThanOneBook() throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        EmployeeBookDAO employeeBookDAO = daoFactory.getEmployeeBookDAO();
        try {
            return employeeBookDAO.getEmployeesMoreThanOneBook();
        } catch (DAOException e) {
            throw new ServiceException(GET_MORE_THAN_ONE_ERROR, e);
        }
    }

    /**
     * Gives a map of employees' names who have read more or equal to two books.
     *
     * @return a {@link Map} of employees who have read more or equal to two books sorted out by the employee date of birth and the number of books read in descending order.
     * @throws DAOException in case of some exception with the data source or connection with it.
     */
    @Override
    public Map<Employee, Integer> getEmployeesTwoOrMoreBooks() throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        EmployeeBookDAO employeeBookDAO = daoFactory.getEmployeeBookDAO();
        try {
            return employeeBookDAO.getEmployeesTwoOrMoreBooks();
        } catch (DAOException e) {
            throw new ServiceException(GET_TWO_OR_MORE_ERROR, e);
        }
    }
}