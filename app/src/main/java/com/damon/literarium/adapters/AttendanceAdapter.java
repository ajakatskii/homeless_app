package com.damon.literarium.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.damon.literarium.R;
import com.damon.literarium.data.Attendance;

import java.util.ArrayList;

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceViewHolder> {

    private ArrayList<Attendance> data;

    public AttendanceAdapter(ArrayList<Attendance> data)
    {
        this.data = data;
    }

    @NonNull
    @Override
    public AttendanceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.attendance_item, parent, false);
        return new AttendanceViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull AttendanceViewHolder holder, int position) {
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
