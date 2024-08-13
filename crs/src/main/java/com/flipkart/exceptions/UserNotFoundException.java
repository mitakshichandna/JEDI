package com.flipkart.exceptions;

import com.flipkart.constants.Colours;

public class UserNotFoundException extends Exception{
    
    private final String userId;

    public UserNotFoundException(String id) {
        userId = id;
    }

    @Override
    public String getMessage() {
        return Colours.ANSI_RED+"User with userId: " + userId + " not found."+Colours.ANSI_RESET;
    }
}
