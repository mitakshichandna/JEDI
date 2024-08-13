package com.flipkart.exceptions;


import com.flipkart.constants.Colours;

public class CourseNotFoundException extends Exception {

    private final String courseId;

    public CourseNotFoundException(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public String getMessage() {
        return Colours.ANSI_RED+"Course with ID: " + courseId + " not found."+Colours.ANSI_RESET;
    }
}
