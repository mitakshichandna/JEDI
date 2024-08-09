package com.flipkart.bean;

import java.util.List;
import java.util.Map;

public class Professor {
    private int professorId;
    private String name;
    private String department;
    private List<String> courseMap;

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

    public void setCourseMap(List<String> courseMap) {
        this.courseMap = courseMap;
    }

    public List<String> getCourseMap() {return courseMap;}
}
