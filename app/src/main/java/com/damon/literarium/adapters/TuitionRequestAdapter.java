package com.damon.literarium.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.damon.literarium.R;
import com.damon.literarium.data.Tuition;

import java.util.ArrayList;

public class TuitionRequestAdapter extends RecyclerView.Adapter<TuitionRequestViewHolder> {

    private ArrayList<Tuition> data;

    public TuitionRequestAdapter(ArrayList<Tuition> data)
    {
        this.data = data;
    }

    @NonNull
    @Override
    public TuitionRequestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tuition_request_item, parent, false);
        return new TuitionRequestViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull TuitionRequestViewHolder holder, int position) {
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

    public void updateData(ArrayList<Tuition> tuitions)
    {
        this.data = tuitions;
        this.notifyDataSetChanged();
    }

}
