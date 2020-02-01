package com.damon.literarium.quiz;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.damon.literarium.DashboardActivity;
import com.damon.literarium.R;
import com.damon.literarium.utils.Utils;


public class PlayAgain extends Activity {

    Button playAgain;
    TextView wrongAnsText;
    TextView txtPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_again);
       //Initialize
        playAgain = (Button) findViewById(R.id.playAgainButton);
        wrongAnsText = (TextView)findViewById(R.id.wrongAns);
        txtPoints = findViewById(R.id.txtPoints3);
        //play again button onclick listener
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlayAgain.this, MainGameActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Utils.getQuizPoints(
                this.getIntent().getIntExtra("Q", 0),
                txtPoints
        );
        //Setting typefaces for textview and button - this will give stylish fonts on textview and button
//        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/shablagooital.ttf");
//        playAgain.setTypeface(typeface);
//        wrongAnsText.setTypeface(typeface);
    }

    public void btnGoBack_Click(View view) {
        Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
