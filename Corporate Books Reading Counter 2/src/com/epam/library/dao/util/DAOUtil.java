package com.epam.library.dao.util;

import java.util.ResourceBundle;

public class DAOUtil {

	private static final String FILE_NAME = "resource/database";
	private static final ResourceBundle bundle = ResourceBundle.getBundle(FILE_NAME);

	public static String getParametar(String key) {
		return bundle.getString(key);
	}
	
	public static void main(String[] args) {
		String driver = DAOUtil.getParametar("db.DRIVER");
		System.out.println(driver);
	}
}
