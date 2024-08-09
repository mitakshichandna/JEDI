package com.flipkart.dao;

import java.util.HashMap;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.utils.Courses;

public class Database {
    public static HashMap<Integer, Courses> courseMap;
    private static int courseId = 0;
    private static int userId = 0;
    
    // Ideally Student, Prof and Admin should inherit from User and only <Int, User> should be used
    // In case of db separate Maps are better as we will break storage into 3 for Prof Student and Course
    public static HashMap<Integer, Professor> profMap;
    public static HashMap<Integer, Student> studentMap;

    public static int getCourseId(){
        return courseId++;
    }
    public static int getUserId(){
        return userId++;
    }

    public static int getCourseId(String name){
        // DAO will use db commands to fetch from name as arg
        for(Courses c:courseMap.values()){
            if(c.getName().equals(name)){
                return c.getId();
            }
        }
        return -1;
        
    }

    public static int getProfId(String name){
        // DAO will use db commands to fetch from name as arg
        for(Professor p:profMap.values()){
            if(p.getName().equals(name)){
                return p.getId();
            }
        }
        return -1;
    }

    public static int getStudentId(String name){
        // DAO will use db commands to fetch from name as arg
        for(Student s:studentMap.values()){
            if(s.getName().equals(name)){
                return s.getId();
            }
        }
        return -1;
    }
}
