package com.example.alex.daily_horoscope;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.messaging.FirebaseMessaging;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences settings = getSharedPreferences("prefs", 0);


        if (settings.getBoolean("my_first_time", true)) {
            //the app is being launched for first time, do something
            FirebaseMessaging.getInstance().subscribeToTopic("Horoscope");
            // first time task
            startActivity(new Intent(SplashActivity.this, profile_activity.class));
            finish();
            // record the fact that the app has been started at least once
            settings.edit().putBoolean("my_first_time", false).commit();
        }else{
            startActivity(new Intent(SplashActivity.this, opening.class));

        }

    }
}
