package com.damon.literarium;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.damon.literarium.data.FacultyUser;
import com.damon.literarium.data.Registry;
import com.damon.literarium.data.User;
import com.damon.literarium.utils.Utils;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername;

    private EditText etPassword;

    private Button btnNewUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUsername = this.findViewById(R.id.txtUsername);
        etPassword = this.findViewById(R.id.txtPassword);
        this.btnNewUser = this.findViewById(R.id.btnSignup);
        //set context here to show messages
        Registry.getInstance().context = this;
    }

    public void btnLogin_click(View vw)
    {
        User user = User.initUser(this.etUsername.getText().toString(), this.etPassword.getText().toString());
        Registry.getInstance().user = user;
        if(user == null) {
            //clear values from text fields?
            //do something?
            Utils.showMessage("Invalid credentials");
            return;
        } else {
            //correct password entered, according to the user redirect to correct activity
            Intent intent;
            if(user instanceof FacultyUser) {
                //TODO: do something extra here or let the dashboard handle it?
                intent = new Intent(this.getApplicationContext(), DashboardActivity.class);
            } else {
                intent = new Intent(this.getApplicationContext(), DashboardActivity.class);
            }
            this.startActivity(intent);
        }
    }

    /**
     * hide the new user button since functionality is not implemented.
     * @param vw
     */
    public void btnNewUser_Click(View vw) {
        Utils.showMessage("Contact your School Teacher.");
        this.btnNewUser.setVisibility(View.INVISIBLE);
    }

}
