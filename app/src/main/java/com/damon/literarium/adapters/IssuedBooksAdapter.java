package com.damon.literarium.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.damon.literarium.R;
import com.damon.literarium.data.Book;

import java.util.ArrayList;

public class IssuedBooksAdapter extends RecyclerView.Adapter<IssuedBooksViewHolder> {

    private ArrayList<Book> data;

    public IssuedBooksAdapter(ArrayList<Book> data)
    {
        super();
        this.data = data;
    }

    @NonNull
    @Override
    public IssuedBooksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                                    .inflate(R.layout.lib_book_item, parent, false);
        return new IssuedBooksViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull IssuedBooksViewHolder holder, int position) {
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
