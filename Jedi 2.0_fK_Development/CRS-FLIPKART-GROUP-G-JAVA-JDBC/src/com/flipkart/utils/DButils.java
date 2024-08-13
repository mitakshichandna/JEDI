package com.flipkart.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.flipkart.utils.DButils;

public class DButils {
    private static Connection connection;
    public static Connection getConnection(){
        if(connection != null){
            return connection;
        }else{
            try{
                Properties prop = new Properties();
                InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("./config.properties");
                prop.load(inputStream);
                String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                String user = prop.getProperty("user");
                String password = prop.getProperty("password");
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            }catch(Exception e){

            }
            return connection;
        }
    }
    public static boolean closeConnection() {
        try {
            if (connection != null)
                connection.close();
        } 
        catch (SQLException se) {
        	return false;
        }
        return true;
	}
}
