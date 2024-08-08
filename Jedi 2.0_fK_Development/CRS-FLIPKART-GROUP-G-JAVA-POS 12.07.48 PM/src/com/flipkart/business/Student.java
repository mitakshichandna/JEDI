package com.flipkart.business;

import com.flipkart.utils.Courses;

public class Student {
    public static boolean registerCourse(Courses temp){
        System.out.println(" registered"+temp);
        return true;
    }
    public static boolean addCourse(Courses temp){
        System.out.println("added"+temp.getName());
        return true;
    }
    public static boolean dropCourse(Courses temp){
        System.out.println("dropped"+temp.getName());
        return true;
    }
    public static boolean checkGrades(){
        System.out.println("access to check gardes");
        return true;
    }
    public static boolean payFee(Courses temp){
        System.out.println("paid fees for course"+temp.getName()+"which is"+temp.getFees());
        return true;
    }
}
