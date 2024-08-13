package com.flipkart.business;

import java.util.Set;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

public interface ProfessorInterface {

    /**
     * Allows a professor to offer a course.
     * @param courseID The ID of the course being offered.
     * @param prof The `Prof` object representing the professor offering the course.
     * @return A `String` message indicating the result of the operation (e.g., success or failure).
     */
    public String offerCourse(String courseID, Professor prof);

    /**
     * Retrieves a list of students registered for a specific course.
     * @param courseID The ID of the course whose students are to be retrieved.
     * @param prof The `Prof` object representing the professor requesting the student list.
     * @return A `String` representation of the list of students registered for the course.
     */
    public String getStudents(String courseID, Professor prof);

    /**
     * Submits a grade for a student in a specific course.
     * @param courseID The ID of the course for which the grade is being submitted.
     * @param studentID The ID of the student receiving the grade.
     * @param grade The grade being assigned to the student.
     * @param prof The `Prof` object representing the professor submitting the grade.
     * @return A `String` message indicating the result of the operation (e.g., success or failure).
     */
    public String giveGrade(String courseID, String studentID, String grade, Professor prof);

    /**
     * Retrieves a list of all available courses.
     * @return A `String` representation of the list of available courses.
     */
    public String viewCourses();

    /**
     * Retrieves a list of courses currently being offered by a specific professor.
     * @param prof The `Prof` object representing the professor whose course offerings are to be retrieved.
     * @return A `String` representation of the list of courses being offered by the professor.
     */
    public String viewCourseOffering(Professor prof);
}
