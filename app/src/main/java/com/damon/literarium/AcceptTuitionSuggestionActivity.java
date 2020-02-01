package com.damon.literarium;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.damon.literarium.data.Registry;

public class AcceptTuitionSuggestionActivity extends AppCompatActivity {

    TextView txtSubjectName;

    TextView txtRange;

    String subjectName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept_tuition_suggestion);
        this.initView();
        this.loadData();
    }

    private void loadData()
    {
        Intent i = this.getIntent();
        subjectName = i.getStringExtra("NAME");
        txtSubjectName.setText(subjectName);
    }

    public void initView()
    {
        txtSubjectName = findViewById(R.id.textView49);
        txtRange = findViewById(R.id.txtRange);
    }

    public void btnAccept_Click(View vw)
    {
        Registry.getInstance().convertSuggestionToUpcomingTuition(subjectName);
        finish();
    }

    public void btnDecline_Click(View vw)
    {
        Registry.getInstance().removeTuitionSuggestion(subjectName);
        finish();
    }

}
