package com.flipkart.exceptions;



public class CourseAlreadyOptedException extends Exception {

    private String studentId;
    private String courseId;

    public CourseAlreadyOptedException(String string, String courseId) {
        this.studentId = string+"";
        this.courseId = courseId;
    }

    @Override
    public String getMessage() {
        return "Course with ID: " + courseId + " already opted by student with ID: " + studentId;
    }
}
