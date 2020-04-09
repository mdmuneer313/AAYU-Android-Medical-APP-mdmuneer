package com.example.muneer;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;


public class SplashActivity extends AppCompatActivity {
    private ProgressBar mProgress;
    private ImageView mImageview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mProgress =  findViewById(R.id.splash_id);
        mImageview=findViewById(R.id.splash_logo);
        Animation myanim= AnimationUtils.loadAnimation(this,R.anim.mytransitation);
        mImageview.startAnimation(myanim);
        new Thread(new Runnable() {
            public void run() {
                doWork();
                startApp();
                finish();
            }
        }).start();
    }
    /*style="@android:style/Widget.DeviceDefault.ProgressBar.Horizontal"* for horizontal progress bar*/
    private void doWork() {
        for (int progress=0; progress<100; progress+=10) {
            try {
                Thread.sleep(1000);
                mProgress.setProgress(progress);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void startApp() {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
