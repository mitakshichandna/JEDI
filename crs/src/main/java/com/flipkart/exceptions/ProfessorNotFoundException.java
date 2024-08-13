package com.flipkart.exceptions;

import com.flipkart.constants.Colours;

public class ProfessorNotFoundException extends Exception {

    private final String professorId;

    public ProfessorNotFoundException(String professorId) {
        this.professorId = professorId;
    }

    @Override
    public String getMessage() {
        return Colours.ANSI_RED+"Professor with ID: " + professorId + " not found."+Colours.ANSI_RESET;
    }
}
