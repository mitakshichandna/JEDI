package com.flipkart.exceptions;


import com.flipkart.constants.Colours;

import java.awt.*;

public class CourseAlreadyExistsException extends Exception {

    private final String courseId;

    public CourseAlreadyExistsException(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public String getMessage() {
        return Colours.ANSI_RED+ "Course with ID: " + courseId + " already exists."+Colours.ANSI_RESET;
    }
}
