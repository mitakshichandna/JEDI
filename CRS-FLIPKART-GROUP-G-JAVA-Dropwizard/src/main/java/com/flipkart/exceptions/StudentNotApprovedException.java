package com.flipkart.exceptions;

import com.flipkart.constants.Colours;

public class StudentNotApprovedException extends Exception{
private final String studentId;
	
	public StudentNotApprovedException(String id) {
		studentId = id;
	}
	
	/**
	 * Getter function for studentId
	 * @return studentId as String
	 */
	public String getStudentId() {
		return studentId;
	}
	

	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return Colours.ANSI_RED+"StudentId: " + studentId + "has not been approved!"+Colours.ANSI_RESET;
	}
}
