package com.flipkart.business;

import java.util.HashMap;
import java.util.List;

import javax.xml.crypto.Data;

import com.flipkart.bean.Professor;
import com.flipkart.dao.Database;
import com.flipkart.utils.Courses;

public class AdminBusiness{

    public boolean addProf(int courseId, int professorId){
        System.out.println("Added Prof");
        Professor professor = Database.profMap.get(professorId);
        Courses course = Database.courseMap.get(courseId);
        professor.setProfessorId(Database.userId+1);
        course.setProf(professor);
        //professor.setCourseMap(course.getId(), course.getName());
        Database.profMap.put(Database.userId++, professor);

        return true;
    }

    public boolean removeProf(int course, int professor){
        System.out.println("Removed Prof");
        Database.profMap.remove(professor);
        return true;
    }

    public boolean approveStudentReg(int student, int course){
        System.out.println("Approve Student Registration");
        Database.courseMap.get(course).addStudent(Database.studentMap.get(student));
        return true;
    }

    public HashMap<String, String> generateReportCard(int student){
        HashMap<String, String> report = new HashMap<String, String>();
        System.out.println("Print Report Card");
        return report;
    }

    public void addCourse(Courses temp) {
        Database.courseMap.put(temp.getId(),temp);
    }

    public Courses getCourse(int courseId){
        return Database.courseMap.get(courseId);
    }

    public void removeCourse(Courses temp){
        Database.courseMap.remove(temp.getId());
    }

    public boolean sendPaymentNotice(int student){
        System.out.println("Payment Notice");
        com.flipkart.bean.Student s = Database.studentMap.get(student);
        List<Courses> courses = s.getRegisteredCourses();
        for(Courses course:courses){
            if(course.getStudents().size() > 10){
                System.out.println("Course "+course.getName()+" is full");
                return false;
            }
        }
        System.out.println("Payment Approved");
        return true;
    }
}