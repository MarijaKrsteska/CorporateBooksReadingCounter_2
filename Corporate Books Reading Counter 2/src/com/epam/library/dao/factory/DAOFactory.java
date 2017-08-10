package com.epam.library.dao.factory;
import com.epam.library.dao.BookDAO;
import com.epam.library.dao.EmployeeBookDAO;
import com.epam.library.dao.EmployeeDAO;
import com.epam.library.dao.impl.BookDAOImpl;
import com.epam.library.dao.impl.EmployeeBookDAOImpl;
import com.epam.library.dao.impl.EmployeeDAOImpl;
import org.apache.log4j.Logger;

/**
 * Provides a logic of instancing DAO objects.
 */
public class DAOFactory {
    private static final Logger loger = Logger.getLogger(DAOFactory.class);

    private static final String DRIVER = "org.gjt.mm.mysql.Driver";
    private static final DAOFactory instance = new DAOFactory();

    private final BookDAO bookDAO = new BookDAOImpl();
    private final EmployeeDAO employeeDAO = new EmployeeDAOImpl();
    private final EmployeeBookDAO employeeBookDAO = new EmployeeBookDAOImpl();

    private DAOFactory() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            loger.error("Error while loading driver", e);
        }
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public BookDAO getBookDAO() {
    	return bookDAO;
    }

	public EmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}

	public EmployeeBookDAO getEmployeeBookDAO() {
		return employeeBookDAO;
	}
}
