package com.flipkart.business;

import com.flipkart.utils.Courses;

public class ProfessorBusiness {
    public static boolean selectCourses(Courses temp){
        System.out.println(" selected course"+temp.getName());
        return true;
    }
    public static boolean accessCourseStudentInfo(Courses temp){
        System.out.println("selected student info"+temp.getStudents());
        return true;
    }
}
