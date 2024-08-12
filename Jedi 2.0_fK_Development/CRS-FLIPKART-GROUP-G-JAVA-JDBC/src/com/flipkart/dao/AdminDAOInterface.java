package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.constants.Queries;
import com.flipkart.utils.DButils;
import com.flipkart.utils.Pair;

/*
 * Admins listed under table Admin(adminId(int, suto inc, unique, non null, prime), name(VARCHAR(45)))
 * Professors     
 */
public class AdminDAOInterface {

    Connection connection = DButils.getConnection();
    private PreparedStatement statement;

    public void deleteCourse(int courseId){
        try{
            statement = connection.prepareStatement(Queries.DELETE_COURSE);
            statement.setInt(1, courseId);
            statement.executeUpdate();

        } catch (SQLException e) {
            // TODO: handle exception
        }
    }
    public void addCourse(int courseId, String courseName){
        try{
            statement = connection.prepareStatement(Queries.ADD_COURSE);
            statement.setInt(1, courseId);
            statement.setString(2, courseName);
            statement.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public List<Integer> getStudentCourses(int studentId){
        ArrayList<Integer> courses = new ArrayList<Integer>(10);
        try{
            statement = connection.prepareStatement(Queries.STUDENT_COURSES);
            statement.setInt(1, studentId);
            ResultSet set = statement.executeQuery();
            while(set.next()){
                courses.add(set.getInt("course"));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return courses;
    }
    public void approveStudent(int studentId){
        try{
            statement = connection.prepareStatement(Queries.REGISTER_STUDENT);
            statement.setInt(1, studentId);
            statement.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public List<Pair<Integer, String>> registeredStudents(int studentId){
        ArrayList<Pair<Integer, String>> courses = new ArrayList<Pair<Integer, String>>(10);
        try{
            statement = connection.prepareStatement(Queries.LIST_REGISTERED_STUDENTS);
            ResultSet set = statement.executeQuery();
            while(set.next()){
                courses.add(new Pair<Integer, String>(set.getInt("studentId"), set.getString("name")));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return courses;
    }
    public List<Pair<Integer, String>> unregisteredStudents(){
        ArrayList<Pair<Integer, String>> courses = new ArrayList<Pair<Integer, String>>(10);
        try{
            statement = connection.prepareStatement(Queries.LIST_UNREGISTERED_STUDENTS);
            ResultSet set = statement.executeQuery();
            while(set.next()){
                courses.add(new Pair<Integer, String>(set.getInt("studentId"), set.getString("name")));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return courses;
    }
    public void assignProfToCourse(int professorId, int courseId){
        try{
            statement = connection.prepareStatement(Queries.ASSIGN_COURSE);
            statement.setInt(1, professorId);
            statement.setInt(2, courseId);
            statement.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
