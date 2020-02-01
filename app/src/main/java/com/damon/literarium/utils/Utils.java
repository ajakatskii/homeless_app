package com.damon.literarium.utils;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.damon.literarium.data.Registry;

public class Utils {

    public static Toast MsgObj;

    public static void showMessage(String msg) {
        Context c = Registry.getInstance().context;
        if (c == null) {
            return;
        }
        //cancel previous toast message
        if(MsgObj != null) {
            MsgObj.cancel();
        }
        MsgObj = Toast.makeText(c, msg, Toast.LENGTH_SHORT);
        MsgObj.show();
    }

    public static void setStars(int starCount, LinearLayout ll)
    {
        //first enable all views
        int i =0;
        ImageView iv;
        for(i = 0; i < ll.getChildCount() && i < starCount; i++)
        {
            iv = (ImageView) ll.getChildAt(i);
            iv.setVisibility(View.VISIBLE);
        }
        for(;i < ll.getChildCount();i++)
        {
            iv = (ImageView) ll.getChildAt(i);
            iv.setVisibility(View.INVISIBLE);
        }
    }

    public static void setStars(int starCount, LinearLayout ll,int orgResId, int repResId)
    {
        int i =0;
        ImageView iv;
        //first enable all views
        for(i = 0; i < ll.getChildCount(); i++)
        {
            iv = (ImageView) ll.getChildAt(i);
            iv.setVisibility(View.VISIBLE);
        }
        i =0;
        for(i = 0; i < ll.getChildCount() && i < starCount; i++)
        {
            iv = (ImageView) ll.getChildAt(i);
            iv.setImageResource(orgResId);
        }
        for(;i < ll.getChildCount();i++)
        {
            iv = (ImageView) ll.getChildAt(i);
            iv.setImageResource(repResId);
        }
    }

    public static double analyzeFoodWastage()
    {
        Double rand = Math.random();
        rand = Double.parseDouble(String.valueOf(Math.round(rand * 10000.00)));
        rand = rand/100.0;
        return rand;
    }

    public static double analyzeCalories()
    {
        return Math.round(Math.random() * 100000.0) / 10.0;
    }

    public static double getRandom(int digits)
    {
        double rand = Math.round(Math.random() * Math.pow(10.0,digits)) / 10.0;
        return  rand;
    }

    public static void openActivity(View vw, Class<?> cls)
    {
        Intent i = new Intent(vw.getContext(), cls);
        vw.getContext().startActivity(i);
    }

    public static void openActivity(View vw, Class<?> cls, String key, String value)
    {
        Intent i = new Intent(vw.getContext(), cls);
        i.putExtra(key, value);
        vw.getContext().startActivity(i);
    }

    public static boolean getQuizPoints(int qid, TextView txtPoints)
    {
        if(qid > 0) {
            int points = ((Double) Utils.getRandom(2)).intValue();
            Registry.getInstance().user.rewardPoints += points;
            txtPoints.setText(String.valueOf(points));
        }else {
            txtPoints.setText("0");
            return false;
        }
        return true;
    }

}
