package com.epam.library.dao;

/**The class stores SQL commands.*/
public final class SQLCommand {
	private SQLCommand() {}
	
	//BOOK
		public static final String ADD_BOOK = "INSERT INTO book (book_id, title, brief, publish_year, author) VALUE (?,?,?,?,?)";
		public static final String DELETE_BOOK_WHERE_ID = "DELETE FROM book WHERE book_id = ?";
		public static final String COUNT_BOOKS = "SELECT COUNT(*) FROM book";
		public static final String RENAME_BOOK = "UPDATE book SET title = ? WHERE title = ?";
			
	//EMPLOYEE
		public static final String ADD_EMPLOYEE = "INSERT INTO employee (employee_id, name, date_of_birth, email) VALUE (?,?,?,?)";
		public static final String DELETE_EMPLOYEE_WHERE_ID = "DELETE FROM employee WHERE employee_id = ?";
		public static final String GET_EMPLOYEE_WHERE_ID = "SELECT * FROM employee WHERE employee_id = ?";
		public static final String COUNT_EMPLOYEES = "SELECT COUNT(*) FROM employee";

		
	//EMPLOYEE BOOK
		public static final String INSERT_EMPLOYEE_BOOK = "INSERT INTO employee_book (employee_id, book_id) VALUE (?,?)";
		public static final String EMPLOYEES_WHO_HAVE_READ_MORE_THAN_ONE_BOOK = "SELECT COUNT(EMPLOYEE_ID) AS `NUMBER OF BOOKS`, EMPLOYEE_EMPLOYEE_ID AS `EMPLOYEE ID` "
				+ "FROM EMPLOYEE, EMPLOYEE_BOOK "
				+ "WHERE EMPLOYEE_ID = EMPLOYEE_EMPLOYEE_ID "
				+ "GROUP BY EMPLOYEE_ID HAVING `NUMBER OF BOOKS` > 1"
				+ "ORDER BY `NUMBER OF BOOKS` DESC";
				
		public static final String EMPLOYEES_WHO_HAVE_READ_MORE_THAN_OR_EQUAL_TO_TWO_BOOKS = "SELECT COUNT(EMPLOYEE_ID) AS `NUMBER OF BOOKS`, EMPLOYEE_EMPLOYEE_ID AS `EMPLOYEE ID` "
				+ "FROM EMPLOYEE, EMPLOYEE_BOOK "
				+ "WHERE EMPLOYEE_ID = EMPLOYEE_EMPLOYEE_ID "
				+ "GROUP BY EMPLOYEE_ID HAVING `NUMBER OF BOOKS` >= 2"
				+ "ORDER BY DATE_OF_BIRTH DESC, `NUMBER OF BOOKS` DESC";
		
		
}
