package com.epam.library.dao;
import com.epam.library.dao.exception.DAOException;
import com.epam.library.domain.Employee;

public interface EmployeeDAO {
	/**
	 * Adds a new employee into the data source.
	 *
	 * @param employee an Employee object for insertion.
	 * @throws DAOException in case of some exception with the data source or connection with it.
	 */
	public void addEmployee(Employee employee) throws DAOException;
	
	/**
     * Deletes an employee from the data source by employeeID.
     *
     * @param employeeID the ID of deleting employee.
     * @throws DAOException in case of some exception with the data source or connection with it.
     */
    public void deleteEmployee(int employeeID) throws DAOException;
    
	/**
     * Gets an employee from the data source by ID.
     *
     * @param employeeID the ID of deleting employee.
     * @throws DAOException in case of some exception with the data source or connection with it.
     */
    public Employee getEmployee(int employeeID) throws DAOException;

    /**
     * Counts employees from the data source.
     * @return 
     * @throws DAOException in case of some exception with the data source or connection with it.
     */
    public int countEmployees() throws DAOException;
}
