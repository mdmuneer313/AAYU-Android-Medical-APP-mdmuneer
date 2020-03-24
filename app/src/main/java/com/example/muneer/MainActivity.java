package com.example.muneer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
        if(mAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),Dahboard.class));
            finish();
        }

    }
    public void addListenerOnButton() {

        final Context context = this;

        Button loginbutton = (Button) findViewById(R.id.loginbutton);
        Button registerbutton = (Button) findViewById(R.id.registerbutton);

        loginbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, LoginFragment.class);
                startActivity(intent);

            }

        });

        registerbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, RegistrationFragment.class);
                startActivity(intent);

            }

        });

    }
}
