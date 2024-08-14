package com.flipkart.business;

import com.flipkart.bean.Courses;
import com.flipkart.bean.Student;
import com.flipkart.dao.Database;

import java.util.ArrayList;
import java.util.List;

public class StudentBusiness {
    public StudentBusiness(int i, String dummy1, String depart1) {

    }
    private static List<Courses> coursesList = new ArrayList<Courses>();
    public static boolean registerCourse(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"dummy1","depart1"));
        Courses c1=new Courses(Database.getCourseId(), "CODE", true, students);;
        c1.setName("Course 1");
        System.out.println(" registered in "+c1.getName());
        return true;
    }
    public static boolean addCourse(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"dummy1","depart1"));
        Courses c1=new Courses(Database.getCourseId(), "CODE", true, students);;
        c1.setName("Course 1");
        c1.setFees(100);
        c1.setID(1);
        c1.setCanEnroll(true);
        coursesList.add(c1);
        System.out.println("added course with name as "+c1.getName());
        return true;
    }
    public static boolean dropCourse(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"dummy1","depart1"));
        Courses c1=new Courses(Database.getCourseId(), "CODE", true, students);;
        coursesList.remove(0);
        System.out.println("dropped course so now size of courseList is "+coursesList.size());
        return true;
    }
    public static boolean checkGrades(){
        System.out.println("access to check gardes");
        return true;
    }
    public static boolean payFee(){
        List<Courses>temp=new ArrayList<>();
        temp.addAll(coursesList);
        if(temp.size()==0){
            System.out.println("please add course first");
            return false;
        }
        System.out.println("paid fees for course"+temp.get(0).getName()+"which is "+temp.get(0).getFees());
        return true;
    }
}
