package com.damon.literarium;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.damon.literarium.adapters.AttendanceAdapter;
import com.damon.literarium.data.Registry;
import com.damon.literarium.data.StudentUser;

public class AttendanceActivity extends AppCompatActivity {

    private TextView txtClassname;

    private TextView txtPercent;

    private RecyclerView rvAttendance;

    private AttendanceAdapter rvAttendanceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_attendance);
        this.initViews();
        this.loadUserData();
    }

    private void initViews()
    {
        this.txtClassname = findViewById(R.id.lblQuizName);
        this.txtPercent = findViewById(R.id.lblPercentage);
        this.rvAttendance = findViewById(R.id.rvAttendanceRecords);
        this.rvAttendanceAdapter = new AttendanceAdapter(Registry.getInstance().getAttendances());
        this.rvAttendance.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rvAttendance.setAdapter(rvAttendanceAdapter);
    }

    private void loadUserData()
    {
        StudentUser user = (StudentUser) Registry.getInstance().user;
        this.txtClassname.setText(user.courseName);
        this.txtPercent.setText(String.valueOf(user.avgAttendancePercentage));
    }

}
