package com.damon.literarium.quiz;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.damon.literarium.R;
import com.damon.literarium.data.Quiz;

import info.hoang8f.widget.FButton;

public class HomeScreen extends AppCompatActivity {
    FButton playGame,quit;
    TextView tQ;

    TextView txtQuizName;

    TextView txtMinutes;

    TextView txtQuestions;

    TextView txtRange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        //the below method will initialize views
        initViews();

        //PlayGame button - it will take you to the MainGameActivity
        playGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this,MainGameActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //Quit button - This will quit the game
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        this.loadValues();
    }

    private void initViews() {
        //initialize views here
        playGame =(FButton)findViewById(R.id.playGame);
        quit = (FButton) findViewById(R.id.quit);
        tQ = (TextView)findViewById(R.id.tQ);

        txtQuizName = findViewById(R.id.textView54);
        txtMinutes = findViewById(R.id.txtMins);
        txtQuestions = findViewById(R.id.textView59);
        txtRange = findViewById(R.id.textView60);

        //Typeface - this is for fonts style
//        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/shablagooital.ttf");
//        playGame.setTypeface(typeface);
//        quit.setTypeface(typeface);
//        tQ.setTypeface(typeface);
    }

    private void loadValues()
    {
        Intent i = getIntent();
        Quiz z = new Quiz();
        if(i.hasExtra("NAME"))
        {
            z.name = i.getStringExtra("NAME");
        }
        if(i.hasExtra("MIN"))
        {
            z.minutes = i.getIntExtra("MIN",10);
        }
        if(i.hasExtra("RANGE"))
        {
            z.range = i.getStringExtra("RANGE");
        }
        if(i.hasExtra("Q"))
        {
            z.questionsCount = i.getIntExtra("Q",10);
        }
        loadQuiz(z);
    }

    private void loadQuiz(Quiz z)
    {
        txtQuizName.setText(z.name);
        txtRange.setText(z.range);
        txtQuestions.setText(String.valueOf(z.questionsCount));
        txtMinutes.setText(String.valueOf(z.minutes));
    }

}
