package com.demo.loginpage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UserHomePage extends AppCompatActivity {

    TextView tvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home_page);
        findViews();
        welcome();
    }

    private void findViews() {
        tvWelcome = (TextView) findViewById(R.id.tvWelcome);
    }

    private void welcome() {
        Intent intent = getIntent();
        String userName = intent.getStringExtra("USER_NAME");
        tvWelcome.setText("Welcome, " + userName);
    }
}
