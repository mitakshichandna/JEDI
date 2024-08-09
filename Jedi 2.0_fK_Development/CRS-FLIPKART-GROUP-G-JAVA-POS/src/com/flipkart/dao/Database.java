package com.flipkart.dao;

import java.util.HashMap;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.utils.Courses;

public class Database {
    public static HashMap<Integer, Courses> courseMap;
    public static int courseId = 0;
    public static int userId = 0;
    
    // Ideally Student, Prof and Admin should inherit from User and only <Int, User> should be used
    public static HashMap<Integer, Professor> profMap;
    public static HashMap<Integer, Student> studentMap;
}
