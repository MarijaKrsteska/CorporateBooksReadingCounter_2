package com.epam.library.service;
import java.sql.SQLException;
import java.util.List;

import com.epam.library.dao.exception.DAOException;
import com.epam.library.domain.EmployeeBook;

public interface IRandomSeed {
	/**
	 * Randomly generates pairs (employeeID, bookID) from the data source.
	 */
	public void addPairs(List<EmployeeBook> pairs, int bookCount, int numOfEmployees, int numOfBooks);
	/**
	 * Randomly generates pairs (employeeID, bookID) from the data source.
	 */
	public List<EmployeeBook> generatePairs() throws SQLException, ClassNotFoundException, DAOException;
}
