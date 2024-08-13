package com.flipkart.bean;

import java.util.HashSet;

public class Professor {
    private int professorId;
    private String name;
    private String department;
    private HashSet<Integer> courseSet;
    public Professor(String userID, String name2, String contact, String email, String department2, String qualification, String password){};

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

    public HashSet<Integer> getCourseMap() {return courseSet;}

    public String getContact() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getContact'");
    }

    public String getEmail() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEmail'");
    }

    public String getPassword() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPassword'");
    }

    public String getQualification() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getQualification'");
    }
}
