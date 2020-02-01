package com.damon.literarium;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.damon.literarium.adapters.LibraryBooksAdapter;
import com.damon.literarium.adapters.QuizAdapter;
import com.damon.literarium.data.Book;
import com.damon.literarium.data.Quiz;
import com.damon.literarium.data.Registry;
import com.damon.literarium.utils.Utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class GoalActivity extends AppCompatActivity {

    ImageView ivCapture;
    TextView txtRange;

    RecyclerView rvBooks;
    LibraryBooksAdapter booksAdapter;

    RecyclerView rvQuizes;
    QuizAdapter quizAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);
        this.initViews();
        this.loadData();
    }

    private void initViews()
    {
        ivCapture = findViewById(R.id.ivCapture);
        txtRange = findViewById(R.id.txtPoints);
        rvBooks = findViewById(R.id.rvGoalBooks);
        rvBooks.setLayoutManager(
                new LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        );
        rvQuizes = findViewById(R.id.rvGoalQuiz);
        rvQuizes.setLayoutManager(
            new LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        );
    }

    private void loadData()
    {
        //get image from image helper
        ivCapture.setImageBitmap(
                BitmapFactory.decodeFile(
                        Registry.getInstance().cameraUtil.lastPicturePath
                )
        );
        //get random range
        int digits = (((Double)Utils.getRandom(1)).intValue() % 7);
        if(digits < 3)
        {
            digits = 3;
        }
        Double range = Utils.getRandom(digits);
        txtRange.setText(String.valueOf(range.intValue()));
        //get books
        booksAdapter = new LibraryBooksAdapter(this.getGoalBooks(), false);
        rvBooks.setAdapter(booksAdapter);
        //get quiz
        quizAdapter = new QuizAdapter(this.getGoalQuiz());
        rvQuizes.setAdapter(quizAdapter);
    }

    private ArrayList<Book> getGoalBooks()
    {
        ArrayList<Book> books = new ArrayList<>();
        books.addAll(Registry.getInstance().getIssuedBooks());
        books.addAll(Registry.getInstance().getLibraryBooks());
        books.addAll(Registry.getInstance().getMainBooks());
        books.addAll(Registry.getInstance().getSecondaryBooks());
        Collections.shuffle(books);
        //pick random 3-10 books
        int rand = ((Double)(Math.random()  * 10)).intValue();
        if(rand < 3)
        {
            rand = 3;
        }
        ArrayList<Book> res = new ArrayList<>();
        for(int i = 0; i < rand; i++)
        {
            res.add(books.get(i));
        }
        return res;
    }

    private ArrayList<Quiz> getGoalQuiz()
    {
        ArrayList<Quiz> quizs = new ArrayList<>();
        quizs.addAll(Registry.getInstance().getQuizes());
        Collections.shuffle(quizs);
        //pick random 3-10 books
        int rand = ((Double)(Math.random()  * 10)).intValue();
        if(rand < 3)
        {
            rand = 3;
        }
        ArrayList<Quiz> res = new ArrayList<>();
        for(int i = 0; i < rand; i++)
        {
            res.add(quizs.get(i));
        }
        return res;
    }

}
