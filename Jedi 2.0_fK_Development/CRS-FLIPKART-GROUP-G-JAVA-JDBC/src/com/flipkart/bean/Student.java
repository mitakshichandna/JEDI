package com.flipkart.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author JEDI-03
 * Class to store Student information, inheriting from User
 * 
 */
public class Student extends User{

    private String branch;
    private int rollNum;
    private List<String> registeredCourses; // List of courses registered by the student
/*    private Billing billing; // Aggregated Billing object
    private ReportCard report;*/
    private boolean approved;
    /**
     * Parameterized constructor
     * @param ID: the student ID
     * @param name: the student's name
     * @param contact: the student's contact information
     * @param email: the student's email
     * @param branch: the branch of the student
     * @param rollNum: the roll number of the student
     * @param billing: the billing information of the student
     */
    public Student(String ID, String name, String contact, String email, String branch, int rollNum, boolean approved, String password) {
        super(ID, name, "Student", contact, email, password);
        this.branch = branch; 
        this.rollNum = rollNum;
        this.registeredCourses = new ArrayList<>();
        this.approved=approved;
    }

    // Getters and Setters for branch, rollNum, and billing
    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getRollNum() {
        return rollNum;
    }

    public void setRollNum(int rollNum) {
        this.rollNum = rollNum;
    }
    //@Override
    public void update() {
        // Code to update student information
    }

    //@Override
    public void changePassword(String password) {
        // Code to change student password
    	super.setPassword(password);
    }
    
    public List<String> courseList(){
    	return registeredCourses; 
    }

	public void addCourse(String courseID) {
		registeredCourses.add(courseID);
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean status) {
		this.approved = status;
	}
}
