package com.flipkart.bean;

import java.util.Map;

public class Professor {
    private int professorId;
    private String name;
    private String department;
    private Map<Integer,String> courseMap;

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

    public void setCourseMap(int courseId, String courseName) {
        this.courseMap.put(courseId, courseName);
    }

    public Map<Integer,String> getCourseMap() {return courseMap;}
}
