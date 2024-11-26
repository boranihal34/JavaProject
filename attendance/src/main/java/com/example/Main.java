package com.example;
import java.util.ArrayList;
import java.util.Scanner;

import com.example.dao.AttendanceDao;
import com.example.dao.EmployeeDao;
import com.example.dao.PaymentDao;
import com.example.model.Attendance;
import com.example.model.Employee;
import com.example.model.Payment;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        EmployeeDao Employees=new EmployeeDao();
        PaymentDao Payments = new PaymentDao();
        int choice;
        boolean flag=true;
        while (flag) { 
            System.out.println("\n\n1.Add Employee \n2.Get All Employee Details \n3.Record a Payment\n4.Get Employee Payment Details\n5.Enter Attendance\n6.Get Attendance Details\n9.Exit\n\nEnter Your Choice: ");
            choice = scanner.nextInt();
            switch(choice)
            {
                case 1:
                    // Reading an integer input
                    System.out.print("Enter Employee Id: ");
                    int employeeId = scanner.nextInt();
                    scanner.nextLine(); 


                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
            
                    // Reading a double input
                    System.out.print("Enter Salary: ");
                    int salary = scanner.nextInt();


                    Employee e=new Employee(employeeId,name,salary);
                    Employees.addEmployee(e);
                    break;

                case 2:
                    printEmployees(Employees.getAllEmployees());
                    break;
                case 3:
                    System.out.print("Enter Employee Id: ");
                    employeeId = scanner.nextInt();
                    scanner.nextLine(); 

                    // Reading a double input
                    System.out.print("Enter Amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); 

                    // Reading a double input
                    System.out.print("Enter Status: ");
                    String status = scanner.nextLine();
            
                    // Reading a double input
                    System.out.print("Enter Date: ");
                    String date = scanner.nextLine();

                    // Reading a double input
                    System.out.print("Enter Note: ");
                    String note = scanner.nextLine();


                    Payment p=new Payment(employeeId,amount,status,note,date);
                    Payments.recordPayment(p);
                    break;
                

                case 4:
                    System.out.print("Enter Employee Id: ");
                    employeeId = scanner.nextInt();
                    scanner.nextLine();
                    PaymentDao.getEmployeePaymentDetails(employeeId);
                    break;

                case 5:

                    // Reading an integer input
                    System.out.print("Enter Employee Id: ");
                    employeeId = scanner.nextInt();
                    scanner.nextLine(); 


                    System.out.print("Enter Date: ");
                    date = scanner.nextLine();

                    Attendance record=new Attendance(employeeId, date);
                    AttendanceDao.recordPresence(record);
                    break;
                case 6:
                    System.out.print("Enter Employee Id: ");
                    employeeId = scanner.nextInt();
                    scanner.nextLine();
                    AttendanceDao.getAttendanceDetails(employeeId);
                    break;


                case 9:
                    flag=false;
                    break;



                default:
                    System.out.println("Enter Correct Choice");
                    



            }
            
        }

    }

    public static void printEmployees(ArrayList<Employee> employeeList){


        // Print out the list of employees
        System.out.println("Employee List:");
        for (Employee employee : employeeList) {
            System.out.println(employee.getEmployeeId()+employee.getEmployeeName()+employee.getEmployeeSalary());
        }
    }
}