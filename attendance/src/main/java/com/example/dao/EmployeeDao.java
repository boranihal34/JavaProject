package com.example.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.model.Employee;
import com.example.util.DbConnection;

public class EmployeeDao {
    

    public void addEmployee(Employee e)
    {

        Connection connection = null;
        PreparedStatement preparedStatement = null;


        String sqlQuery = "INSERT INTO Employee (employeeid, name, salary) VALUES (?, ?, ?)";
        connection = DbConnection.getConnection();

        try{

            preparedStatement = connection.prepareStatement(sqlQuery);
            // Set the values for the placeholders (?)
            preparedStatement.setInt(1, e.getEmployeeId()); // employeeid = 1
            preparedStatement.setString(2, e.getEmployeeName()); // name = 'John Doe'
            preparedStatement.setDouble(3, e.getEmployeeSalary());
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Inserted " + rowsAffected + " row(s) into Employee table.");
  
        }
        catch (Exception ex)
        {
            System.err.println("Failed to Execute Query");
            ex.getStackTrace();
        }

        
    }

    public ArrayList<Employee> getAllEmployees()
    {
        String sqlQuery="Select * from Employee";
        ArrayList<Employee>EmployeeList=new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        connection=DbConnection.getConnection();
        

        try{
            
            statement=connection.createStatement();
            resultSet=statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                int employeeid = resultSet.getInt("employeeid");
                String name = resultSet.getString("name");
                int salary = resultSet.getInt("salary");

                // Create an Employee object and add it to the list
                Employee employee = new Employee(employeeid, name, salary);
                EmployeeList.add(employee);
            }

            

        }
        catch(Exception ex)
        {
            System.err.println("Failed to Execute getAllEmployees query");
            ex.getStackTrace();
        }
        return EmployeeList;
    }


}
