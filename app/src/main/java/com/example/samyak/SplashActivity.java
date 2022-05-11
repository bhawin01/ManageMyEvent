package com.example.samyak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Thread background = new Thread() {
            public void run() {
                try {
                    // Thread will sleep for 1.5 seconds
                    sleep(1*1500);

                    // After 1.5 seconds redirect to another intent
                    Intent i=new Intent(getBaseContext(),LoginActivity.class);
                    startActivity(i);

                    //Remove activity
                    finish();
                } catch (Exception e) {
                }
            }
        };
        // start thread
        background.start();
        setContentView(R.layout.activity_splash);
    }
}
