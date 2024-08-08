package com.flipkart.bean;

import com.flipkart.utils.Courses;

import java.util.List;

public class Student {
    private int studentId;
    private String name;
    private String department;
    private List<Courses> registeredCourses;

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

    public List<Courses> getRegisteredCourses() {
        return registeredCourses;
    }

    public void setRegisteredCourses(List<Courses> registeredCourses) {
        this.registeredCourses = registeredCourses;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
