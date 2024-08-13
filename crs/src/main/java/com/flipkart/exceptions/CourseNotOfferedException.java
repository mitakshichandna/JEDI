package com.flipkart.exceptions;


import com.flipkart.constants.Colours;

public class CourseNotOfferedException extends Exception {

    private final String profID;
    private final String courseId;

    public CourseNotOfferedException(String string, String courseId) {
        this.profID = string;
        this.courseId = courseId;
    }

    @Override
    public String getMessage() {
        return Colours.ANSI_RED+"Course with ID: " + courseId + " not opted by professor with ID: " + profID+Colours.ANSI_RESET;
    }
}
