package com.damon.literarium.adapters;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.damon.literarium.R;
import com.damon.literarium.data.Feed;

public class FeedViewHolder extends RecyclerView.ViewHolder {

    private ConstraintLayout container;

    private ImageView ivImage;

    private EditText etDesc;

    private TextView txtDate;

    private ImageView ivProfileImage;

    private TextView txtUserName;

    private TextView txtFoodWastage;


    public FeedViewHolder(@NonNull View itemView) {
        super(itemView);
        this.container = (ConstraintLayout) itemView;
        this.initViews();
    }

    public void initViews()
    {
        ivImage = container.findViewById(R.id.imageView24);
        etDesc = container.findViewById(R.id.editText2);
        txtFoodWastage = container.findViewById(R.id.textView31);
        txtDate = container.findViewById(R.id.textView24);
        ivProfileImage = container.findViewById(R.id.imageView26);
        txtUserName = container.findViewById(R.id.textView9);
    }

    public void update(Feed feed){

        ivImage.setImageBitmap(feed.image);
        etDesc.setText(feed.description.toString());
        txtFoodWastage.setText(String.valueOf(feed.foodWastage));
        txtDate.setText(feed.postDate.toString());
        ivProfileImage.setImageResource(feed.profileImgResId);
        txtUserName.setText(feed.name);
    }
}
