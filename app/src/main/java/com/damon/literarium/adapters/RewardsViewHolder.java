package com.damon.literarium.adapters;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.damon.literarium.R;
import com.damon.literarium.data.Registry;
import com.damon.literarium.data.Reward;

public class RewardsViewHolder extends RecyclerView.ViewHolder {

    private CardView container;

    private TextView txtTitle;

    private EditText etDesc;

    private TextView txtCoins;

    private CheckBox cb;

    private ImageView ivImage;

    private Reward reward;

    private TextView txtLocation;

    public RewardsViewHolder(@NonNull View itemView) {
        super(itemView);
        this.container = (CardView) itemView;
        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cb.isChecked())
                {
                    //redeemed awards can not be taken back.
                    return;
                }
                if(reward.coins < Registry.getInstance().user.rewardPoints)
                {
//                    Registry.getInstance().user.rewardPoints -= reward.coins;
                    cb.setChecked(true);
                    reward.selected = true;
                }
            }
        });
        initViews();
    }

    public void initViews()
    {
        txtTitle = container.findViewById(R.id.textView39);
        etDesc = container.findViewById(R.id.editText4);
        ivImage = container.findViewById(R.id.imageView29);
        txtCoins = container.findViewById(R.id.textView40);
        txtLocation = container.findViewById(R.id.textView10);
        cb = container.findViewById(R.id.checkBox);
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb.setChecked(reward.selected);
            }
        });
    }

    public void update(Reward reward)
    {
        this.reward = reward;
        txtTitle.setText(reward.name);
        etDesc.setText(reward.desc);
        txtCoins.setText(String.valueOf(reward.coins));
        ivImage.setImageResource(reward.imgResId);
        this.txtLocation.setText(reward.location);
        cb.setChecked(reward.selected);
    }

}
