package com.example.model;

public class Attendance {
    private int employeeId;
    private int attendanceId;
    private String date;

    public Attendance(int employeeId,String date) {
        this.date=date;
        this.employeeId=employeeId;

    }

    public Attendance(int attendanceId, int employeeId,String date) {
        this.attendanceId=attendanceId;
        this.date=date;
        this.employeeId=employeeId;

    }
    
    public int getEmployeeId()
    {
        return this.employeeId;
    }

    public String getDate()
    {
        return this.date;
    }

        public void printAttendance()
        {
            System.out.println(this.attendanceId + "   "+ this.employeeId + "  " + this.date);
        }
    
}
