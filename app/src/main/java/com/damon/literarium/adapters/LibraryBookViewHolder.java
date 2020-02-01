package com.damon.literarium.adapters;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.damon.literarium.R;
import com.damon.literarium.ReaderActivity;
import com.damon.literarium.data.Book;
import com.damon.literarium.utils.Utils;

public class LibraryBookViewHolder extends RecyclerView.ViewHolder {

    private CardView container;

    private TextView chapterName;

    private TextView genre;

    private TextView percentCompleted;
    TextView lblPercentage;

    private ImageView profilePic;

    private LinearLayout llReview;

    private Book bookData;

    private boolean showPercentage;

    public LibraryBookViewHolder(@NonNull View itemView, boolean showPercentage) {
        super(itemView);
        this.container = (CardView) itemView;
        this.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.openActivity(view, ReaderActivity.class, "NAME", bookData.name);
            }
        });
        this.showPercentage = showPercentage;
        this.initViews();
    }

    private void initViews()
    {
        this.chapterName = this.container.findViewById(R.id.lblQuizName);
        this.genre = this.container.findViewById(R.id.textView12);
        this.percentCompleted = this.container.findViewById(R.id.txtBookPercent);
        this.profilePic = this.container.findViewById(R.id.imageView27);
        llReview = this.container.findViewById(R.id.llReviewGiven);
        lblPercentage = container.findViewById(R.id.textView21);
    }

    public void update(Book bookData)
    {
        this.bookData = bookData;
        this.chapterName.setText(bookData.name);
        this.profilePic.setImageResource(bookData.drawableId);
        this.genre.setText(bookData.genre);
        Utils.setStars(bookData.rating, llReview);
        if(this.showPercentage) {
            percentCompleted.setText(String.valueOf(this.bookData.percentCompleted));
        }else {
            percentCompleted.setVisibility(View.INVISIBLE);
            lblPercentage.setVisibility(View.INVISIBLE);
        }
    }

}
