package com.epam.library.service.factory;

import com.epam.library.service.LibraryService;
import com.epam.library.service.impl.LibraryServiceImpl;

/**
 * Provides a logic of instancing Service objects.
 */
public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

	/**
	 * Gives {@link ServiceFactory} instance
	 * @return ServiceFactory
     */
    public static ServiceFactory getInstance() {
        return instance;
    }

    private final LibraryService libraryService = new LibraryServiceImpl();

    private ServiceFactory() {}

	/**
	 * Gives {@link LibraryService} implementation
	 * @return LibraryService implementation
     */
    public LibraryService getLibraryService() {
        return libraryService;
    }

}
