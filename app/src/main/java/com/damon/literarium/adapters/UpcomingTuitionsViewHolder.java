package com.damon.literarium.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.damon.literarium.AcceptTuitionSuggestionActivity;
import com.damon.literarium.R;
import com.damon.literarium.data.Tuition;
import com.damon.literarium.utils.Utils;

public class UpcomingTuitionsViewHolder extends RecyclerView.ViewHolder {

    private CardView container;

    private ImageView ivProfile;
    private LinearLayout llStars;
    private TextView txtChapterName;
    private TextView txtDate;
    private TextView txtVenue;
    private TextView txtAttending;

    private boolean forwardToAccept;

    private Tuition data;

    public UpcomingTuitionsViewHolder(@NonNull View view, boolean forwardToAccept)
    {
        super(view);
        this.container = (CardView) view;
        this.forwardToAccept = forwardToAccept;
        if(this.forwardToAccept)
        {
            this.container.setOnClickListener(null);
            this.container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Utils.openActivity(view, AcceptTuitionSuggestionActivity.class,
                            "NAME", data.subjectName);
                }
            });
        }
        this.loadViews();
    }

    private void loadViews()
    {
        this.ivProfile = this.container.findViewById(R.id.imageView2);
        this.txtChapterName = this.container.findViewById(R.id.txtEventName);
        this.llStars = this.container.findViewById(R.id.llStars);
        this.txtDate = this.container.findViewById(R.id.textView2);
        this.txtAttending = this.container.findViewById(R.id.textView3);
        this.txtVenue = this.container.findViewById(R.id.textView4);
    }

    public void update(Tuition t)
    {
        data = t;
//        this.ivProfile.setImageResource(t.profileResourceId);
        this.txtChapterName.setText(t.subjectName);
        this.txtDate.setText(t.date);
        this.txtVenue.setText(t.venue);
        this.txtAttending.setText(String.valueOf(t.attendingPeople));
        Utils.setStars(t.teacherRating, this.llStars);
    }

}
