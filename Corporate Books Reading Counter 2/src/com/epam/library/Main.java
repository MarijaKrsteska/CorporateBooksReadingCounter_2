package com.epam.library;
import java.text.ParseException;

import com.epam.library.controller.Controller;

/**
 * 
 */
public class Main {
    public static void main(String[] args) throws ParseException {
        Controller controller = new Controller();
        System.out.println(controller.executeTask("READ_MORE_THEN_ONE_BOOK "));
        System.out.println();
        System.out.println(controller.executeTask("READ_TWO_OR_MORE_BOOKS "));
        System.out.println();
        System.out.println(controller.executeTask("RENAME_BOOK, Tartuffe, Tartufe"));
        System.out.println();
        System.out.println(controller.executeTask("DELETE_BOOK 3"));
        System.out.println();
        System.out.println(controller.executeTask("ADD_BOOK, 27, Harry Potter, null, 1997, J. K. Rowling"));
        System.out.println();
        System.out.println(controller.executeTask("COUNT_BOOKS"));
        System.out.println();
        System.out.println(controller.executeTask("COUNT_EMPLOYEES"));
    }
}
