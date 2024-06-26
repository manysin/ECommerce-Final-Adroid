package com.sinmany.e_commerce.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sinmany.e_commerce.R;

public class LoginActivity extends AppCompatActivity {

    private EditText userEdt, passEdt;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        setVariable();
    }

    private void initView(){
        userEdt = findViewById(R.id.editTextText2);
        passEdt = findViewById(R.id.editTextTexPassword);
        loginBtn = findViewById(R.id.loginBtn);
    }

    private void setVariable(){
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userEdt.getText().toString().isEmpty() || passEdt.getText().toString().isEmpty()){
                    Toast.makeText(LoginActivity.this, "Please fill the login form!", Toast.LENGTH_SHORT).show();
                }else if (userEdt.getText().toString().equals("user")&& passEdt.getText().toString().equals("12345")){
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }
            }
        });
    }
}