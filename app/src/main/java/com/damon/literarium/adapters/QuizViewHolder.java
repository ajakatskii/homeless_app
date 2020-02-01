package com.damon.literarium.adapters;

import android.content.Intent;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.damon.literarium.QuizActivity;
import com.damon.literarium.R;
import com.damon.literarium.data.Quiz;
import com.damon.literarium.quiz.HomeScreen;

import org.w3c.dom.Text;

public class QuizViewHolder extends RecyclerView.ViewHolder {

    private CardView container;

    private TextView txtQuizName;

    private ImageView ivQuizProfile;

    private TextView txtMinutes;

    private TextView questionCount;

    private TextView range;

    private Quiz data;

    public QuizViewHolder(@NonNull View itemView) {
        super(itemView);
        this.container = (CardView) itemView;
        this.container.setOnClickListener(null);
        this.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), HomeScreen.class);
                i.putExtra("NAME", data.name);
                i.putExtra("MIN", data.minutes);
                i.putExtra("RANGE", data.range);
                i.putExtra("Q", data.questionsCount);
                view.getContext().startActivity(i);
            }
        });
        this.initViews();
    }

    private void initViews()
    {
        this.txtQuizName = container.findViewById(R.id.lblQuizName);
        ivQuizProfile = container.findViewById(R.id.imageView27);
        txtMinutes = container.findViewById(R.id.txtTime);
        range = container.findViewById(R.id.lblRewardRange);
        questionCount = container.findViewById(R.id.lblQuestionsCount);
    }

    public void update(Quiz q)
    {
        data = q;
        txtQuizName.setText(q.name);
        txtMinutes.setText(String.valueOf(q.minutes));
        range.setText(q.range);
        questionCount.setText(String.valueOf(q.questionsCount));
    }

}
