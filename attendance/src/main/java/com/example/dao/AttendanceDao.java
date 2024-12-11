package com.example.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.example.model.Attendance;
import com.example.util.DbConnection;

public class AttendanceDao {

    public static void recordPresence(Attendance attendance)
    {
        Connection con=null;
        PreparedStatement preparedStatement=null;
        con=DbConnection.getConnection();
        String sqlQuery="Insert Into Attendance (employeeId,attendance_date,status) VALUES (?,?,'Present')";

        try{
            preparedStatement=con.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, attendance.getEmployeeId());
            preparedStatement.setString(2, attendance.getDate());


            System.out.println("Inserting Into Table");

            int rowsAffected=preparedStatement.executeUpdate();

            System.out.println("Inserted " + rowsAffected + " row(s) into Payment table.");
        }
        catch(Exception ex)
        {
            System.out.println("Failed to add Attendance Record ");
            System.err.println(ex.getMessage());
        }
    }

    public  static void getAttendanceDetails(int id)
    {
        ArrayList<Attendance>attendanceList=new ArrayList<>();

        Connection con=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet = null;


        con=DbConnection.getConnection();
        String sqlQuery="Select *  from Attendance where employeeId = ?";
        

        try{
            preparedStatement=con.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, id);

            resultSet=preparedStatement.executeQuery();

            while (resultSet.next()) {
                int attendanceId = resultSet.getInt("attendanceId");
                int employeeid = resultSet.getInt("employeeid"); 

                String date = resultSet.getDate("attendance_date").toString();
                // Create an Employee object and add it to the list
                Attendance record = new Attendance(attendanceId,employeeid,date);
                record.printAttendance();
                attendanceList.add(record);
            }

        }
        catch(Exception ex)
        {
            System.out.println("Failed to Get Attendance Records");
            System.err.println(ex.getMessage());
        }
 
    }
}

