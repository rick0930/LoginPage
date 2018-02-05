package com.demo.loginpage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.demo.loginpage.R.id.btnSignIn;

public class RegisterActivity extends AppCompatActivity {

    EditText etEmail, etUserName, etPassword, etAge;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        findViews();
        setListeners();
    }

    private void findViews() {
        etEmail = (EditText) findViewById(R.id.etEmail);
        etUserName = (EditText) findViewById(R.id.etUserName);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etAge = (EditText) findViewById(R.id.etAge);
        btnRegister = (Button) findViewById(R.id.btnRegister);
    }

    private void setListeners() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String userName = etUserName.getText().toString();
                String password = etPassword.getText().toString();
                String age = etAge.getText().toString();

                if (!email.equals("") && !userName.equals("") && !password.equals("") && !age.equals("")) {
                    savePersonalData();
                    Toast.makeText(RegisterActivity.this, "註冊成功", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(RegisterActivity.this, UserHomePage.class);
                    intent.putExtra("USER_NAME", etUserName.getText().toString());
                    startActivity(intent);
                } else
                    Toast.makeText(RegisterActivity.this, "欄位不可空白", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void savePersonalData() {
        SharedPreferences credentials = getSharedPreferences("credentials", 0);
        credentials.edit().putString("email", etEmail.getText().toString()).commit();
        credentials.edit().putString("account", etUserName.getText().toString()).commit();
        credentials.edit().putString("password", etPassword.getText().toString()).commit();
        credentials.edit().putString("age", etAge.getText().toString()).commit();
    }
}
