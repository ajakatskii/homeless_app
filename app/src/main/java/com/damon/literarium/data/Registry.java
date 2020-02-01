package com.damon.literarium.data;

import android.content.Context;
import android.graphics.Bitmap;

import com.damon.literarium.data.repository.AttendanceSeedData;
import com.damon.literarium.data.repository.LibrarySeedData;
import com.damon.literarium.data.repository.QuizSeedData;
import com.damon.literarium.data.repository.RewardsSeedData;
import com.damon.literarium.data.repository.TuitionsSeedData;
import com.damon.literarium.utils.CameraCaptureUtil;

import java.util.ArrayList;

public class Registry {

    private static Registry instance;

    public static Registry getInstance() {
        if(Registry.instance == null) {
            Registry.instance = new Registry();
        }
        return  Registry.instance;
    }

    public User user;

    public Context context;

//    private FeedCollection feedCol;

    private ArrayList<Tuition> upcomingTuitions;

    private ArrayList<Tuition> tuitionRequests;

    private ArrayList<Tuition> tuitionSuggestions;

//    public FeedCollection getFeedCol()
//    {
//        if(this.feedCol == null)
//        {
//            this.feedCol = SeedDataMemory.getFeeds();
//        }
//        return this.feedCol;
//    }

    public ArrayList<Tuition> getTuitionSuggestions()
    {
        if(this.tuitionSuggestions == null)
        {
            this.tuitionSuggestions = TuitionsSeedData.getTuitionSuggestions();
        }
        return this.tuitionSuggestions;
    }

    public void addSuggestion(Tuition t)
    {
        //only add non-duplicate suggestions
        for(Tuition T: this.getTuitionSuggestions()) {
            if(T.subjectName.equals(t.subjectName)) {
                return;
            }
        }
        this.getTuitionSuggestions().add(0, t);
    }

    public ArrayList<Tuition> getUpcomingTuitions()
    {
        if(this.upcomingTuitions == null)
        {
            this.upcomingTuitions = TuitionsSeedData.getUpcomingTuitions();
        }
        return this.upcomingTuitions;
    }

    public ArrayList<Tuition> getAllTuitionRequests()
    {
        if(this.tuitionRequests == null) {
            this.tuitionRequests = TuitionsSeedData.getTuitionRequests();
        }
        return  this.tuitionRequests;
    }

    public boolean removeTuitionRequest(String subjectName)
    {
        return this.removeTuition(subjectName, this.tuitionRequests);
    }

    public boolean removeTuitionSuggestion(String subjectName)
    {
        return this.removeTuition(subjectName, this.tuitionSuggestions);
    }

    private boolean removeTuition(String subjectName, ArrayList<Tuition> list)
    {
        int removeIndex = -1;
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i)
                    .subjectName.equals(subjectName))
            {
                removeIndex = i;
                break;
            }
        }
        if(removeIndex != -1)
        {
            list.remove(removeIndex);
            return true;
        }else {
            return false;
        }
    }

    public boolean convertSuggestionToUpcomingTuition(String subjectName)
    {
        int removeIndex = -1;
        for(int i = 0; i < this.tuitionSuggestions.size(); i++)
        {
            if(this.tuitionSuggestions.get(i)
                    .subjectName.equals(subjectName))
            {
                removeIndex = i;
                break;
            }
        }
        if(removeIndex == -1)
        {
            return false;
        }
        this.upcomingTuitions.add(0,
                this.tuitionSuggestions.remove(removeIndex)
        );
        return true;
    }

    public Bitmap beforeDish;

    public void clearBeforeDishPic()
    {
        this.beforeDish = null;
    }

    public boolean hasBeforeDishPic()
    {
        return (this.beforeDish != null);
    }

    public int extraCoins = 0;

    private ArrayList<Reward> sportsRewards;

    private ArrayList<Reward> stationaryRewards;

    private ArrayList<Reward> booksRewards;

    private ArrayList<Reward> tripsRewards;

    private ArrayList<Reward> funRewards;

    private ArrayList<Reward> foodRewards;

    private ArrayList<Reward> toysRewards;


    public ArrayList<Reward> getSportRewards()
    {
        if(this.sportsRewards == null)
        {
            this.sportsRewards = RewardsSeedData.getSportsRewards();
        }
        return this.sportsRewards;
    }

    public ArrayList<Reward> getStationaryRewards()
    {
        if(this.stationaryRewards == null)
        {
            this.stationaryRewards = RewardsSeedData.getStationaryRewards();
        }
        return this.stationaryRewards;
    }

    public ArrayList<Reward> getBooksRewards()
    {
        if(this.booksRewards == null)
        {
            this.booksRewards = RewardsSeedData.getBookRewards();
        }
        return this.booksRewards;
    }

    public ArrayList<Reward> getTripsRewards()
    {
        if(this.tripsRewards == null)
        {
            this.tripsRewards = RewardsSeedData.getTripsRewards();
        }
        return this.tripsRewards;
    }

    public ArrayList<Reward> getToysRewards()
    {
        if(this.toysRewards == null)
        {
            this.toysRewards = RewardsSeedData.getToysRewards();
        }
        return this.toysRewards;
    }

    public ArrayList<Reward> getFoodRewards()
    {
        if(this.foodRewards == null)
        {
            this.foodRewards = RewardsSeedData.getFoodRewards();
        }
        return this.foodRewards;
    }

    public ArrayList<Reward> getFunRewards()
    {
        if(this.funRewards == null)
        {
            this.funRewards = RewardsSeedData.getFunRewards();
        }
        return this.funRewards;
    }

    private ArrayList<Book> issuedBook;

    private ArrayList<Book> libraryBook;

    public ArrayList<Book> getIssuedBooks()
    {
        if(this.issuedBook == null)
        {
            this.issuedBook = LibrarySeedData.getIssuedBooks();
        }
        return this.issuedBook;
    }

    public ArrayList<Book> getLibraryBooks()
    {
        if(this.libraryBook == null)
        {
            this.libraryBook = LibrarySeedData.getLibraryBooks();
        }
        return this.libraryBook;
    }

    private ArrayList<Book> mainBooks;

    private ArrayList<Book> secondaryBooks;

    public ArrayList<Book> getMainBooks()
    {
        if(this.mainBooks == null)
        {
            this.mainBooks = LibrarySeedData.getIssuedBooks();
        }
        return this.mainBooks;
    }

    public ArrayList<Book> getSecondaryBooks()
    {
        if(this.secondaryBooks == null)
        {
            this.secondaryBooks = LibrarySeedData.getLibraryBooks();
        }
        return this.secondaryBooks;
    }

    private ArrayList<Attendance> attendances;

    public ArrayList<Attendance> getAttendances()
    {
        if(this.attendances == null)
        {
            this.attendances = AttendanceSeedData.getAttendances();
        }
        return this.attendances;
    }

    private ArrayList<Quiz> quizes;

    public ArrayList<Quiz> getQuizes()
    {
        if(this.quizes == null)
        {
            this.quizes = QuizSeedData.getQuizList();
        }
        return this.quizes;
    }

    public CameraCaptureUtil cameraUtil;

}
