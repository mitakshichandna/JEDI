package com.flipkart.exceptions;


import com.flipkart.constants.Colours;

public class CourseAlreadyOptedException extends Exception {

    private final String studentId;
    private final String courseId;

    public CourseAlreadyOptedException(String string, String courseId) {
        this.studentId = string;
        this.courseId = courseId;
    }

    @Override
    public String getMessage() {
        return Colours.ANSI_RED+"Course with ID: " + courseId + " already opted by student with ID: " + studentId + Colours.ANSI_RESET;
    }
}
