package com.flipkart.utils;

import com.flipkart.bean.Student;

import java.util.List;

public class Courses {
    private String name;
    private boolean canEnroll;
    private int fees;
    private List<Student> students;

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
}
