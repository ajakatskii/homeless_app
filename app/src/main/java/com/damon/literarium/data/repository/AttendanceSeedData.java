package com.damon.literarium.data.repository;

import com.damon.literarium.data.Attendance;

import java.util.ArrayList;

public class AttendanceSeedData {

    public static ArrayList<Attendance> getAttendances()
    {
        ArrayList<Attendance> att = new ArrayList<>();
        att.add(
                new Attendance(
                        "Physics",
                        3,
                        60.78
                )
        );
        att.add(
                new Attendance(
                        "Games",
                        2,
                        98.78
                )
        );
        att.add(
                new Attendance(
                        "Chemistry",
                        1,
                        75.56
                )
        );
        att.add(
                new Attendance(
                        "Maths",
                        4,
                        87.99
                )
        );
        att.add(
                new Attendance(
                        "S.S.T.",
                        1,
                        89.23
                )
        );
        att.add(
                new Attendance(
                        "Science",
                        4,
                        78.9
                )
        );
        att.add(
                new Attendance(
                        "English",
                        2,
                        67.78
                )
        );
        att.add(
                new Attendance(
                        "Sanskrit",
                        3,
                        45.67
                )
        );
        return att;
    }

}
