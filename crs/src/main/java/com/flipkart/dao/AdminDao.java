package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.exceptions.CourseAlreadyExistsException;
import com.flipkart.exceptions.CourseNotFoundException;
import com.flipkart.exceptions.UserAlreadyExistsException;
import com.flipkart.exceptions.UserNotFoundException;
import com.flipkart.constants.Queries;
import com.flipkart.utils.DButils;

public class AdminDao implements AdminDaoInterface{

	public static Connection conn = DButils.getConnection();
	
	@Override
	public String addProf(Professor prof, String username) throws UserAlreadyExistsException {
	    try {
	        // Check if the username already exists
	        PreparedStatement checkUserStmt = conn.prepareStatement(Queries.GET_USER_USERNAME);
	        checkUserStmt.setString(1, username);
	        ResultSet checkUserRs = checkUserStmt.executeQuery();
	        
	        if (checkUserRs.next()) {
	            // If a result is found, the username already exists
	            throw new UserAlreadyExistsException("Username already in use: " + username);
	        }
	        
	        // Proceed with generating a new user ID
	        PreparedStatement ps = conn.prepareStatement(Queries.FETCH_IDS);
	        ResultSet rs = ps.executeQuery();
	        List<String> userIds = new ArrayList<>();
	        while (rs.next()) {
	            userIds.add(rs.getString("userID"));
	        }
	        
	        Random rand = new Random();
	        String userID;
	        while (true) {
	            long id = 10000000 + rand.nextInt(10000000);
	            userID = "PROFESSOR" + Long.toString(id);
	            if (!userIds.contains(userID))
	                break;
	        }
	        
	        // Add the new user
	        PreparedStatement ps1 = conn.prepareStatement(Queries.ADD_USER);
	        ps1.setString(1, userID);
	        ps1.setString(2, prof.getName());
	        ps1.setString(3, "Professor");
	        ps1.setString(4, prof.getContact());
	        ps1.setString(5, prof.getEmail());
	        ps1.setString(6, prof.getPassword());
	        ps1.setString(7, username);
	        ps1.executeUpdate();
	        
	        // Add the professor details
	        PreparedStatement ps2 = conn.prepareStatement(Queries.ADD_PROFESSOR);
	        ps2.setString(1, userID);
	        ps2.setString(2, prof.getDept());
	        ps2.setString(3, prof.getQualification());
	        
	        if (ps2.executeUpdate() == 1)
	            return userID;
	        
	    } catch (SQLException e) {
	        e.printStackTrace(); // Log the exception
	        return null;
	    }
	    return null;
	}

	@Override
	public boolean removeProf(String profID) throws UserNotFoundException{
		// TODO Auto-generated method stub
		try {
            PreparedStatement ps = conn.prepareStatement(Queries.REMOVE_USER);
            ps.setString(1, profID);
            if(ps.executeUpdate() == 1)
            {
            	ps = conn.prepareStatement(Queries.REMOVE_PROFESSOR);
            	ps.setString(1, profID);
            	if(ps.executeUpdate() == 1)
            		return true;
            }
            else {
            	throw new UserNotFoundException(profID);
            }
        }catch (SQLException e) {
        	return false;
        }
		return false;
	}

	@Override
	public boolean updateCourse(String courseID, Course updatedCourse) throws CourseAlreadyExistsException,CourseNotFoundException{
		if(!this.removeCourse(courseID))return false;
        return this.addCourse(updatedCourse);
    }

	@Override
	public boolean addCourse(Course course) throws CourseAlreadyExistsException{
		try {
			// Step 1: Check if the course already exists
	        PreparedStatement checkCourseStmt = conn.prepareStatement(Queries.GET_COURSE);
	        checkCourseStmt.setString(1, course.getCourseID());
	        ResultSet checkCourseRs = checkCourseStmt.executeQuery();
	        
	        if (checkCourseRs.next()) {
	            // If a result is found, the course already exists
	            throw new CourseAlreadyExistsException(course.getCourseID());
	        }
            PreparedStatement ps = conn.prepareStatement(Queries.ADD_COURSE);
            ps.setString(1, course.getCourseID());
            ps.setString(2, course.getCourseName());
            //ps.setString(3, course.getCourseProf());
            ps.setInt(3, course.getSeats());
            ps.setFloat(4, course.getPrice());

            int rs=ps.executeUpdate();
            if(rs == 1)
            	return true;

        } catch (SQLException e) {
        	return false;
        }
        return false;
		
	}

	@Override
	public boolean removeCourse(String courseID) throws CourseNotFoundException {
		try {
            PreparedStatement ps = conn.prepareStatement(Queries.REMOVE_COURSE);
            ps.setString(1, courseID);
            if(ps.executeUpdate() == 1)
            	return true;
            else
            	throw new CourseNotFoundException(courseID);

        } catch (SQLException e) {
        	return false;
        }
	}

	@Override
	public boolean registerStudent(String studentID) throws UserNotFoundException{
		try {
            PreparedStatement ps = conn.prepareStatement(Queries.APPROVE_REGISTRATION);
            ps.setString(1, studentID);
            if(ps.executeUpdate() == 1)
            	return true;
            else
            	throw new UserNotFoundException(studentID);

        } catch (SQLException e) {
        	return false;
        }
	}

	@Override
	public Set<Course> viewCourses() {
		try {
			Set<Course> courseList = new HashSet<Course>();
            PreparedStatement ps = conn.prepareStatement(Queries.VIEW_COURSE_CATALOG);
            //ps.setString(1, courseID);
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

	@Override
	public Set<Student> viewUnapprovedStudents() {
		// TODO Auto-generated method stub
		try {
			Set<Student> studentList = new HashSet<Student>();
            PreparedStatement ps = conn.prepareStatement(Queries.VIEW_UNAPPROVED_STUDENTS);
            ResultSet rs = ps.executeQuery(); 
            
            while(rs.next())
            {
            	Student student=new Student(rs.getString("user.userID"),rs.getString("user.name"),rs.getString("user.contact"),rs.getString("user.email"),rs.getString("student.branch"),rs.getInt("student.rollNum"),rs.getBoolean("student.approved"),rs.getString("user.password"));
            	studentList.add(student);
            	System.out.println(student.getName());
            }
            
            return studentList;
            
        } catch (SQLException e) {
    		return null;
        }
	}

	@Override
	public Set<Professor> viewProfessors() {
		// TODO Auto-generated method stub
		try {
			Set<Professor> profList = new HashSet<Professor>();
            PreparedStatement ps = conn.prepareStatement(Queries.VIEW_PROF_LIST);
            //ps.setString(1, courseID);
            ResultSet rs = ps.executeQuery(); 
            
            while(rs.next())
            {
            	Professor prof=new Professor(rs.getString("user.userID"),rs.getString("user.name"),rs.getString("user.contact"),rs.getString("user.email"),rs.getString("professor.department"),rs.getString("professor.qualification"),rs.getString("user.password"));
            	profList.add(prof);
            }
            
            return profList;
            
        } catch (SQLException e) {
    		return null;
        }
	}

}
