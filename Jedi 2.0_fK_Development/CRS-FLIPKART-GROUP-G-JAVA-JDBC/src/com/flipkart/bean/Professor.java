package com.flipkart.bean;

import java.util.HashSet;

public class Professor {
    private int professorId;
    private String name;
    private String department;
    private HashSet<String> courseSet;
    public Professor(){};

    public int getId() {
        return professorId;
    }

    public void setId(int professorId) {
        this.professorId = professorId;
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

    public void addCourse(int courseId) {
        this.courseSet.add(courseId);
    }

    public void removeCourse(int courseId){
        this.courseSet.remove(courseId);
    }

    public HashSet<String> getCoursesOffered() {return courseSet;}
}
