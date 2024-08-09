package com.flipkart.bean;

public class RegisteredCourses {
    private String courseCode;
    private String grade;
    private int semester;
    private int studentId;

    public String viewGrade() {
        return "ppp";
    }

    public boolean dropCourse() {
        return true;
    }
}