package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.example.model.Payment;
import com.example.util.DbConnection;

public class PaymentDao {

    public void recordPayment(Payment newPayment)
    {
        Connection con=null;
        PreparedStatement preparedStatement=null;
        con=DbConnection.getConnection();
        String sqlQuery="Insert Into Payment (employeeId,amount,status,paymentDate,note) VALUES (?,?,?,?,?)";

        try{
            preparedStatement=con.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, newPayment.getEmployeeId());
            preparedStatement.setDouble(2, newPayment.getPaymentAmount());
            preparedStatement.setString(3, newPayment.getPaymentStatus());
            preparedStatement.setString(4, newPayment.getDate());
            preparedStatement.setString(5, newPayment.getPaymentNote());

            System.out.println("Inserting Into Table");

            int rowsAffected=preparedStatement.executeUpdate();

            System.out.println("Inserted " + rowsAffected + " row(s) into Payment table.");
        }
        catch(Exception ex)
        {
            System.out.println("Failed to add payment ");
            ex.getMessage();
        }
    }
    public void getPaymentDetails()
    {

    }

    public static void getEmployeePaymentDetails(int id)
    {
        ArrayList<Payment>paymentList=new ArrayList<>();

        Connection con=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet = null;


        con=DbConnection.getConnection();
        String sqlQuery="Select *  from Payment where employeeId = ?";
        

        try{
            preparedStatement=con.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, id);

            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                int paymentId = resultSet.getInt("paymentId");
                int employeeid = resultSet.getInt("employeeid"); 
                double amount = resultSet.getInt("amount");
                String status = resultSet.getString("status");
                String date = resultSet.getDate("paymentDate").toString();
                String note = resultSet.getString("note");

                // Create an Employee object and add it to the list
                Payment record = new Payment(paymentId,employeeid,amount,status,note,date);
                record.printPayment();
                paymentList.add(record);
            }

        }
        catch(Exception ex)
        {
            System.out.println("Failed to Get Payment Records");
            System.err.println(ex.getMessage());
        }
    }

    public void updatePaymentDetails()
    {

    }

    



}
