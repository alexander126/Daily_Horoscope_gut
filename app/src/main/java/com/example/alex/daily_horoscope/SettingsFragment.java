package com.example.alex.daily_horoscope;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.view.ContextThemeWrapper;
import android.text.InputType;
import android.widget.EditText;
import android.widget.Toast;

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
                Intent aboutIntent = new Intent(getContext(),
                        aboutActivity.class);
                startActivity(aboutIntent);
                return true;
            }
        });

        SharedPreferences preferences = getContext().getSharedPreferences("name", android.content.Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = preferences.edit();
        final Preference key2 = (Preference) findPreference("key2");
        key2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                int theme;
                if (Build.VERSION.SDK_INT < 23) theme = AlertDialog.THEME_HOLO_DARK;
                else theme = android.R.style.Theme_Holo_Light;
                final EditText input = new EditText(getContext());
                ContextThemeWrapper wrapper = new ContextThemeWrapper(getContext(), theme);
                AlertDialog.Builder builder = new AlertDialog.Builder(wrapper);
                builder.setTitle("Enter your name");


                // Set up the input
                // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);


                // Set up the buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        editor.remove("myname");
                        editor.putString("myname", input.getText().toString());
                        editor.commit();
                        Toast toast = Toast.makeText(getContext(), "Restart the application", Toast.LENGTH_SHORT);
                        toast.show();
                    }

                });

                builder.show();
                return true;
            }
        });
    }

}