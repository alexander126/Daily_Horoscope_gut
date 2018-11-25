package com.example.alex.daily_horoscope;


import android.content.Context;

/**
 * Created by Alex on 4/13/2017.
 */

class MyApp extends MainActivity{

    private static Context mContext;

    public void onCreate(){
        mContext = this.getApplicationContext();
    }

    public static Context getAppContext(){
        return mContext;
    }
}
