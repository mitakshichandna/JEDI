package com.flipkart.utils;

import java.util.List;

public class CourseCatalogue {
    public static List<Courses> coursesList;

    public static List<Courses> getCoursesList() {
        return coursesList;
    }

    public void  setCoursesList(List<Courses> coursesList) {
        this.coursesList = coursesList;
    }
    public  static void addCourse(Courses temp) {
        coursesList.add(temp);
    }
}
