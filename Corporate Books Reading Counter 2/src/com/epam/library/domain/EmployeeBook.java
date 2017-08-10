package com.epam.library.domain;
import java.io.Serializable;

/**
 * Created by Marija.
 */
public class EmployeeBook implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int bookID;
	private int employeeID;
	
	public EmployeeBook() {}

	public EmployeeBook(int bookID, int employeeID) {
		this.bookID = bookID;
		this.employeeID = employeeID;
	}

	public int getBookID() {
		return bookID;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookID;
		result = prime * result + employeeID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
}