package com.flipkart.business;

import com.flipkart.bean.Grade;
import com.flipkart.bean.Professor;
import com.flipkart.dao.Database;
import com.flipkart.utils.Courses;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProfessorBusiness {

    public void accessAvailableCourses(List<Courses> courses) {
        for (Courses course : courses) {
            System.out.println(course.getName());
        }
    }

    public static boolean selectCourses(Courses temp) {
        System.out.println("Selected course: " + temp.getName());
        return true;
    }

    public static boolean accessCourseStudentInfo(Courses temp) {
        System.out.println("Selected student info: " + temp.getStudents());
        return true;
    }

    public static void accessCourseInfo(Courses temp) {
        System.out.println("Info of course: " + temp.getName());
    }

    public static void viewGrades(Grade temp) {
        System.out.println("Viewing grades");
        System.out.println(temp.getGrade());
    }

    public static void removeCourse(String courseName, Professor professor) {
        int courseId = Database.getCourseId(courseName);
        boolean status = professor.getCourseMap().remove(courseId);
        if(!status){
            System.out.println("Course not assigned to prof");
        }
    }

    public void viewCoursesUnderProfessor(Professor professor) {
       HashSet<String> courses = professor.getCoursesOffered;

        if(courses.size() == 0){
            System.out.println("No courses under professor");
        }
        else {
            for (String course :courses) {
                System.out.println(course);
            }
        }
    }
}
