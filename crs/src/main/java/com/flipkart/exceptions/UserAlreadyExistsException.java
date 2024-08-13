package com.flipkart.exceptions;

import com.flipkart.constants.Colours;

public class UserAlreadyExistsException extends Exception {

    private final String userId;

    public UserAlreadyExistsException(String userId) {
        this.userId = userId;
    }

    @Override
    public String getMessage() {
        return Colours.ANSI_RED+"User with userID/username: " + userId + " already exists."+Colours.ANSI_RESET;
    }
}
