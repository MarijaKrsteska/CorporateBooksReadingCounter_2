package com.epam.library.dao;
import java.util.Map;
import com.epam.library.dao.exception.DAOException;
import com.epam.library.domain.Employee;

public interface EmployeeBookDAO {
	/**
	 * Adds a new EmployeeBook into the data source.
	 *
	 * @throws DAOException in case of some exception with the data source or connection with it
	 */
    public void addEmployeeBook() throws DAOException;

    /**
     * Gives a map of employees' names who have read more than one book.
     *
     * @return a {@link Map} of employees who have read more than one book sorted out by the number of books in descending order.
     * @throws DAOException in case of some exception with the data source or connection with it.
     */
    public Map<String, Integer> getEmployeesMoreThanOneBook() throws DAOException;
    
    /**
     * Gives a map of employees' names who have read more or equal to two books.
     *
     * @return a {@link Map} of employees who have read more or equal to two books sorted out by the employee date of birth and the number of books read in descending order.
     * @throws DAOException in case of some exception with the data source or connection with it.
     */
    public Map<Employee, Integer> getEmployeesTwoOrMoreBooks() throws DAOException;
}
