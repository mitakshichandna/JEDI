package com.flipkart.business;

import java.util.Set;

import com.flipkart.bean.*;
import com.flipkart.dao.AdminDao;
import com.flipkart.exceptions.CourseAlreadyExistsException;
import com.flipkart.exceptions.CourseNotFoundException;
import com.flipkart.exceptions.UserAlreadyExistsException;
import com.flipkart.exceptions.UserNotFoundException;
import com.flipkart.dao.AdminDaoInterface;

public class AdminBusiness implements AdminInterface{
	AdminDaoInterface adi=new AdminDao();

	/**
	 * Method to add a professor
	 * @param prof: the professor to add
	 */
    public String addProf(Professor prof, String username) {
		String userID;
		try {
			userID = adi.addProf(prof, username);
			if(!userID.isEmpty())return "Professor Added with id: "+userID;
		} catch (UserAlreadyExistsException e) {
			System.out.println(e.getMessage());
		}
    		return "Operation Failed...";
    		//userInstance.makeNew(username,(User)prof);
    }

    /**
     * Method to remove a professor
     * @param profID: the ID of the professor to remove
     * @return true if professor was removed successfully, false otherwise
     */
    public String removeProf(String profID) {
    	//prof.setRole("user");
    	try {
			if(adi.removeProf(profID))return "Professor removed successfully";
		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		}
    	return "Operation Failed..."; // Professor ID not found
    }

    /**
     * Method to update a course
     * @param courseID: the code of the course to update
     * @param updatedCourse: the updated course details
     * @return true if course was updated successfully, false otherwise
     */
    public String updateCourse(String courseID, Course updatedCourse) {
    	try {
			if(adi.updateCourse(courseID, updatedCourse))return "Course information updated successfully";
		} catch (CourseAlreadyExistsException | CourseNotFoundException e) {
			System.out.println(e.getMessage());
		}
    	return "Operation Failed...";
    }

    /**
     * Method to add a course
     * @param course: the course to add
     */
    public String addCourse(Course course) {
    	//
    	//catalog.addCourse(course);
    	try {
			if(adi.addCourse(course))return "Course added Successfully";
		} catch (CourseAlreadyExistsException e) {
			System.out.println(e.getMessage());
		}
    	return "Operation Failed...";
    }

    /**
     * Method to remove a course
     * @param courseID: the code of the course to remove
     * @return true if course was removed successfully, false otherwise
     */
    public String removeCourse(String courseID) {
        //return catalog.removeCourse(courseCode);
    	try {
			if(adi.removeCourse(courseID))return "Course removed Successfully";
		} catch (CourseNotFoundException e) {
			System.out.println(e.getMessage());
		}
    	return "Operation Failed...";
    }

    /**
     * Method to register a student
     * @param studentID: the student to register
     */
    public String registerStudent(String studentID) {
    	try {
			if(adi.registerStudent(studentID))return "Student approved";
		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		}
    	return "Operation Failed...";
    	//student.setApproved(true);
    }

	@Override
	public String viewCourses() {
		Set<Course> courses = adi.viewCourses();
        StringBuilder catalog = new StringBuilder();
		catalog.append("ID  \t\t").append("Name\t\t").append("Prof Assigned\t").append("Seats Left\n");
        courses.forEach(course -> {
            String prof = course.getCourseProf();
            if (prof == null) prof = "Prof Awaited";
            catalog.append(course.getCourseID()).append("\t\t")
                   .append(course.getCourseName()).append("\t\t")
                   .append(prof).append("\t\t")
                   .append(course.getSeats()).append("\n");
        });
        return catalog.toString().trim();
	}

	@Override
	public String viewProfessors() {
		// TODO Auto-generated method stub
		Set<Professor> profs = adi.viewProfessors();
		StringBuilder catalog = new StringBuilder();
		profs.forEach(prof ->
				catalog.append(prof.getName()).append("\t\t")
						.append(prof.getID()).append("\t\t")
						.append(prof.getDept()).append("\n")
		);
		return catalog.toString().trim();
	}

	@Override
	public String viewUnapprovedStudents() {
		// TODO Auto-generated method stub
		Set<Student> studentList = adi.viewUnapprovedStudents();
        StringBuilder students = new StringBuilder();
        studentList.forEach(student -> 
            students.append(student.getID()).append("\t\t")
                    .append(student.getName()).append("\t\t")
                    .append(student.getRollNum()).append("\n")
        );
        return students.toString().trim();
	}
}