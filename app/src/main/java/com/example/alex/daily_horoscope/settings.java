package com.example.alex.daily_horoscope;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.text.InputType;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class settings extends AppCompatActivity {
    private Context cnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        cnt=this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ImageButton imgButton = (ImageButton) findViewById(R.id.settingsInfo);
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent about_activity = new Intent(settings.this,
                        aboutActivity.class);
                startActivity(about_activity);
            }
        });

        final CheckBox checkBox = (CheckBox) findViewById(R.id.chbox);

        SharedPreferences preferences = getApplicationContext().getSharedPreferences("name", android.content.Context.MODE_PRIVATE);
        SharedPreferences prefs = getSharedPreferences("name", MODE_PRIVATE);
        final SharedPreferences.Editor editor = preferences.edit();
        if((preferences.contains("checked") && preferences.getBoolean("checked",false)) == true) {
            checkBox.setChecked(true);
        }else {
            checkBox.setChecked(false);

        }
        //The checkbox doesnt work!!!!!!!!!!!!!!!!!
        if(checkBox.isChecked()){
            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            Intent notificationIntent = new Intent("android.media.action.DISPLAY_NOTIFICATION");
            notificationIntent.addCategory("android.intent.category.DEFAULT");

            PendingIntent broadcast = PendingIntent.getBroadcast(this, 0 , notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, 8);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 24*60*60*1000 , broadcast);
        }else{

        }

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(checkBox.isChecked()){
                    editor.putBoolean("checked", true);
                    editor.apply();
                }else{
                    editor.putBoolean("checked", false);
                    editor.apply();
                }

            }

        });

        //TextView for changing the name
        TextView tv = (TextView) findViewById(R.id.changeName);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theme;
                if (Build.VERSION.SDK_INT < 23) theme = AlertDialog.THEME_HOLO_DARK;
                else theme = android.R.style.Theme_Holo_Light;
                final EditText input = new EditText(cnt);
                ContextThemeWrapper wrapper = new ContextThemeWrapper(cnt, theme);
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

                    }

                });

                builder.show();
            }
        });

    }
}
