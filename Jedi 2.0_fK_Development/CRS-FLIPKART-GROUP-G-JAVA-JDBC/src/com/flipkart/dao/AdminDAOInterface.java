package com.flipkart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.flipkart.constants.Queries;
import com.flipkart.utils.DButils;

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
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void addCourse(){
        try{
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void approveStudentReg(){
        try{
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void registeredStudents(){
        try{
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void unregisteredStudents(){
        try{
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void assignProfToCourse(){
        try{
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
