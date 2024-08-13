package com.flipkart.exceptions;


import com.flipkart.constants.Colours;

public class CourseNotAvailableException extends Exception {

    private final String courseId;

    public CourseNotAvailableException(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public String getMessage() {
        return Colours.ANSI_RED+"Course with ID: " + courseId + " is not available."+Colours.ANSI_RESET;
    }
}
