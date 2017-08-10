package com.epam.library.domain;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Marija.
 */
public class Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int employeeID;
	private String name;
	private Date dateOfBirth;
	private String email;
		
	public Employee() {}

	public Employee(int employeeID, String name, Date dateOfBirth, String email) {
		this.employeeID = employeeID;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
	}

	public Employee(String name, Date dateOfBirth) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;	}

	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");		
		return "Employee [employeeID=" + employeeID + ", name=" + name + ", dateOfBirth=" + formatter.format(dateOfBirth) + ", email=" + email + "]";
	}

	public int getEmployeeID() {
		return employeeID;
	}
	public String getName() {
		return name;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public String getEmail() {
		return email;
	}
	
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + employeeID;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	//ignore employeeID when comparing two employees
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}