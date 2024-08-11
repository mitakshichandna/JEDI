package com.flipkart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAOInterface {
    public void registerCourse(Integer id,String name) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/CRS","root","12345");
        PreparedStatement pst=con.prepareStatement("insert into RegisteredCourses values(?,?)");
        pst.setInt(1,id);
        pst.setString(2,name);
        pst.executeUpdate();
        con.close();
    }
    public void addCourse(Integer sid, Integer cid) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/CRS","root","12345");
        PreparedStatement pst=con.prepareStatement("insert into student_courses values(?,?)");
        pst.setInt(1,sid);
        pst.setInt(2,cid);
        pst.executeUpdate();
        con.close();
    }
    public void removeCourse(Integer sid, Integer cid) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/CRS","root","12345");
        PreparedStatement pst=con.prepareStatement("delete from student_courses where student_id=? and course_id=?");
        pst.setInt(1,sid);
        pst.setInt(2,cid);
        int rows=pst.executeUpdate();
        if(rows>0){
            System.out.println("course removed successfully");
        }
        else{
            System.out.println("course not found");
        }
    }
}
