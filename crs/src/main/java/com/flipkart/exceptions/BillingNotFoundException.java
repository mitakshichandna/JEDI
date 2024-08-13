package com.flipkart.exceptions;

public class BillingNotFoundException extends Exception{
	private String studentID;

    public BillingNotFoundException(String string) {
        this.studentID = string+"";
    }

    @Override
    public String getMessage() {
        return "Biiling ID for student " + studentID + " not found.";
    }
}
