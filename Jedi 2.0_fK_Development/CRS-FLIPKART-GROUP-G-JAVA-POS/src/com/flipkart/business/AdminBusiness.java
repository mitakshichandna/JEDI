package com.flipkart.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.crypto.Data;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.dao.Database;
import com.flipkart.utils.Courses;

public class AdminBusiness{

    public boolean addProf(String courseName, String professorName){
        System.out.println("Added Prof");
        int professorId = Database.getProfId(professorName);
        int courseId = Database.getCourseId(courseName);

        Professor professor = Database.profMap.get(professorId);
        Courses course = Database.courseMap.get(courseId);

        course.setProf(professor);
        professor.addCourse(courseId);
        return true;
    }

    public boolean removeProf(String courseName, String professorName){
        System.out.println("Remove Prof from Course");
        
        int professorId = Database.getProfId(professorName);
        int courseId = Database.getCourseId(courseName);

        Professor professor = Database.profMap.get(professorId);
        Courses course = Database.courseMap.get(courseId);

        course.removeProf(professor);
        professor.removeCourse(courseId);

        return true;
    }

    public boolean approveStudentReg(String studentName, String courseName){
        System.out.println("Approve Student Registration");
        int studentId = Database.getStudentId(studentName);
        int courseId = Database.getCourseId(courseName);

        Student student = Database.studentMap.get(studentId);
        Courses course = Database.courseMap.get(courseId);

        student.addCourse(courseId);
        course.addStudent(student);
        return true;
    }

    public HashMap<String, String> generateReportCard(String studentName){
        HashMap<String, String> report = new HashMap<String, String>();
        System.out.println("Print Report Card");

        int studentId = Database.getStudentId(studentName);
        Student student = Database.studentMap.get(studentId);

        HashSet<Integer> set = student.getRegisteredCourses();
        set.forEach(courseId -> {
            
        });

        return report;
    }

    public void addCourse(String courseName) {
        int id = Database.getCourseId();
        Database.courseMap.put(id, new Courses(id, courseName, true, new ArrayList<Student>(100)));
    }

    public Courses getCourse(int courseId){
        return Database.courseMap.get(courseId);
    }

    public void removeCourse(String courseName){
        Database.courseMap.remove(Database.getCourseId(courseName));
    }

    public boolean sendPaymentNotice(String studentName){
        System.out.println("Payment Notice");
        int studentId = Database.getStudentId(studentName);
        Student s = Database.studentMap.get(studentId);
        ArrayList<Integer> courses = (ArrayList<Integer>)s.getRegisteredCourses().stream()
                  .collect(Collectors.toList());
        for(int courseId:courses){
            if(Database.courseMap.get(courseId).getStudents().size() > 10){
                System.out.println("Course "+Database.courseMap.get(courseId).getName()+" is full");
                return false;
            }
        }
        System.out.println("Payment Approved");
        return true;
    }
}