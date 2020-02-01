package com.damon.literarium;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.damon.literarium.adapters.RewardsAdapter;
import com.damon.literarium.data.Registry;
import com.damon.literarium.data.Reward;
import com.damon.literarium.utils.Utils;

import java.util.ArrayList;

public class RewardsActivity extends AppCompatActivity {

    protected TextView txtRewards;

    protected RecyclerView rvAwards;

    protected RecyclerView.LayoutManager lManager;

    protected RewardsAdapter rvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewards);
        initViews();
        loadData();
    }

    protected void loadData()
    {
        txtRewards.setText(
                String.valueOf(Registry.getInstance().user.rewardPoints)
        );
    }

    protected void initViews()
    {
        txtRewards = findViewById(R.id.textView38);
        rvAwards = findViewById(R.id.rvAwards);
        lManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rvAdapter = new RewardsAdapter(Registry.getInstance().getFoodRewards());
        rvAwards.setLayoutManager(lManager);
        rvAwards.setAdapter(rvAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }

    public void btnCatg_Click(View vw)
    {
        ArrayList<Reward> rewards;
        switch(vw.getId())
        {
            case R.id.cvCatgFood:
                rewards = Registry.getInstance().getFoodRewards();
                break;
            case R.id.cvCatgSports:
                rewards = Registry.getInstance().getSportRewards();
                break;
            case R.id.cvCatgTrips:
                rewards = Registry.getInstance().getTripsRewards();
                break;
            case R.id.cvCatgToys:
                rewards = Registry.getInstance().getToysRewards();
                break;
            case R.id.cvCatgFun:
                rewards = Registry.getInstance().getFunRewards();
                break;
            case R.id.cvCatgStationary:
                rewards = Registry.getInstance().getStationaryRewards();
                break;
            case R.id.cvCatgBooks:
                rewards = Registry.getInstance().getBooksRewards();
                break;
            default:
            rewards = null;
        }
        if(rewards == null) {
            return;
        }
        this.rvAdapter.changeRewards(rewards);
    }

    public void btnClaim_Click(View vw)
    {
        int points = 0;
        //check total points to spend
        for(Reward r : this.rvAdapter.getRewardData())
        {
            if(r.selected)
            {
                points += r.coins;
            }
        }
        if(Registry.getInstance().user.rewardPoints < points)
        {
            Utils.showMessage(
                    String.format(
                            "Fail!. You have %s coins, you need %s coins",
                            String.valueOf(Registry.getInstance().user.rewardPoints),
                            points
                            )
            );
            return;
        } else {
            Registry.getInstance().user.spend(points);
            Utils.showMessage(
                    String.format(
                            "Success!. Deducted %s coins, you now have %s coins",
                            points,
                            String.valueOf(Registry.getInstance().user.rewardPoints)
                    )
            );
        }
        this.loadData();
    }

}
