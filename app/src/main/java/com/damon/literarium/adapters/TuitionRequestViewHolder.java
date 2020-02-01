package com.damon.literarium.adapters;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.damon.literarium.AcceptTuitionRequestActivity;
import com.damon.literarium.R;
import com.damon.literarium.data.Tuition;

public class TuitionRequestViewHolder extends RecyclerView.ViewHolder {

    private CardView container;

    private TextView txtSubjectName;

    private TextView txtRange;

    private TextView txtAttending;

    private Tuition data;

    public TuitionRequestViewHolder(@NonNull View itemView) {
        super(itemView);
        this.container = (CardView) itemView;
        this.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), AcceptTuitionRequestActivity.class);
                i.putExtra("NAME", data.subjectName);
                i.putExtra("RANGE", data.range);
                view.getContext().startActivity(i);
            }
        });
        this.initViews();
    }

    private void initViews()
    {
        txtSubjectName = container.findViewById(R.id.lblQuizName);
        txtRange = container.findViewById(R.id.textView68);
        txtAttending = container.findViewById(R.id.textView3);
    }

    public void update(Tuition t)
    {
        data = t;
        txtSubjectName.setText(data.subjectName);
        txtAttending.setText(String.valueOf(data.attendingPeople));
        txtRange.setText(data.range);
    }

}
