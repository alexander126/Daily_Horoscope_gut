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

import java.util.Calendar;

/**
 * Created by Alex on 5/9/2017.
 */

public class SettingsFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //BUTTON ABOUT
        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);


        // Rate Button
        findPreference("key4");
        Preference key4 = (Preference) findPreference("key4");
        key4.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(){
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Uri uri = Uri.parse("market://details?id=" + getContext().getPackageName());
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                // To count with Play market backstack, After pressing back button,
                // to taken back to our application, we need to add following flags to intent.
                goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + getContext().getPackageName())));
                }
                return true;
            }
        });
        // About button
        findPreference("key3");
        Preference key3 = (Preference) findPreference("key3");
        key3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Intent aboutIntent = new Intent(getContext(),
                        aboutActivity.class);
                startActivity(aboutIntent);
                return true;
            }
        });
        //BUTTON CHANGEZODIACSIGN
        final Preference key2 = (Preference) findPreference("key2");
        key2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {

                SettingsFragment.super.startActivity(new Intent(getActivity(),carouselPicker.class));
                return true;
            }
        });
        //BUTTON NOTIFICATION

        SwitchPreference sp = (SwitchPreference) findPreference("key1");
        sp.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                if(!((Boolean) newValue)) {

                } else {

                }
                return true;
            }
        });;

    }

}