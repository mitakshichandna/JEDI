package com.flipkart.exceptions;

import com.flipkart.constants.Colours;

public class IncorrectPasswordException extends RuntimeException {
    public IncorrectPasswordException() {

    }

    @Override
    public String getMessage() {
        return Colours.ANSI_RED + "Incorrect Password" + Colours.ANSI_RESET;
    }
}
