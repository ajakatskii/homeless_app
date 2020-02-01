package com.damon.literarium.data;

public class StudentUser extends User {

    /**
     * student's studying course name
     */
    public String courseName;

    /**
     * student's average attendance, from all the classes the student is supposed to attend
     */
    public double avgAttendancePercentage;

    public StudentUser(String name, String password, int profileResourceId) {
        super(name, password, profileResourceId);
        this.courseName = "Grade - 9";
        this.avgAttendancePercentage = 83.94;
    }
}
