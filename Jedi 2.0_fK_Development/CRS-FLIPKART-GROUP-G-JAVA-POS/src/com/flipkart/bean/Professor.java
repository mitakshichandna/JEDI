package com.flipkart.bean;

import java.util.List;
import java.util.Map;

import com.flipkart.utils.Courses;

public class Professor {
    private int professorId;
    private String name;
    private String department;
    private List<Integer> courseMap;

    public Professor(){};

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
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

    public void addCourseMap(int courseId) {
        this.courseMap.add(courseId);
    }

    public List<Integer> getCourseMap() {return courseMap;}
}
