package com.example.muneer;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginFragment extends AppCompatActivity {
    EditText email,password;
    TextView createBtn;
    Button loginBtn;
    ProgressBar progressBar;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_fragment);
        email=findViewById(R.id.et_email);
        password=findViewById(R.id.et_password);
        loginBtn=findViewById(R.id.btn_login);
        createBtn = findViewById(R.id.createText);
        auth=FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.progressBar);



        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = email.getText().toString().trim();
                String Password = password.getText().toString().trim();

                if(TextUtils.isEmpty(Email))
                {
                    email.setError("Email is Required");
                    return;
                }
                if(TextUtils.isEmpty(Password))
                {
                    password.setError("Password is Required");
                }
                progressBar.setVisibility(View.VISIBLE);
               auth.signInWithEmailAndPassword(Email,Password)
                       .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                           @Override
                           public void onComplete(@NonNull Task<AuthResult> task) {
                               if(task.isSuccessful())
                               {
                                   Intent intent = new Intent(LoginFragment.this, Nav_Bottom.class);
                                   intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                   startActivity(intent);
                                   finish();
                               }
                               else
                               {
                                   Toast.makeText(LoginFragment.this, "Authentication failed!", Toast.LENGTH_SHORT).show();
                                   progressBar.setVisibility(View.GONE);
                               }
                           }
                       });

            }
        });

        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Nav_Bottom.class);
                i.putExtra("finish", true);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // To clean up all activities
                startActivity(i);
                finish();
            }
        });


    }
}
