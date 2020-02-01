package com.damon.literarium.data;

import com.damon.literarium.R;

public class Book {

    public String name;

    public int rating;

    public String genre;

    public double percentCompleted;

    public int drawableId;

    /**
     * , int drawableId
     * @param rating
     * @param genre
     * @param percentComplete
     */
    public Book(String name, int rating, String genre, double percentComplete)
    {
        this.name = name;
        this.rating = rating;
        this.genre = genre;
        this.percentCompleted = percentComplete;
        this.drawableId = R.drawable.cultures;
    }

}
