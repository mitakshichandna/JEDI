package com.flipkart.dao;

import java.util.Set;

import com.flipkart.bean._Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

public class ProfessorDAOInterface {
    public Set<_Course> viewAvailableCourses() {
        // TODO Auto-generated method stub
        try {
            Set<_Course> courseList = new HashSet<Course>();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM crsapp.catalog");
            //ps.setString(1, courseID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Course student = new Course(rs.getString("courseID"), rs.getString("courseName"), rs.getString("courseProf"), rs.getInt("seats"));
                courseList.add(student);
            }

            return courseList;

        } catch (SQLException e) {
            return null;
        }
    }

}
