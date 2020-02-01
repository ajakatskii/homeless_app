package com.damon.literarium.data;

public class Attendance {

    public String subjectName;

    public int rating;

    public double percentAttendance;

    public Attendance(String name, int rating, double percent)
    {
        this.subjectName = name;
        this.rating = rating;
        this.percentAttendance = percent;
    }

}
