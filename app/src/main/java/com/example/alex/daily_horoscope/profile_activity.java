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
import android.content.SharedPreferences;
import java.util.Calendar;

import android.os.Build;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    public EditText editText;
    SharedPreferences savedname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_activity);

        //---Initiallizing the properties used in profile activity---//
        editText = (EditText) findViewById(R.id.name);
        savedname = getSharedPreferences("notes", MODE_PRIVATE);
        Button dbtn1 = (Button) findViewById(R.id.dbut);
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
    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {
        Calendar myCalendar = Calendar.getInstance();
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker

            int year = myCalendar.get(Calendar.YEAR);
            int month = myCalendar.get(Calendar.MONTH);
            int day = myCalendar.get(Calendar.DAY_OF_MONTH);

            // Create a new instance o f DatePickerDialog and return it
            int theme;
            if (Build.VERSION.SDK_INT < 23) theme = AlertDialog.THEME_HOLO_DARK;
            else theme = android.R.style.Theme_Holo_Dialog;
            return new DatePickerDialog(getActivity(),theme, this, year, month, day);

        }

        String message;
        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            month = month+1;
            if      ((month == 12 && day >= 22 && day <= 31) || (month ==  1 && day >= 1 && day <= 19))
                message =  "Capricorn";
            else if ((month ==  1 && day >= 20 && day <= 31) || (month ==  2 && day >= 1 && day <= 17))
                message = "Aquarius";
            else if ((month ==  2 && day >= 18 && day <= 29) || (month ==  3 && day >= 1 && day <= 19))
                message =  "Pisces";
            else if ((month ==  3 && day >= 20 && day <= 31) || (month ==  4 && day >= 1 && day <= 19))
                message =  "Aries";
            else if ((month ==  4 && day >= 20 && day <= 30) || (month ==  5 && day >= 1 && day <= 20))
                message =  "Taurus";
            else if ((month ==  5 && day >= 21 && day <= 31) || (month ==  6 && day >= 1 && day <= 20))
                message =  "Gemini";
            else if ((month ==  6 && day >= 21 && day <= 30) || (month ==  7 && day >= 1 && day <= 22))
                message =  "Cancer";
            else if ((month ==  7 && day >= 23 && day <= 31) || (month ==  8 && day >= 1 && day <= 22))
                message =  "Leo";
            else if ((month ==  8 && day >= 23 && day <= 31) || (month ==  9 && day >= 1 && day <= 22))
                message =  "Virgo";
            else if ((month ==  9 && day >= 23 && day <= 30) || (month == 10 && day >= 1 && day <= 22))
                message =  "Libra";
            else if ((month == 10 && day >= 23 && day <= 31) || (month == 11 && day >= 1 && day <= 21))
                message =  "Scorpio";
            else if ((month == 11 && day >= 22 && day <= 30) || (month == 12 && day >= 1 && day <= 21))
                message =  "Sagittarius";
            else
                System.out.println("Illegal date");
            Toast toast = Toast.makeText(getContext(),message, Toast.LENGTH_SHORT);
            toast.show();
        }
    }
        public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
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
