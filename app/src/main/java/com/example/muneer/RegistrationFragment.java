package com.example.muneer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationFragment extends AppCompatActivity {
    FirebaseAuth mAuth;
    EditText fullname,password,repassword,email,phone;
    Button registerBtn;
    ProgressBar progressBar;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_fragment);
        fullname=findViewById(R.id.et_name);
        email=findViewById(R.id.et_email);
        registerBtn=findViewById(R.id.btn_register);
        password=findViewById(R.id.et_password);
        repassword=findViewById(R.id.et_repassword);
        phone=findViewById(R.id.et_phone);
        mAuth=FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.progressBar);

        if(mAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), Dashboard.class));
            finish();
        }


        registerBtn.setOnClickListener(new View.OnClickListener() {
         @Override
        public void onClick(View v) {
             final String Email = email.getText().toString().trim();
             String Password = password.getText().toString().trim();
             final String FullName = fullname.getText().toString();
             final String Phone    = phone.getText().toString();
             final String Repassword    = repassword.getText().toString();


             if(TextUtils.isEmpty(FullName)){
                 fullname.setError("Password is Required.");
                 return;
             }
             if(TextUtils.isEmpty(Email)){
                 email.setError("Email is Required.");
                 return;
             }

             if(TextUtils.isEmpty(Password)){
                 password.setError("Password is Required.");
                 return;
             }
             if(TextUtils.isEmpty(Phone)){
                 phone.setError("Phone is Required.");
                 return;
             }

             if(Password.length() < 6){
                 password.setError("Password Must be >= 6 Characters");
                 return;
             }
             if(TextUtils.isEmpty(Repassword)){
                 repassword.setError("Re -type-password is Required");
                 return;
             }

             progressBar.setVisibility(View.VISIBLE);
             mAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                 @Override
                 public void onComplete(@NonNull Task<AuthResult> task) {
                     if(task.isSuccessful()){
                         Toast.makeText(RegistrationFragment.this, "User Created.", Toast.LENGTH_SHORT).show();
                         startActivity(new Intent(getApplicationContext(), Dashboard.class));
                     }else {
                         Toast.makeText(RegistrationFragment.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                         progressBar.setVisibility(View.GONE);

                     }
                 }
             });

                }
            }

        );



    }
}
