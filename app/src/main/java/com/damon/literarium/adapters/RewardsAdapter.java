package com.damon.literarium.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.damon.literarium.R;
import com.damon.literarium.data.Reward;

import java.util.ArrayList;

public class RewardsAdapter extends RecyclerView.Adapter<RewardsViewHolder> {

    ArrayList<Reward> rewards;

    public RewardsAdapter(ArrayList<Reward> rewards)
    {
        this.rewards = rewards;
    }

    @NonNull
    @Override
    public RewardsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.reward_item, parent, false);
        RewardsViewHolder rvh = new RewardsViewHolder(cv);
        return rvh;
    }

    @Override
    public void onBindViewHolder(@NonNull RewardsViewHolder holder, int position) {
        if(position > this.rewards.size())
        {
            return;
        }
        holder.update(this.rewards.get(position));
    }

    @Override
    public int getItemCount() {
        return this.rewards.size();
    }

    public void changeRewards(ArrayList<Reward> rewards) {
        this.rewards = rewards;
        this.notifyDataSetChanged();
    }

    public ArrayList<Reward> getRewardData()
    {
        return this.rewards;
    }

}
