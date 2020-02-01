package com.damon.literarium;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.damon.literarium.adapters.UpcomingTuitionsAdapter;
import com.damon.literarium.data.Registry;
import com.damon.literarium.data.StudentUser;
import com.damon.literarium.data.User;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {

    private CircleImageView ivProfile;

    private TextView txtName;
    private TextView txtInfo;
    private TextView txtAge;
    private TextView txtTown;
    private TextView txtGrade;
    private TextView lblStudyText;

    private Button btnAttendance;
    private Button btnCoins;

    private RecyclerView rvTuitions;
    private UpcomingTuitionsAdapter rvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Registry.getInstance().context = this;
        this.initViews();
        this.loadUser();
    }

    private void initViews()
    {
        this.ivProfile = this.findViewById(R.id.ivProf);
        this.txtName = this.findViewById(R.id.lblName);
        this.txtInfo = this.findViewById(R.id.lblInfo);
        this.txtAge = this.findViewById(R.id.lblAge);
        this.txtTown = this.findViewById(R.id.lblTown);
        this.txtGrade = this.findViewById(R.id.lblGrade);
        this.lblStudyText = this.findViewById(R.id.lblStudy);
        this.btnAttendance = this.findViewById(R.id.btnAttendance);
        this.btnCoins = this.findViewById(R.id.btnCoins);

        this.rvTuitions = this.findViewById(R.id.rvTuitions);
        this.rvTuitions.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        this.rvAdapter = new UpcomingTuitionsAdapter(
                Registry.getInstance().getUpcomingTuitions(), false
        );
        this.rvTuitions.setAdapter(this.rvAdapter);
    }

    private void loadUser() {
        User user = Registry.getInstance().user;
        if(user == null) {
            this.finish();
            return;
        }
        this.ivProfile.setImageResource(user.profileDrawableResourceId);
        this.txtName.setText(user.name);
        this.txtInfo.setText(user.bio);
        this.txtAge.setText(String.valueOf(user.age));
        this.txtTown.setText(user.town);

        this.btnCoins.setText(String.format("COINS: %s", String.valueOf(user.rewardPoints)));
        if(user instanceof StudentUser) {
            StudentUser sUser = (StudentUser) user;
            this.btnAttendance.setText(String.format("ATTENDANCE: %S", String.valueOf(sUser.avgAttendancePercentage)));
            this.txtGrade.setText(sUser.courseName);
            this.btnAttendance.setVisibility(View.VISIBLE);
            this.txtGrade.setVisibility(View.VISIBLE);
            this.lblStudyText.setVisibility(View.VISIBLE);
        } else {
            this.btnAttendance.setVisibility(View.INVISIBLE);
            this.txtGrade.setVisibility(View.INVISIBLE);
            this.lblStudyText.setVisibility(View.INVISIBLE);
        }
    }

    public void btnAttendance_Click(View vw)
    {
        Intent i = new Intent(this, AttendanceActivity.class);
        this.startActivity(i);
    }

    public void btnRedeem_Click(View vw)
    {
        Intent i = new Intent(this, RewardsActivity.class);
        this.startActivity(i);
    }

    @Override
    protected void onResume() {
        super.onResume();
        rvAdapter.notifyDataSetChanged();
    }
}
