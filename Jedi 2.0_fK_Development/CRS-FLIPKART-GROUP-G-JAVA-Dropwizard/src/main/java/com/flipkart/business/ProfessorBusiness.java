package com.flipkart.business;

import com.flipkart.bean.*;
import com.flipkart.dao.ProfDaoInterface;
import com.flipkart.dao.ProfDao;
import com.flipkart.exceptions.CourseNotAvailableException;
import com.flipkart.exceptions.CourseNotOfferedException;
import com.flipkart.exceptions.CourseNotOptedException;
import com.flipkart.exceptions.GradeAlreadyAddedException;

import java.util.Set;


public class ProfessorBusiness implements ProfessorInterface{
	ProfDaoInterface pdi = new ProfDao();
    /**
     * Method to offer a course
     * @param course: the course to be offered
     */
    public String offerCourse(String courseID, Professor prof) {
        try {
			if(pdi.offerCourse(courseID, prof))return "Course enrolled successfully";
		} catch (CourseNotAvailableException e) {
            System.out.println(e.getMessage());
		}
        return "Enrollment failed...";
        //
    }

    /**
     * Method to get the registered students for a given course
     * @param course: the course for which to get the registered students
     * @return set of registered students
     */
    public String getStudents(String courseID, Professor prof) {
    	//return prof.getRegisteredStudents(courseID);
    	Set<Student> studentList = pdi.getStudents(courseID, prof);
        StringBuilder students = new StringBuilder();
        students.append("ID  \t").append("Name\t").append("Roll number");
        studentList.forEach(student -> 
            students.append(student.getID()).append("\t\t")
                    .append(student.getName()).append("\t\t")
                    .append(student.getRollNum()).append("\n")
        );
        return students.toString().trim(); 
    }

    /**
     * Method to give a grade to a student in a course
     * @param course: the course in which the grade is to be given
     * @param student: the student to whom the grade is to be given
     * @param grade: the grade to be given
     * @return true if grade was successfully assigned, false otherwise
     */
    public String giveGrade(String courseID, String studentID, String grade, Professor prof) {
         // Student is not registered for the course
    	//Set<Student> studentList=prof.getRegisteredStudents(courseID);
    	
    	/*for(Student stu:studentList) {
    		if(stu.getID().equals(studentID)) {
    			stu.updateGrade(courseID, grade);
    			return true;
    		}
    	}*/
    	try {
			if(pdi.giveGrade(courseID, studentID, grade, prof))return "Grade submitted successfully";
		} catch (CourseNotOptedException | GradeAlreadyAddedException | CourseNotOfferedException e) {
            System.out.println(e.getMessage());
		}
        return "Grade submission failed...";
    }
    
    @Override
	public String viewCourses() {
    	Set<Course> courses = pdi.viewCourses();
        StringBuilder catalog = new StringBuilder();
        catalog.append("ID \t").append("Name\t").append("Professor").append("Seats Left");
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
	public String viewCourseOffering(Professor prof) {
		Set<Course> courses = pdi.viewCourseOffering(prof);
        StringBuilder catalog = new StringBuilder();
        courses.forEach(course -> 
            catalog.append(course.getCourseID()).append("\t")
                   .append(course.getCourseName()).append("\n")
        );
        return catalog.toString().trim();
	}
}
