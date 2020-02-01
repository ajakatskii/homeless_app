package com.damon.literarium;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.damon.literarium.data.Registry;

public class AcceptTuitionRequestActivity extends AppCompatActivity {

    TextView txtRange;

    TextView txtSubjectName;

    String subjectName;

    String range;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept_tuition_request);
        this.initViews();
        this.loadData();
    }

    private void loadData()
    {
        Intent i = this.getIntent();
        subjectName = i.getStringExtra("NAME");
        range = i.getStringExtra("RANGE");
        txtSubjectName.setText(subjectName);
        txtRange.setText(range);
    }

    private void initViews()
    {
        this.txtSubjectName = findViewById(R.id.textView49);
        this.txtRange = findViewById(R.id.txtRange);
    }

    public void btnAccept_Click(View vw)
    {
        deleteFromDB();
    }

    public void btnDecline_Click(View vw)
    {
        deleteFromDB();
    }

    /**
     * todo: remove this particular object from db;
     */
    private void deleteFromDB()
    {
        Registry.getInstance().removeTuitionRequest(subjectName);
        finish();
    }
}
