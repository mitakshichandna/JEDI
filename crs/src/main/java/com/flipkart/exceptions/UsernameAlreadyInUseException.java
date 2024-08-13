package com.flipkart.exceptions;

import com.flipkart.constants.Colours;

public class UsernameAlreadyInUseException extends Exception {

    private final String username;

    public UsernameAlreadyInUseException(String username) {
        this.username = username;
    }

    @Override
    public String getMessage() {
        return Colours.ANSI_RED+"Username: " + username + " is already taken by another user"+ Colours.ANSI_RESET;
    }
}
