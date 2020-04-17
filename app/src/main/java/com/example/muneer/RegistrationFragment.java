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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.muddzdev.styleabletoast.StyleableToast;

import java.util.HashMap;

public class RegistrationFragment extends AppCompatActivity {
    public static final String TAG = "TAG";
    FirebaseAuth mAuth;
    EditText fullname,password,repassword,email,phone,username;
    Button registerBtn;
    ProgressBar progressBar;
    FirebaseAuth auth;
    DatabaseReference reference;
    TextView LoginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_fragment);
        username=findViewById(R.id.et_username);
        fullname=findViewById(R.id.et_name);
        email=findViewById(R.id.et_email);
        registerBtn=findViewById(R.id.btn_register);
        password=findViewById(R.id.et_password);
        repassword=findViewById(R.id.et_repassword);
        phone=findViewById(R.id.et_phone);
        auth=FirebaseAuth.getInstance();
        LoginBtn=findViewById(R.id.createText);
        //fStore = FirebaseFirestore.getInstance();
        progressBar=findViewById(R.id.progressBar);


        registerBtn.setOnClickListener(new View.OnClickListener() {
         @Override
        public void onClick(View v) {
             final String Email = email.getText().toString().trim();
             String Password = password.getText().toString().trim();
             final  String Username=username.getText().toString();
             final String FullName = fullname.getText().toString();
             final String Phone    = phone.getText().toString();
             final String Repassword    = repassword.getText().toString();

             if(Password.length() < 6) {
                 StyleableToast.makeText(RegistrationFragment.this, "Password Must be >= 6 Characters",R.style.exampleToast).show();

             }
             else if(TextUtils.isEmpty(FullName))
             {
                 StyleableToast.makeText(RegistrationFragment.this, "fullname is Required ", R.style.exampleToast).show();
             }
             else if(TextUtils.isEmpty(Email))
             {
                 StyleableToast.makeText(RegistrationFragment.this, "Email is Required ", R.style.exampleToast).show();
             }
             else if(TextUtils.isEmpty(Username))
             {
                 StyleableToast.makeText(RegistrationFragment.this, "Username is Required ",R.style.exampleToast).show();
             }
             else if(TextUtils.isEmpty(Phone))
             {
                 StyleableToast.makeText(RegistrationFragment.this, "phone is Required ", R.style.exampleToast).show();
             }
             else if(Phone.length()!=13)
             {
                 StyleableToast.makeText(RegistrationFragment.this, "Phone should be of 13 digits ", R.style.exampleToast).show();
             }
             else if(TextUtils.isEmpty(Password))
             {
                 StyleableToast.makeText(RegistrationFragment.this, "password is Required  ", R.style.exampleToast).show();
             }
             else if(TextUtils.isEmpty(Repassword)){
                 StyleableToast.makeText(RegistrationFragment.this, "Please confirm your password...", R.style.exampleToast).show();
             }
             else if(!Password.equals(Repassword)){
                 StyleableToast.makeText(RegistrationFragment.this, "your password do not match with your confirm password...", R.style.exampleToast).show();
             }
             else
             {
                 progressBar.setVisibility(View.VISIBLE);
                 auth.createUserWithEmailAndPassword(Email, Password)
                         .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                             @Override
                             public void onComplete(@NonNull Task<AuthResult> task) {
                                 if(task.isSuccessful())
                                 {
                                     FirebaseUser firebaseUser=auth.getCurrentUser();
                                     assert firebaseUser != null;
                                     String userid = firebaseUser.getUid();

                                     reference = FirebaseDatabase.getInstance().getReference("Users").child(userid);
                                     HashMap<String, String> hashMap = new HashMap<>();
                                     hashMap.put("id", userid);
                                     hashMap.put("username", Username);
                                     hashMap.put("fullname", FullName);
                                     hashMap.put("email", Email);
                                     hashMap.put("phone", Phone);
                                     hashMap.put("search", Username.toLowerCase());
                                     hashMap.put("imageURL", "default");

                                    reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()){
                                                Intent intent = new Intent(RegistrationFragment.this, Nav_Bottom.class);
                                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                startActivity(intent);
                                                finish();
                                            }
                                        }
                                    });
                                 }
                                 else
                                 {
                                     Toast.makeText(RegistrationFragment.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                 }
                             }
                         });

             }
                }
            }
        );

        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),LoginFragment.class));
            }
        });


    }
}
