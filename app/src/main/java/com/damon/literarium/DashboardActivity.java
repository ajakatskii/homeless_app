package com.damon.literarium;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.damon.literarium.data.Registry;
import com.damon.literarium.data.StudentUser;
import com.damon.literarium.utils.CameraCaptureUtil;
import com.damon.literarium.utils.Utils;

public class DashboardActivity extends AppCompatActivity {

    private ImageView btnProfile;
    private CardView btnLogout;
    private CardView btnRedeem;
    private CardView btnLibrary;
    private CardView btnQuiz;
    private CardView btnGroupTuitions;
    private CardView btnGroupDiscussions;
    private CardView btnCourse;
    private CardView btnAttendance;

    private TextView txtName;
    private TextView txtCoins;
    private TextView txtPersonalLibraryBooks;
    private TextView txtCourseName;
    private TextView txtQuizPercentage;
    private TextView txtAttendancePercentage;
    private TextView txtGroupTuitions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Registry.getInstance().context = this;
        this.initViews();
        this.loadUserDetails();
    }

    private void initViews() {

        this.txtName = this.findViewById(R.id.lblName);

        this.txtCoins = this.findViewById(R.id.lblCoins);
        this.txtPersonalLibraryBooks = this.findViewById(R.id.lblLibraryBooks);
        this.txtCourseName = this.findViewById(R.id.lblCourseName);
        this.txtQuizPercentage = this.findViewById(R.id.lblQuizPercentage);
        this.txtAttendancePercentage = this.findViewById(R.id.lblAttendancePercentage);
        this.txtGroupTuitions = this.findViewById(R.id.lblGroupTuitionsCount);

        this.btnProfile = this.findViewById(R.id.ivProfile);
        this.btnRedeem = this.findViewById(R.id.card1);
        this.btnLibrary = this.findViewById(R.id.card2);
        this.btnCourse = this.findViewById(R.id.card3);
        this.btnQuiz = this.findViewById(R.id.card4);
        this.btnAttendance = this.findViewById(R.id.card5);
        this.btnGroupTuitions = this.findViewById(R.id.card6);
        this.btnGroupDiscussions = this.findViewById(R.id.card7);
        this.btnLogout= this.findViewById(R.id.card8);
    }

    private void loadUserDetails()
    {
        if(Registry.getInstance().user == null) {
            //since we found no user, exit now.
            this.finish();
            return;
        }
        this.txtName.setText(Registry.getInstance().user.name);
        this.btnProfile.setImageResource(Registry.getInstance().user.profileDrawableResourceId);
        this.txtCoins.setText(String.valueOf(Registry.getInstance().user.rewardPoints));
        this.txtPersonalLibraryBooks.setText(String.valueOf(Registry.getInstance().user.issuedBooks));
        this.txtQuizPercentage.setText(String.valueOf(Registry.getInstance().user.quizCompletionPercentage));
        this.txtGroupTuitions.setText(String.valueOf(Registry.getInstance().user.groupTuitions));
        if(Registry.getInstance().user instanceof StudentUser) {
            StudentUser user = (StudentUser) Registry.getInstance().user;
            this.txtCourseName.setText(String.valueOf(user.courseName));
            this.txtAttendancePercentage.setText(String.valueOf(user.avgAttendancePercentage));
            this.btnCourse.setVisibility(View.VISIBLE);
            this.btnAttendance.setVisibility(View.VISIBLE);
        } else {
            //hide unnecessary tiles
            this.btnCourse.setVisibility(View.INVISIBLE);
            this.btnAttendance.setVisibility(View.INVISIBLE);
        }
    }

    public void btnProfile_Click(View vw)
    {
        Intent i = new Intent(this,ProfileActivity.class);
        startActivity(i);
    }

    public void btnRedemption_Click(View vw)
    {
        Intent i = new Intent(this, RewardsActivity.class);
        startActivity(i);
    }

    public void btnLibrary_Click(View vw)
    {
        Intent i = new Intent(this, LibraryActivity.class);
        startActivity(i);
    }

    public void btnCourse_Click(View vw)
    {
        Intent i = new Intent(this, CoursesActivity.class);
        startActivity(i);
    }

    public void btnQuiz_Click(View vw){
        Intent i = new Intent(this, QuizActivity.class);
        startActivity(i);
    }

    public void btnAttendance_Click(View vw){
        Intent i = new Intent(this, AttendanceActivity.class);
        startActivity(i);
    }

    public void btnGroupTuitions_Click(View vw) {
        Intent i = new Intent(this, RequestedTuitionsActivity.class);
        startActivity(i);
    }

    public void btnGroupDiscussions_Click(View vw) {
        Utils.showMessage("Upcoming feature, not available yet.");
        CameraCaptureUtil util = new CameraCaptureUtil(this);
        Registry.getInstance().cameraUtil = util;
        util.dispatchIntent();
    }

    public void btnLogout_Click(View vw) {
        //clear the user
        Registry.getInstance().user = null;
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(Registry.getInstance().cameraUtil.retrieveImage(requestCode, resultCode, data))
        {
            //since we successfully captured the image show it in new frame along with the goal.
            Intent i = new Intent(this, GoalActivity.class);
            startActivity(i);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.loadUserDetails();
    }
}
