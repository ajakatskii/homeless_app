package com.damon.literarium;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.damon.literarium.adapters.LibraryBooksAdapter;
import com.damon.literarium.data.Book;
import com.damon.literarium.data.Registry;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CoursesActivity extends AppCompatActivity {

    private RecyclerView rvMain;
    private LibraryBooksAdapter rvMainAdapter;

    private RecyclerView rvSecondary;
    private LibraryBooksAdapter rvSecondaryAdapter;

    private TextView lblMainSubject;

    private TextView lblSecondarySubject;

    private String subjectName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        this.initViews();
        this.loadData();
    }

    private void loadData()
    {
        Intent i = this.getIntent();
        if(!i.hasExtra("NAME"))
        {
            return;
        }
        this.subjectName = i.getStringExtra("NAME");
        this.lblMainSubject.setText(subjectName);
        this.lblSecondarySubject.setVisibility(View.INVISIBLE);
        this.rvSecondary.setVisibility(View.INVISIBLE);
        int idx = this.subjectName.indexOf("[");
        String subject;
        if(idx > -1) {
            subject = this.subjectName.substring(0, this.subjectName.indexOf("["));
        } else {
            subject = subjectName;
        }
        String bookName = subject + " Book - 1";
        //get book name
        Book book = new Book(bookName, 3, subjectName, 14);
        ArrayList<Book> books = new ArrayList<>();
        books.add(book);
        this.rvMainAdapter.updateData(books);
    }

    private void initViews()
    {
        this.rvMain = this.findViewById(R.id.rvMainSubjects);
        this.rvMainAdapter = new LibraryBooksAdapter(
                Registry.getInstance().getMainBooks(), true
        );
        this.rvMain.setLayoutManager(
                new LinearLayoutManager(this,
                        RecyclerView.VERTICAL,
                        false)
        );
        this.rvMain.setAdapter(this.rvMainAdapter);

        this.rvSecondary = this.findViewById(R.id.rvSecondarySubjects);
        this.rvSecondaryAdapter = new LibraryBooksAdapter(
                Registry.getInstance().getSecondaryBooks(), true
        );
        this.rvSecondary.setLayoutManager(
                new LinearLayoutManager(this,
                        RecyclerView.VERTICAL,
                        false)
        );
        this.rvSecondary.setAdapter(this.rvSecondaryAdapter);
        this.lblMainSubject = findViewById(R.id.textView14);
        this.lblSecondarySubject = findViewById(R.id.textView15);
    }

}
