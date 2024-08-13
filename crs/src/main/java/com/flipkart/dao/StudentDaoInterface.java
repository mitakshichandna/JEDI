package com.flipkart.dao;

import java.util.List;
import java.util.Set;

import com.flipkart.bean.Billing;
import com.flipkart.bean.Course;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;
import com.flipkart.exceptions.BillingNotFoundException;
import com.flipkart.exceptions.CourseAlreadyOptedException;
import com.flipkart.exceptions.CourseNotAvailableException;
import com.flipkart.exceptions.CourseNotFoundException;

public interface StudentDaoInterface {

    /**
     * Registers a student for a course.
     * @param student The `Student` object representing the student registering for the course.
     * @param coursesID The ID of the course to be registered for.
     * @return The total cost for the registered course.
     * @throws CourseAlreadyOptedException If the student has already opted for the course.
     * @throws CourseNotAvailableException If the course is not available.
     * @throws CourseNotFoundException If the course with the specified ID is not found.
     */
    float register(Student student, String coursesID)
        throws CourseAlreadyOptedException, CourseNotAvailableException, CourseNotFoundException;

    /**
     * Retrieves the list of courses a student is currently enrolled in.
     * @param student The `Student` object representing the student whose courses are to be retrieved.
     * @return A `List<Course>` containing the courses the student is currently enrolled in.
     */
    List<Course> viewCoursesEnrolled(Student student);

    /**
     * Retrieves the list of all available courses.
     * @return A `Set<Course>` containing all the available courses.
     */
    Set<Course> viewCourses();

    /**
     * Retrieves the report card for a specific student.
     * @param student The `Student` object representing the student whose report card is to be retrieved.
     * @return A `ReportCard` object containing the student's academic report.
     */
    ReportCard getReport(Student student);

    /**
     * Retrieves billing information for a specific student.
     * @param student The `Student` object representing the student whose billing information is to be retrieved.
     * @return A `Billing` object containing the billing information.
     * @throws BillingNotFoundException If the billing information for the student is not found.
     */
    Billing getBillingInfo(Student student) throws BillingNotFoundException;

    /**
     * Updates the billing information for a specific student.
     * @param billing The `Billing` object containing the updated billing information.
     * @return `true` if the billing information was successfully updated; `false` otherwise.
     */
    boolean updateBillingInfo(Billing billing);
}