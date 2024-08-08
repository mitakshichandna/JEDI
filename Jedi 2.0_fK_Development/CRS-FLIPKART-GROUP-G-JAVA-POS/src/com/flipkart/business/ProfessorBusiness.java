package com.flipkart.business;

import com.flipkart.bean.Grade;
import com.flipkart.bean.Professor;
import com.flipkart.utils.Courses;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProfessorBusiness {

    public void accessAvailableCourses(List<Courses> courses) {
        for (Courses course : courses) {
            System.out.println(course.getName()+"hello");
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

    public static void removeCourse(int courseId, List<Courses> courses) {
        for (Courses course : courses) {
            if(course.getId() == courseId) {
                courses.remove(courseId);
            }
        }
    }

    public void viewCoursesUnderProfessor(Professor professor) {
        Map<Integer, String> courseMap = professor.getCourseMap();
        for(int i = 0; i< courseMap.size();i++){
            System.out.println(courseMap.get(professor.getProfessorId()));
        }
    }
}
