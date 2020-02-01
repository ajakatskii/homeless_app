package com.damon.literarium.data;

import com.damon.literarium.R;
import com.damon.literarium.utils.Utils;

public class User {

    public String name;

    public String password;

    public int profileDrawableResourceId;

    public int rewardPoints;

    /**
     * library books that are issued to the student
     */
    public int issuedBooks;

    /**
     * percentage of successful answers given from total answers given
     */
    public double quizCompletionPercentage;

    /**
     * tuition count that this user is supposed to take (or give)
     */
    public int groupTuitions;

    public int age;

    public String town;

    public String bio;


    public User(String name, String password, int profileResourceId) {
        this.name = name;
        this.password = password;
        this.profileDrawableResourceId = profileResourceId;
        this.rewardPoints = 100;
        this.issuedBooks = Registry.getInstance().getIssuedBooks().size();
        this.quizCompletionPercentage = Utils.getRandom(3);
        this.groupTuitions = Registry.getInstance().getUpcomingTuitions().size();
        this.age = 16;
        this.town = "Nafargunj";
        this.bio = "";
    }

    /**
     * users:
     * 1) ankit : 123
     * 2) anya : 123
     * @param username
     * @param password
     * @return
     */
    public static User initUser(String username, String password) {
        username = username.toLowerCase();
        password = password.toLowerCase();

        if(username.equals("ankit") && password.equals("123"))
        {
            User student = new StudentUser("ankit", "123", R.drawable.contact);
            student.rewardPoints = 600;
            student.bio = "I'm passionate about physics, astrology and also a good conversation!";
            return student;
        } else if(username.equals("anya") && password.equals("123"))
        {
            User faculty = new FacultyUser("anya","123",R.drawable.man);
            faculty.rewardPoints = 1700;
            faculty.age = 33;
            faculty.bio = "I'm a passionate teacher, discovering ways to conquer life in new forms.";
            return faculty;
        }
        return null;
    }

    /**
     * makes the user spend the given no of coins
     * @param coins
     * @return
     */
    public boolean spend(int coins)
    {
        if(this.rewardPoints > coins) {
            this.rewardPoints -= coins;
            return true;
        } else {
            return false;
        }
    }

}
