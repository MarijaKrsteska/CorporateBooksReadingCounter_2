package com.epam.library.controller.command;

import java.text.ParseException;

/**
 * Executes an exact request.
 */
public interface Command {
    public String execute(String request) throws ParseException;
}