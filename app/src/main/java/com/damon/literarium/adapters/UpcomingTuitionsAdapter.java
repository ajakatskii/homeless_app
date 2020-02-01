package com.damon.literarium.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.damon.literarium.R;
import com.damon.literarium.data.Tuition;

import java.util.ArrayList;

public class UpcomingTuitionsAdapter extends RecyclerView.Adapter<UpcomingTuitionsViewHolder> {

    private ArrayList<Tuition> data;

    private boolean needsExceptance;

    public UpcomingTuitionsAdapter(ArrayList<Tuition> data, Boolean needsExceptance) {
        super();
        this.data = data;
        this.needsExceptance = needsExceptance;
    }

    @NonNull
    @Override
    public UpcomingTuitionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tuition_item ,parent, false);
        return new UpcomingTuitionsViewHolder(cv, this.needsExceptance);
    }

    @Override
    public void onBindViewHolder(@NonNull UpcomingTuitionsViewHolder holder, int position) {
        if(position >= this.getItemCount())
        {
            return;
        }
        holder.update(this.data.get(position));
    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }
}
