package com.flipkart.bean;

import com.flipkart.utils.Courses;

import java.util.HashSet;

public class Student {
    private int studentId;
    private String name;
    private String department;
    private HashSet<Integer> registeredCourses;

    public Student(int studentId, String name, String department) {
        this.studentId = studentId;
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

   public HashSet<Integer> getRegisteredCourses() {
       return registeredCourses;
   }

   public void setRegisteredCourses(HashSet<Integer> registeredCourses) {
       this.registeredCourses = registeredCourses;
   }

   public void addCourse(int courseId){
    registeredCourses.add(courseId);
   }

    public int getId() {
        return studentId;
    }

    public void setId(int studentId) {
        this.studentId = studentId;
    }
}
