package com.flipkart.exceptions;


import com.flipkart.constants.Colours;

public class ReportCardNotGeneratedException extends Exception {

    private final String studentId;

    public ReportCardNotGeneratedException(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String getMessage() {
        return Colours.ANSI_RED+"Report card not generated for student with ID: " + studentId+ Colours.ANSI_RESET;
    }
}
