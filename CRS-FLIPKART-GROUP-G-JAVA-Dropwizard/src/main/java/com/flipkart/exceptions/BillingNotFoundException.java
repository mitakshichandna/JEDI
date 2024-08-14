package com.flipkart.exceptions;

import com.flipkart.constants.Colours;

public class BillingNotFoundException extends Exception{
	private final String studentID;

    public BillingNotFoundException(String string) {
        this.studentID = string;
    }

    @Override
    public String getMessage() {
        return Colours.ANSI_RED + "Billing ID for student " + studentID + " not found." + Colours.ANSI_RESET;
    }
}
