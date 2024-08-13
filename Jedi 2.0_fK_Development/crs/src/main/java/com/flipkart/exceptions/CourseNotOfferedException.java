package com.flipkart.exceptions;



public class CourseNotOfferedException extends Exception {

    private String profID;
    private String courseId;

    public CourseNotOfferedException(String string, String courseId) {
        this.profID = string+"";
        this.courseId = courseId;
    }

    @Override
    public String getMessage() {
        return "Course with ID: " + courseId + " not opted by professor with ID: " + profID;
    }
}
