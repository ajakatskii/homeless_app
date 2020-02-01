package com.damon.literarium.data;

public class Tuition {

    public String subjectName;
    public int teacherRating;
    /**
     * date in string because we are nt doing any date based processing
     */
    public String date;
    public String venue;
    public int attendingPeople;
    public String teacherName;
    public String range;

    public Tuition(String subjectName, int teacherRating, String date,
                   String venue, int attendingPeople, String teacherName, String range)
    {
        this.subjectName = subjectName;
        this.teacherRating = teacherRating;
        this.date = date;
        this.venue = venue;
        this.attendingPeople = attendingPeople;
        this.teacherName = teacherName;
        this.range = range;
    }

}
