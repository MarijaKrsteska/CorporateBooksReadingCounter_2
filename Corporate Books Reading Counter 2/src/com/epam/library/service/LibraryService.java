package com.epam.library.service;
import com.epam.library.domain.Book;
import com.epam.library.domain.Employee;
import com.epam.library.service.exception.ServiceException;
import java.util.Map;

/**
 * 
 */
public interface LibraryService {
	public void addBook(Book book) throws ServiceException;
	public void deleteBook(int bookID) throws ServiceException;

	public void renameBook(String oldName, String newName) throws ServiceException;

	public void addEmployee(Employee employee) throws ServiceException;
	public void deleteEmployee(int bookID) throws ServiceException;
    public Employee getEmployee(int employeeID) throws ServiceException;

	public int countBooks() throws ServiceException;
	public int countEmployees() throws ServiceException;

	public Map<String, Integer> getEmployeesMoreThanOneBook() throws ServiceException;
	public Map<Employee, Integer> getEmployeesTwoOrMoreBooks() throws ServiceException;
}
