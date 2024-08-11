package com.flipkart.dao;

import java.sql.*;

public class UserDAOInterface {
    public void registerStudent(Integer id, String name, String password) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/CRS","root","12345");

            PreparedStatement stmt=con.prepareStatement("insert into StudentRegistered values(?,?,?)");
            stmt.setInt(1,id);//1 specifies the first parameter in the query
            stmt.setString(2,name);
            stmt.setString(3,password);
            int i=stmt.executeUpdate();
            System.out.println(i+" records inserted");

            con.close();

        }catch(Exception e){ System.out.println(e);}
    }
    public boolean validateLogin(String username, String password) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/CRS","root","12345");
            PreparedStatement stmt=con.prepareStatement("select StudentPass from StudentRegistered where StudenName=? and StudentPass=?");
            stmt.setString(1,username);
            stmt.setString(2,password);
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
                String pass = rs.getString("StudentPass");
                return pass.equals(password);
            }
            else{
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}

