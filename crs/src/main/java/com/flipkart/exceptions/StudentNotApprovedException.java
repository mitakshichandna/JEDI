package com.flipkart.exceptions;

public class StudentNotApprovedException extends Exception{
private String studentId;
	
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
		return "StudentId: " + studentId + "has not been approved!";
	}
}
