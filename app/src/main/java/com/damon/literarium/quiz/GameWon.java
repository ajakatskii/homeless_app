package com.damon.literarium.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.damon.literarium.DashboardActivity;
import com.damon.literarium.R;
import com.damon.literarium.data.Registry;
import com.damon.literarium.utils.Utils;

public class GameWon extends Activity {

    TextView txtPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_won);
        txtPoints = findViewById(R.id.txtPoints);
        //get a random number and display
        Utils.getQuizPoints(10, txtPoints);
    }

    //This is onclick listener for button
    //it will navigate from this activity to MainGameActivity
    public void PlayAgain(View view) {
        Intent intent = new Intent(GameWon.this, MainGameActivity.class);
        startActivity(intent);
        finish();
    }

    public void btnGoBack_Click(View view) {
        Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);
        finish();
    }
}
