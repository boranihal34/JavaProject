package com.example.util;
import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

    public static final String url="jdbc:mysql://localhost:3306/EmployeeAttendance";
    public static final String username = "root";
    public static final String password = "nihalbora";



    public static Connection getConnection()
    {
        try{
            return DriverManager.getConnection(url, username, password);
        }
        catch (Exception ex)
        {
            System.err.println("Failed to Connect to Databse");
            return null;
        }
    }
    public static void executeQuery()
    {

    }
    

}
