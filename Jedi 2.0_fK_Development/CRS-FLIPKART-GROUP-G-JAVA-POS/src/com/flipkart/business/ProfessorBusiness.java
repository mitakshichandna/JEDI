package com.flipkart.business;

import com.flipkart.bean.Grade;
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
    public static void accessCourseInfo(Courses temp){
        System.out.println("Info of course"+temp.getName());

    }
    public static void viewGrades(Grade temp){
        System.out.println("view grades");
        System.out.println(temp.printGrade());
    }
}
