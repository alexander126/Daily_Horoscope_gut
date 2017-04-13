/**
 * The profile_activity class is used for functionality
 * to the profile page of the Daily Horoscope Application
 *
 * @author  Aleksandar Kalapsazov
 * @version 1.0
 * @since   2017-03-18
 */
package com.example.alex.daily_horoscope;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import java.util.Calendar;

import android.os.Build;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.DatePicker;
import android.widget.EditText;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.Toast;


public class profile_activity extends AppCompatActivity {
    //---Setting public proerty for variables inherited in Main Activity---//
    private Context cnt;
    private String m_Text = "";
    public EditText editText;
    SharedPreferences savedname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_activity);
        cnt = this;
        //
        if(isFirstTime()){
        AlertDialog.Builder builder = new AlertDialog.Builder(cnt);
        builder.setTitle("Title");

        // Set up the input
        final EditText input = new EditText(cnt);
        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                m_Text = input.getText().toString();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();}

        //---Initiallizing the properties used in profile activity---//
        editText = (EditText) findViewById(R.id.name);
        savedname = getSharedPreferences("notes", MODE_PRIVATE);
        ImageButton btn1 = (ImageButton) findViewById(R.id.btn1);
        ImageButton btn2 = (ImageButton) findViewById(R.id.btn2);
        ImageButton btn3 = (ImageButton) findViewById(R.id.btn3);

        editText.setText(savedname.getString("tag",null));
        //---Initiallizing functions for each button--//
        btn1.setOnClickListener(saveButtonListener);
        btn2.setOnClickListener(aboutButtonListener);
        btn3.setOnClickListener(exitButtonLitener);


    }
    //---Creating public function for notifications---//
    public void notificationcall(){
        //---Setting parameters to the notification---//
        NotificationCompat.Builder notifBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setSmallIcon(R.drawable.notificaion_icon)
                .setTicker("Alert New Message")
                .setContentTitle("Goodbye!")
                .setContentText("It was nice having you today! Come back tomorrow for your new horoscope!")
                .setAutoCancel(true);
        //---Giving funcionality to the notification---//
        Intent resultIntent = new Intent(this, MainActivity.class);
        //---Back stack supporting navigation of the notification---//
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        notifBuilder.setContentIntent(resultPendingIntent);
        //---Building the application---//
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, notifBuilder.build());


    }

    private boolean isFirstTime()
    {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        boolean ranBefore = preferences.getBoolean("RanBefore", false);
        if (!ranBefore) {
            // first time
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("RanBefore", true);
            editor.apply();
        }
        return !ranBefore;
    }
            public View.OnClickListener exitButtonLitener = new View.OnClickListener(){
                    public void onClick(View v){
                        notificationcall();
                        finish();
                        System.exit(0);
                    }
            };
            public View.OnClickListener aboutButtonListener = new View.OnClickListener(){
                    public void onClick(View v){
                        Intent about_activity = new Intent (profile_activity.this,
                                aboutActivity.class);
                        startActivity(about_activity);
                    }
            };
            public void makeTag(String tag){
                String or = savedname.getString(tag, null);
                SharedPreferences.Editor preferencesEditor = savedname.edit();
                preferencesEditor.putString("tag",tag);
                preferencesEditor.apply();
            }

            public View.OnClickListener saveButtonListener = new View.OnClickListener(){
                public void onClick(View v) {
                    //---Setting requirements for editText property---//
                    if (editText.getText().length()>0){
                        makeTag(editText.getText().toString());
                        ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                                .hideSoftInputFromWindow(editText.getWindowToken(),0);
                    Intent main_activity = new Intent(profile_activity.this,
                        MainActivity.class);
                    startActivity(main_activity);
            }



        }
    };

}
