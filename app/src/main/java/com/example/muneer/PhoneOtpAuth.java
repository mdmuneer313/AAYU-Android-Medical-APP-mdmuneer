package com.example.muneer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class PhoneOtpAuth extends AppCompatActivity {
EditText otptext,phonetext;
Button otpBtn,verifyBtn;
int randomNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_otp_auth);

        otptext=findViewById(R.id.et_otp);
        phonetext=findViewById(R.id.et_phone);
        otpBtn=findViewById(R.id.btn_otp);
        verifyBtn=findViewById(R.id.btn_verify);

        phonetext.setText(""+getIntent().getStringExtra("PHONE"));

        otpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    // Construct data
                    String apiKey = "apikey=" + "AbFg8n5i5nc-I54kyr36QpSFFRZtEl8zobzbBDMr2e";
                    Random random= new Random();
                    randomNumber=random.nextInt(999999);
                    String message = "&message=" + "Your OTP is:"+randomNumber;
                    String sender = "&sender=" + "Muneer Project";
                    String numbers = "&numbers=" + phonetext.getText().toString();

                    // Send data
                    HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
                    String data = apiKey + numbers + message + sender;
                    conn.setDoOutput(true);
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
                    conn.getOutputStream().write(data.getBytes("UTF-8"));
                    final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    final StringBuffer stringBuffer = new StringBuffer();
                    String line;
                    while ((line = rd.readLine()) != null) {
                        stringBuffer.append(line);
                    }
                    rd.close();
                    Toast.makeText( getApplicationContext(),"OTP SENT SUCESSFULL", Toast.LENGTH_SHORT).show();
                    otptext.setVisibility(View.VISIBLE);
                   otpBtn.setVisibility(View.GONE);
                    //return stringBuffer.toString();
                } catch (Exception e) {
                    Toast.makeText( getApplicationContext(),"Error SMS"+e, Toast.LENGTH_SHORT).show();
                    Toast.makeText( getApplicationContext(),"Error "+e, Toast.LENGTH_SHORT).show();
                   // return "Error "+e;
                }
            }
        });
verifyBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(randomNumber==Integer.valueOf(otptext.getText().toString())){
            Toast.makeText(getApplicationContext(), "Phone no Verifired Sucessfully", Toast.LENGTH_LONG).show();
            Intent in = new Intent(getApplicationContext(),Nav_Bottom.class);
            startActivity(in);
        }else{
            Toast.makeText(getApplicationContext(), "WRONG OTP", Toast.LENGTH_LONG).show();
        }
    }
});


    }


}
