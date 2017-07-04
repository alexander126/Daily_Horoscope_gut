package com.example.alex.daily_horoscope;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;

/**
 * Created by Alex on 5/9/2017.
 */

public class SettingsFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);
        findPreference("key3");
        Preference key3 = (Preference) findPreference("key3");
        key3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Intent aboutIntent = new Intent(AutoSettings.this,
                        aboutActivity.class);
                startActivity(aboutIntent);
                return true;
            }
        });
    }

}