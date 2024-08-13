package com.flipkart.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DButils {
    private static Connection connection;
    public static Connection getConnection(){
        if(connection != null){
            return connection;
        }else{
            try {
                Properties prop = new Properties();
                InputStream inputStream = Files.newInputStream(Paths.get("/Users/saahir.j/Desktop/FlipkartJedi/JEDI/crs/src/config.properties"));
                prop.load(inputStream);
                String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                String user = prop.getProperty("user");
                String password = prop.getProperty("password");
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException | IOException e) {
                System.out.println(e.getMessage());
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
