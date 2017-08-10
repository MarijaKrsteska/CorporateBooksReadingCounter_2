package com.epam.library.dao;

import com.epam.library.dao.exception.DAOException;
import com.epam.library.domain.Book;

/**
 * Provides a DAO-logic for the {@link Book} entity.
 */
public interface BookDAO {
	/**
	 * Adds a new book into the data source.
	 *
	 * @param book a Book object for insertion.
	 * @throws DAOException in case of some exception with the data source or connection with it
	 */
	public void addBook(Book book) throws DAOException;

	/**
     * Deletes a book from the data source by bookID.
     *
     * @param bookID the ID of deleting book.
     * @throws DAOException in case of some exception with the data source or connection with it.
     */
	public void deleteBook(int bookID) throws DAOException;

	/**
     * Renames a book in the data source.
     *
     * @param oldName the old Title of the book.
     * @param newName the new Title of the book.
     * @throws DAOException in case of some exception with the data source or connection with it.
     */
	public void renameBook(String oldName, String newName) throws DAOException;
	
	/**
     * Counts books from the data source.
     *
     * @throws DAOException in case of some exception with the data source or connection with it.
     */
	public int countBooks() throws DAOException;
}
