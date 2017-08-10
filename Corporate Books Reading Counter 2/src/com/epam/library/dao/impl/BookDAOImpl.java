package com.epam.library.dao.impl;

import com.epam.library.dao.BookDAO;
import com.epam.library.dao.SQLCommand;
import com.epam.library.dao.exception.DAOException;
import com.epam.library.dao.util.DAOUtil;
import com.epam.library.domain.Book;
import org.apache.log4j.Logger;
import java.sql.*;

/**
 * Provides a DAO-logic for the {@link Book} entity for the MySQL Database.
 */
public class BookDAOImpl implements BookDAO {
	private static final Logger loger = Logger.getLogger(BookDAOImpl.class);

	public static final String URL = "db.URL";
	public static final String LOGIN = "db.LOGIN";
	public static final String PASSWORD = "db.PASSWORD";
	
	private String url = DAOUtil.getParametar(URL);
	private String login = DAOUtil.getParametar(LOGIN);
	private String password = DAOUtil.getParametar(PASSWORD);
	/**
	 * Adds a new book into the data source.
	 *
	 * @param book a Book object for insertion.
	 * @throws DAOException in case of some exception with the data source or connection with it
	 */
	@Override
	public void addBook(Book book) throws DAOException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverManager.getConnection(url, login, password);
			preparedStatement = connection.prepareStatement(SQLCommand.ADD_BOOK);
			preparedStatement.setInt(1, book.getBookID());
			preparedStatement.setString(2, book.getTitle());
			preparedStatement.setString(3, book.getBrief());
			preparedStatement.setInt(4, book.getPublishYear());
			preparedStatement.setString(5, book.getAuthorName());

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
     * Deletes a book from the data source by bookID.
     *
     * @param bookID the ID of deleting book.
     * @throws DAOException in case of some exception with the data source or connection with it.
     */
	@Override
	public void deleteBook(int bookID) throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverManager.getConnection(url, login, password);
			preparedStatement = connection.prepareStatement(SQLCommand.DELETE_BOOK_WHERE_ID);
			preparedStatement.executeUpdate();
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
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				loger.error("Error while closing Connection", e);
			}
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
	public void renameBook(String oldName, String newName) throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverManager.getConnection(url, login, password);
			preparedStatement = connection.prepareStatement(SQLCommand.RENAME_BOOK);
			preparedStatement.executeUpdate();

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
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				loger.error("Error while closing Connection", e);
			}
		}
	}

	/**
     * Counts books from the data source.
     *
     * @throws DAOException in case of some exception with the data source or connection with it.
     */
	@Override
	public int countBooks() throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = DriverManager.getConnection(url, login, password);

			preparedStatement = connection.prepareStatement(SQLCommand.COUNT_BOOKS);
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