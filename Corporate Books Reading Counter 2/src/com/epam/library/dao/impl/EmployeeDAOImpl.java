package com.epam.library.dao.impl;

import java.sql.*;
import org.apache.log4j.Logger;
import com.epam.library.dao.EmployeeDAO;
import com.epam.library.dao.SQLCommand;
import com.epam.library.dao.exception.DAOException;
import com.epam.library.dao.util.DAOUtil;
import com.epam.library.domain.Employee;

/**
 * Provides a DAO-logic for the {@link Employee} entity for the MySQL Database.
 */
public class EmployeeDAOImpl implements EmployeeDAO {
	private static final Logger loger = Logger.getLogger(BookDAOImpl.class);

	public static final String URL = "db.URL";
	public static final String LOGIN = "db.LOGIN";
	public static final String PASSWORD = "db.PASSWORD";
	
	private String url = DAOUtil.getParametar(URL);
	private String login = DAOUtil.getParametar(LOGIN);
	private String password = DAOUtil.getParametar(PASSWORD);
	/**
	 * Adds a new employee into the data source.
	 *
	 * @param employee an Employee object for insertion.
	 * @throws DAOException in case of some exception with the data source or connection with it.
	 */
	@Override
	public void addEmployee(Employee employee) throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverManager.getConnection(url, login, password);
			preparedStatement = connection.prepareStatement(SQLCommand.ADD_EMPLOYEE);
			preparedStatement.setInt(1, employee.getEmployeeID());
			preparedStatement.setString(2, employee.getName());
			preparedStatement.setDate(3, (Date) employee.getDateOfBirth());
			preparedStatement.setString(4, employee.getEmail());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				loger.error("Error while closing PreparedStatement", e);
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
     * Deletes an employee from the data source by employeeID.
     *
     * @param employeeID the ID of deleting employee.
     * @throws DAOException in case of some exception with the data source or connection with it.
     */
	@Override
	public void deleteEmployee(int bookID) throws DAOException {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection(url, login, password);
			statement = connection.createStatement();
			statement.executeUpdate(SQLCommand.DELETE_EMPLOYEE_WHERE_ID);
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				loger.error("Error while closing Statement", e);
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
     * Gets an employee from the data source by ID.
     *
     * @param employeeID the ID of deleting employee.
     * @throws DAOException in case of some exception with the data source or connection with it.
     */
	@Override
	public Employee getEmployee(int employeeID) throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = DriverManager.getConnection(url, login, password);
			preparedStatement = connection.prepareStatement(SQLCommand.GET_EMPLOYEE_WHERE_ID);
			preparedStatement.setInt(1, employeeID);

			resultSet = preparedStatement.executeQuery();

			Employee employee = new Employee(resultSet.getInt("EMPLOYEE_ID"), resultSet.getString("NAME"),
					resultSet.getDate("DATE_OF_BIRTH"), resultSet.getString("EMAIL"));

			return employee;

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				loger.error("Error while closing PreparedStatement", e);
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
     * Counts employees from the data source.
     * @return 
     * @throws DAOException in case of some exception with the data source or connection with it.
     */
	@Override
	public int countEmployees() throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = DriverManager.getConnection(url, login, password);

			preparedStatement = connection.prepareStatement(SQLCommand.COUNT_EMPLOYEES);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();

			return resultSet.getInt(1);

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				loger.error("Error while closing PreparedStatement", e);
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
}
