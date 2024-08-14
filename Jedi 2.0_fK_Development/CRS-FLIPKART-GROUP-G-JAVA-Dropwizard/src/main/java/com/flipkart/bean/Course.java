package com.flipkart.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.Set;

public class Course {

	private String courseID;
	private String courseName;
	String courseProf;
	private int seats;
	String semesterID;
	private Set<String> enrolledStudents; // To keep track of enrolled students
	float price;
	/**
	 * Default Constructor
	 */
	public Course() {
		this.enrolledStudents = new HashSet<>();
	}
	
	/**
	 * Parameterized constructor
	 * @param courseID: course ID
	 * @param courseName: course name
	 * @param courseProf: professor user id
	 * @param seats: seats available 
	 */
	public Course(String courseID, String courseName, String courseProf, int seats) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.courseProf = courseProf;
		this.seats = seats;
		this.enrolledStudents = new HashSet<>();
		this.semesterID=null;
		this.price=0;
	}
	
	public Course(@JsonProperty("id")String courseID, @JsonProperty("name")String courseName,
				  @JsonProperty("prof")String courseProf,
				  @JsonProperty("seats")int seats, @JsonProperty("price")float price) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.courseProf = courseProf;
		this.seats = seats;
		this.enrolledStudents = new HashSet<>();
		this.semesterID=null;
		this.price=price;
	}
	
	/**
	 * Method to get Course ID
	 * @return Course ID
	 */
	@JsonProperty("id")
	public String getCourseID() {
		return courseID;
	}
	
	/**
	 * Method to set Course ID
	 * @param courseID
	 */
	@JsonProperty("id")
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	
	/**
	 * Method to get Course Name
	 * @return Course Name
	 */
	@JsonProperty("name")
	public String getCourseName() {
		return courseName;
	}
	
	/**
	 * Method to set Course Name
	 * @param courseName
	 */
	@JsonProperty("name")
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * Method to get available seats
	 * @return Seats available
	 */
	@JsonProperty("seats")
	public int getSeats() {
		return seats;
	}
	
	/**
	 * Method to set available seats
	 * @param seats
	 */
	@JsonProperty("seats")
	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	/**
	 * Method to get Professor ID of the professor teaching the course
	 * @return Professor ID
	 */
	@JsonProperty("prof")
	public String getCourseProf() {
		return courseProf;
	}
	
	/**
	 * Method to set Professor ID of the professor teaching the course
	 * @param courseProf
	 */
	@JsonProperty("prof")
	public void setCourseProf(String courseProf) {
		this.courseProf = courseProf;
	}
	
	public boolean isCourseFull() {
		return enrolledStudents.size() >= seats;
	}
	
	public String getSemesterID() {
		return this.semesterID;
	}
	
	public void setSemesterID(String semesterID) {
		this.semesterID=semesterID;
	}
	
	/**
	 * Method to add a student to the course
	 * @param student: the student to be added
	 * @return true if the student was added successfully, false if the course is full
	 */
	public boolean addStudent(String studentID) {
		if (!isCourseFull()) {
			return enrolledStudents.add(studentID);
		}
		return false; // Course is full
	}

	@JsonProperty("price")
	public void setPrice(float price) {
		this.price=price;
	}

	@JsonProperty("price")
	public float getPrice() {
		return this.price;
	}
	
	public Set<String> getStudents(){
		return enrolledStudents;
	}
}
