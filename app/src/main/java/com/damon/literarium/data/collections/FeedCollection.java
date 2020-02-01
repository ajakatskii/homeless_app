package com.damon.literarium.data.collections;

import com.damon.literarium.data.Feed;

import java.util.ArrayList;
import java.util.Comparator;

public class FeedCollection {

    public ArrayList<Feed> feeds;

    public FeedCollection() {
        this.feeds = new ArrayList<>();
    }

    public void add(Feed feed) {
        this.feeds.add(feed);
    }

    public void sort()
    {
        this.feeds.sort(new Comparator<Feed>() {

            @Override
            public int compare(Feed o, Feed t1) {
                return o.postDate.compareTo(t1.postDate);
            }
        });
    }

    public Feed findByDesc(String desc)
    {
        for(Feed f: feeds)
        {
            if(f.description.equals(desc))
            {
                return f;
            }
        }
        return null;
    }

}
