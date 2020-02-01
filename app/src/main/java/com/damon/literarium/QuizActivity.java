package com.damon.literarium;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.damon.literarium.adapters.QuizAdapter;
import com.damon.literarium.data.Registry;

public class QuizActivity extends AppCompatActivity {

    private RecyclerView rvQuiz;

    private QuizAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        rvQuiz = findViewById(R.id.rvQuizes);
        rvQuiz.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        adapter = new QuizAdapter(Registry.getInstance().getQuizes());
        rvQuiz.setAdapter(adapter);
    }
}
