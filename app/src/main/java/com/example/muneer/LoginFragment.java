package com.example.muneer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class LoginFragment extends AppCompatActivity {
    EditText email,password;
    Button loginBtn;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_fragment);
        email=findViewById(R.id.et_email);
        password=findViewById(R.id.et_password);
        loginBtn=findViewById(R.id.btn_login);
        progressBar=findViewById(R.id.)

    }
}
