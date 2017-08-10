package com.epam.library.dao.impl;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import com.epam.library.dao.EmployeeBookDAO;
import com.epam.library.dao.SQLCommand;
import com.epam.library.dao.exception.DAOException;
import com.epam.library.dao.util.DAOUtil;
import com.epam.library.domain.Employee;
import com.epam.library.domain.EmployeeBook;
import com.epam.library.service.impl.RandomSeed;

/**
 * Provides a DAO-logic for the {@link EmployeeBook} entity for the MySQL Database.
 */
public class EmployeeBookDAOImpl implements EmployeeBookDAO {
	private static final Logger loger = Logger.getLogger(EmployeeBookDAOImpl.class);

	public static final String URL = "db.URL";
	public static final String LOGIN = "db.LOGIN";
	public static final String PASSWORD = "db.PASSWORD";
	
	private String url = DAOUtil.getParametar(URL);
	private String login = DAOUtil.getParametar(LOGIN);
	private String password = DAOUtil.getParametar(PASSWORD);
	
	private static RandomSeed rs = new RandomSeed();

	/**
	 * Adds a new EmployeeBook into the data source.
	 * @throws DAOException in case of some exception with the data source or connection with it
	 */
	@Override
	public void addEmployeeBook() throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = DriverManager.getConnection(url, login, password);

			List<EmployeeBook> pairs = rs.generatePairs();
			for (EmployeeBook pair : pairs) {
				preparedStatement = connection.prepareStatement(SQLCommand.INSERT_EMPLOYEE_BOOK);

				preparedStatement.setInt(1, pair.getEmployeeID());
				preparedStatement.setInt(2, pair.getBookID());

				preparedStatement.executeUpdate();
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				loger.error("Error while closing Statement", e);
			}
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				loger.error("Error while closing ResultSet", e);
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				loger.error("Error while closing Connection", e);
			}
		}
	}

    /**
     * Gives a map of employees' names who have read more than one book.
     *
     * @return a {@link Map} of employees who have read more than one book sorted out by the number of books in descending order.
     * @throws DAOException in case of some exception with the data source or connection with it.
     */
	@Override
	public Map<String, Integer> getEmployeesMoreThanOneBook() throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Map<String, Integer> map = new HashMap<>();

		try {	
			connection = DriverManager.getConnection(url, login, password);
			preparedStatement = connection.prepareStatement(SQLCommand.EMPLOYEES_WHO_HAVE_READ_MORE_THAN_ONE_BOOK);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int numberOfBooks = resultSet.getInt(1);
				int employeeID = resultSet.getInt(2);

				EmployeeDAOImpl empl = new EmployeeDAOImpl();
				Employee employee = empl.getEmployee(employeeID);

				System.out
						.println(String.format("Employee %s - Number of books: %d", employee.getName(), numberOfBooks));
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				loger.error("Error while closing Statement", e);
			}
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				loger.error("Error while closing ResultSet", e);
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				loger.error("Error while closing Connection", e);
			}
		}
		return map;
	}

    /**
     * Gives a map of employees' names who have read more or equal to two books.
     *
     * @return a {@link Map} of employees who have read more or equal to two books sorted out by the employee date of birth and the number of books read in descending order.
     * @throws DAOException in case of some exception with the data source or connection with it.
     */
	@Override
	public Map<Employee, Integer> getEmployeesTwoOrMoreBooks() throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Map<Employee, Integer> map = new HashMap<>();

		try {
			connection = DriverManager.getConnection(url, login, password);
			preparedStatement = connection
					.prepareStatement(SQLCommand.EMPLOYEES_WHO_HAVE_READ_MORE_THAN_OR_EQUAL_TO_TWO_BOOKS);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int numberOfBooks = resultSet.getInt(1);
				int employeeID = resultSet.getInt(2);

				EmployeeDAOImpl empl = new EmployeeDAOImpl();
				Employee employee = empl.getEmployee(employeeID);

				System.out.println(String.format("Employee %s %s - Number of books: %d", employee.getName(),
						employee.getDateOfBirth(), numberOfBooks));
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				loger.error("Error while closing Statement", e);
			}
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				loger.error("Error while closing ResultSet", e);
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				loger.error("Error while closing Connection", e);
			}
		}
		return map;
	}
}