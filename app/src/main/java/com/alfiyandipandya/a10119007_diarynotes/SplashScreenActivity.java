package com.alfiyandipandya.a10119007_diarynotes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.alfiyandipandya.a10119007_diarynotes.activity.SignInActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent goToSignInActivity = new Intent(SplashScreenActivity.this, SignInActivity.class);
                startActivity(goToSignInActivity);
                finish();
            }
        }, 1000);
    }
}