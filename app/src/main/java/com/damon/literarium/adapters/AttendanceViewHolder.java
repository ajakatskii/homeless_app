package com.damon.literarium.adapters;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.damon.literarium.CoursesActivity;
import com.damon.literarium.R;
import com.damon.literarium.data.Attendance;
import com.damon.literarium.utils.Utils;

public class AttendanceViewHolder extends RecyclerView.ViewHolder {

    private CardView container;

    private TextView txtSubjectName;

    private LinearLayout llStars;

    private TextView txtPercentage;

    private Attendance data;

    public AttendanceViewHolder(@NonNull View itemView) {
        super(itemView);
        this.container = (CardView) itemView;
        this.container.setOnClickListener(null);
        this.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.openActivity(view, CoursesActivity.class,
                        "NAME", data.subjectName);
            }
        });
        this.initViews();
    }

    private void initViews()
    {
        this.txtSubjectName = this.container.findViewById(R.id.lblQuizName);
        this.llStars = this.container.findViewById(R.id.llReviewGiven);
        this.txtPercentage = this.container.findViewById(R.id.textView26);
    }

    public void update(Attendance a)
    {
        this.data = a;
        this.txtSubjectName.setText(a.subjectName);
        this.txtPercentage.setText(String.valueOf(a.percentAttendance));
        Utils.setStars(a.rating, this.llStars);
    }

}
