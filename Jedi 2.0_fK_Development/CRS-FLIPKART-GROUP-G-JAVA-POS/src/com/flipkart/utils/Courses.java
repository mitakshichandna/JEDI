package com.flipkart.utils;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.business.StudentBusiness;

import java.util.List;

public class Courses {
    private String name;
    private boolean canEnroll;
    private int fees;
    private List<Student> students;
    private Professor prof;
    private int id;

    public int getId(){
        return id;
    }

    public void setID(int num){
        id = num;
    }

    public Courses(String code, boolean b, int i, List<StudentBusiness> students) {
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

    public void setProf(Professor p){
        prof = p;
    }
    
    public Professor getProf(){
        return prof;
    }
}
