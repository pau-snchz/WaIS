package com.mycompany.modules;
import java.sql.*;

public class DatabaseUtility {
    private static Connection connection;
    private static final String URL = "jdbc:mysql://localhost:3306/wais";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Password1234#";
    
    public static Connection getConnection() throws SQLException
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("SOMETHING IS WRONG.");
        }
        
        return connection;
    }
}
