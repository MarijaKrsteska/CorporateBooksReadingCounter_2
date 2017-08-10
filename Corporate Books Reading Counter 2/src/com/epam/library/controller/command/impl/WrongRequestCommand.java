package com.epam.library.controller.command.impl;

import com.epam.library.controller.command.Command;

/**
 * Wrong command.
 */
public class WrongRequestCommand implements Command {
    public static final String WRONG_COMMAND = "Wrong command, try again";

    @Override
    public String execute(String request) {
        return WRONG_COMMAND;
    }
}