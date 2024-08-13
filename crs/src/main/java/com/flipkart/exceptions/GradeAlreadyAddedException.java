package com.flipkart.exceptions;


import com.flipkart.constants.Colours;

public class GradeAlreadyAddedException extends Exception {

    private final String studentId;
    private final String courseId;

    public GradeAlreadyAddedException(String studentId, String courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    @Override
    public String getMessage() {
        return Colours.ANSI_RED+"Grade already added for student with ID: " + studentId + " in course with ID: " + courseId+Colours.ANSI_RESET;
    }
}
