package com.damon.literarium.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.damon.literarium.R;
import com.damon.literarium.data.Book;

import java.util.ArrayList;

public class LibraryBooksAdapter extends RecyclerView.Adapter<LibraryBookViewHolder> {

    private ArrayList<Book> data;

    private ArrayList<Book> actualData;

    private boolean showPercentage;

    public LibraryBooksAdapter(ArrayList<Book> books, boolean showPercentage)
    {
        super();
        this.data = books;
        this.showPercentage = showPercentage;
    }

    @NonNull
    @Override
    public LibraryBookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_item, parent, false);
        return new LibraryBookViewHolder(cv, showPercentage);
    }

    @Override
    public void onBindViewHolder(@NonNull LibraryBookViewHolder holder, int position) {
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

    /**
     * replace the current dataset with filtered dataset
     * @param text
     */
    public void searchBook(String text)
    {
        if(text == null || text.isEmpty())
        {
            if(this.actualData != null)
            {
                this.data = this.actualData;
                this.notifyDataSetChanged();
            }
            return;
        }
        text = text.toLowerCase();
        ArrayList<Book> filteredBooks = new ArrayList<>();
        for(Book b: this.data)
        {
            if(b.name.toLowerCase().indexOf(text) >= 0)
            {
                filteredBooks.add(b);
            }
        }
        this.actualData = this.data;
        this.data = filteredBooks;
        this.notifyDataSetChanged();
    }

    public void updateData(ArrayList<Book> books)
    {
        this.data = books;
        this.notifyDataSetChanged();
    }

}
