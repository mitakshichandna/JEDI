package com.flipkart.exceptions;


import com.flipkart.constants.Colours;

public class CourseNotOptedException extends Exception {

    private final String studentId;
    private final String courseId;

    public CourseNotOptedException(String studentId, String courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    @Override
    public String getMessage() {
        return Colours.ANSI_RED+"Course with ID: " + courseId + " not opted by student with ID: " + studentId + Colours.ANSI_RESET;
    }
}
