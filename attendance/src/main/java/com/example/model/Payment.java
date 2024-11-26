package com.example.model;

public class Payment {
    private int PaymentId;
    private double amount;
    private int employeeId;
    private String status;
    private String note;
    private String date;

    public Payment(int paymentId,int employeeId,double amount, String status,String note,String date)
    {
        this.PaymentId=paymentId;
        this.employeeId=employeeId;
        this.amount=amount;
        this.status=status;
        this.note=note;
        this.date=date;
    }

    public Payment(int employeeId,double amount, String status,String note,String date)
    {
        this.employeeId=employeeId;
        this.amount=amount;
        this.status=status;
        this.note=note;
        this.date=date;
    }

    public int getEmployeeId()
    {
        return this.employeeId;
    }

    public String getPaymentStatus()
    {
        return this.status;
    }

    public double getPaymentAmount()
    {
        return this.amount;
    }

    public String getPaymentNote()
    {
        return this.note;
    }

    public String getDate()
    {
        return this.date;
    }

    public void printPayment() {
        
        System.out.println("\nPayment Id:"+this.PaymentId+"\nEmployee Id:"+this.employeeId+"\nAmount:"+this.amount+"\nStatus:"+this.status+"\nDate:"+this.date+"\nNotes:"+this.note);
    }


}
