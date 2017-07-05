package com.example.alex.daily_horoscope;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.SwitchPreference;
import android.support.v7.view.ContextThemeWrapper;
import android.text.InputType;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

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
        //BUTTON CHANGENAME
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
        //BUTTON NOTIFICATION
        final AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
        final Intent notificationIntent = new Intent("android.media.action.DISPLAY_NOTIFICATION");
        final PendingIntent broadcast = PendingIntent.getBroadcast(getContext(), 0 , notificationIntent, 0);

        notificationIntent.addCategory("android.intent.category.DEFAULT");
        SwitchPreference sp = (SwitchPreference) findPreference("key1");
        sp.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                if(!((Boolean) newValue)) {


                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.HOUR_OF_DAY, 8);
                    calendar.set(Calendar.MINUTE, 0);
                    calendar.set(Calendar.SECOND, 0);
                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 24*60*60*1000 , broadcast);
                } else {

                    alarmManager.cancel(broadcast);
                }
                return true;
            }
        });;

    }

}