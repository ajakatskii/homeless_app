package com.damon.literarium.data;

public class Quiz {

    public String range;

    public String name;

    public int minutes;

    public int questionsCount;

    public Quiz()
    {

    }

    public Quiz(String name, String range, int mins, int qCount)
    {
        this.name = name;
        this.range = range;
        this.minutes = mins;
        this.questionsCount = qCount;
    }

}
