package com.flipkart.dao;

import java.util.Set;

import com.flipkart.bean._Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

public class ProfessorDAOInterface {
    public Set<_Course> viewAvailableCourses() {
        try {
            Set<_Course> courseList = new HashSet<Course>();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM crsapp.catalog");
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

    public  Set<_Course> viewCoursesUnderProf(Professor professor){
        try {
            Set<Course> courseList = new HashSet<Course>();
            PreparedStatement ps = conn.prepareStatement(DBQueries.VIEW_COURSE_ENROLLED);
            ps.setString(1, prof.getID());
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Course course=new Course(rs.getString("courseID"),rs.getString("courseName"),rs.getString("courseProf"),rs.getInt("seats"));
                courseList.add(course);
            }
            return courseList;
        } catch (SQLException e) {
            return null;
        }
    }


}
