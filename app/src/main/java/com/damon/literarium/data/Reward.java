package com.damon.literarium.data;

import com.damon.literarium.R;

public class Reward {

    public String name;

    public String desc;

    public int coins;

    public boolean selected;

    public int imgResId;

    public String location;

    public Reward(String name, String desc,
                  int coins, boolean selected,
                  int imgResId, String location)
    {
        this.name = name;
        this.desc = desc;
        this.coins = coins;
        this.selected = selected;
        this.imgResId = imgResId;
        this.location = location;
    }

    public Reward(String name, String desc,
                  int coins, boolean selected,
                  String location)
    {
        this.name = name;
        this.desc = desc;
        this.coins = coins;
        this.selected = selected;
        this.imgResId = R.drawable.badge_plain;
        this.location = location;
    }

}
