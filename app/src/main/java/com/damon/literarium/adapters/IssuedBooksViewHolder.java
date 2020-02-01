package com.damon.literarium.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.damon.literarium.R;
import com.damon.literarium.ReaderActivity;
import com.damon.literarium.data.Book;
import com.damon.literarium.utils.Utils;

public class IssuedBooksViewHolder extends RecyclerView.ViewHolder {

    private CardView container;

    private TextView txtBookName;

    private LinearLayout llStars;

    private TextView txtGenre;

    private TextView txtCompleted;

    private ImageView ivBooks;

    private Book bookData;

    public IssuedBooksViewHolder(@NonNull View itemView) {
        super(itemView);
        this.container = (CardView) itemView;
        this.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.openActivity(view, ReaderActivity.class, "NAME", bookData.name);
            }
        });
        this.initView();
    }

    private void initView()
    {
        this.txtBookName = this.container.findViewById(R.id.txtEventName);
        this.llStars = this.container.findViewById(R.id.llStars);
        this.txtGenre = this.container.findViewById(R.id.textView2);
        this.txtCompleted = this.container.findViewById(R.id.textView4);
        this.ivBooks = this.container.findViewById(R.id.imageView2);
    }

    public void update(Book data)
    {
        this.bookData = data;
        this.txtBookName.setText(data.name);
        Utils.setStars(data.rating, this.llStars);
        this.txtGenre.setText(data.genre);
        this.txtCompleted.setText(String.format("%s%% Completed",String.valueOf(data.percentCompleted)));
        this.ivBooks.setImageResource(data.drawableId);
    }

}
