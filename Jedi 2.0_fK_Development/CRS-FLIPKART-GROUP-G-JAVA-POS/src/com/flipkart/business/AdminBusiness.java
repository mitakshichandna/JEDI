package com.flipkart.business;

import java.util.HashMap;

import com.flipkart.utils.Courses;

public class AdminBusiness{

    public HashMap<Integer, Courses> courseMap;

    public boolean addProf(int course, int Professor){
        System.out.println("Added Prof");
        return true;
    }

    public boolean removeProf(int course, int professor){
        System.out.println("Removed Prof");
        return true;
    }

    public boolean approveStudentReg(int student, int course){
        System.out.println("Approve Student Registration");
        return true;
    }

    public HashMap<String, String> generateReportCard(int student){
        HashMap<String, String> report = new HashMap<String, String>();
        System.out.println("Print Report Card");
        return report;
    }

    public void setcourseMap(HashMap<Integer,Courses> courseMap) {
        this.courseMap = courseMap;
    }

    public void addCourse(Courses temp) {
        courseMap.put(temp.getId(),temp);
    }

    public Courses getCourse(int courseId){
        return courseMap.get(courseId);
    }

    public void removeCourse(Courses temp){
        courseMap.remove(temp.getId());
    }

    public boolean sendPaymentNotice(int student){
        System.out.println("Payment Notice");
        return true;
    }
}