package com.demo.loginpage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText etUserName, etPassword;
    Button btnSignIn;
    TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViews();
        setListeners();
    }

    private void findViews() {
        etUserName = (EditText) findViewById(R.id.etUserName);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        tvRegister = (TextView) findViewById(R.id.tvRegister);
    }

    private void setListeners() {
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputUserName = etUserName.getText().toString();
                String inputPassword = etPassword.getText().toString();

                if (!inputUserName.equals("") && !inputPassword.equals("")) {
                    SharedPreferences credentials = getSharedPreferences("credentials", 0);
                    String account = credentials.getString("account", "");
                    String password = credentials.getString("password", "");
                    if (inputUserName.equals(account) && inputPassword.equals(password)) {
                        Toast.makeText(LoginActivity.this, "帳號驗證成功", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(LoginActivity.this, UserHomePage.class);
                        intent.putExtra("USER_NAME", etUserName.getText().toString());
                        startActivity(intent);
                    } else  // TODO: register the new account here.
                        Toast.makeText(LoginActivity.this, "帳號驗證失敗", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(LoginActivity.this, "欄位不可空白", Toast.LENGTH_LONG).show();
                }
            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
