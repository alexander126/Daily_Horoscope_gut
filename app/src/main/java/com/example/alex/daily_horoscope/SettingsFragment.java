package com.example.alex.daily_horoscope;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.SwitchPreference;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessaging;

import java.util.Calendar;

/**
 * Created by Alex on 5/9/2017.
 */

public class SettingsFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);

        //BUTTON NOTIFICATION

        SwitchPreference sp = (SwitchPreference) findPreference("key1");
        sp.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                if(!((Boolean) newValue)) {
                    FirebaseMessaging.getInstance().unsubscribeFromTopic("Horoscope");
                } else {
                    FirebaseMessaging.getInstance().subscribeToTopic("Horoscope");
                }
                return true;
            }
        });
    }

}