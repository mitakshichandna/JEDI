package com.flipkart.constants;

public class Queries{
    public static final String DELETE_COURSE = "delete from Course where courseId = ?";
    public static final String ADD_COURSE = "insert into Course(courseId, courseName) values (?, ?)";
	public static final String REGISTER_STUDENT = "update Student set isRegistered = 1 where studentId = ?";
	public static final String STUDENT_COURSES = "select courseId from StudentCourses where studentId = ?";
	public static final String ASSIGN_COURSE = "update Course set professorId = ? where courseId = ?";
	public static final String VIEW_COURSE = "select courseId, courseName, professorId from Course";
	public static final String LIST_REGISTERED_STUDENTS = "select studentId, name from Student where isRegistered = 0";
    public static final String LIST_UNREGISTERED_STUDENTS = "select studentId, name from Student where isRegistered = 1";
}
