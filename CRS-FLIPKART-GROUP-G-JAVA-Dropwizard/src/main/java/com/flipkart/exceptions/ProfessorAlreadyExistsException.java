package com.flipkart.exceptions;

import com.flipkart.constants.Colours;

public class ProfessorAlreadyExistsException extends Exception {

    private final String professorId;

    public ProfessorAlreadyExistsException(String professorId) {
        this.professorId = professorId;
    }

    @Override
    public String getMessage() {
        return Colours.ANSI_RED+"Professor with ID: " + professorId + " already exists."+Colours.ANSI_RESET;
    }
}
