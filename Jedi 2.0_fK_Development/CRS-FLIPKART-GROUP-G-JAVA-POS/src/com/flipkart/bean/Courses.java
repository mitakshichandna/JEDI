package com.flipkart.bean;

import java.util.List;

public class Courses {
    private String name;
    private boolean canEnroll;
    private int fees;
    private List<Student> students;
    private int profId;
    private int id;

    public Courses(int id, String name, boolean enroll, List<Student> students) {
        this.id = id;
        canEnroll = enroll;
        this.name = name;
        this.students = students;
    }

    public Courses(String name){
        this.name = name;
    }

    public Courses(){}

    public int getId(){
        return id;
    }

    public void setID(int num){
        id = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCanEnroll() {
        return canEnroll;
    }

    public void setCanEnroll(boolean canEnroll) {
        this.canEnroll = canEnroll;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

    public void setProf(int pId){
        profId = pId;
    }

    public void removeProf(int pId){
        profId = -1;
    }
    
    public int getProf(){
        return profId;
    }

    public void setId(int int1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }
}
