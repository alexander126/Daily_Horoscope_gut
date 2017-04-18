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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import android.graphics.Typeface;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.text.InputType;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.DatePicker;
import android.widget.EditText;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


public class profile_activity extends AppCompatActivity {
    //---Setting public proerty for variables inherited in Main Activity---//
    private Context cnt;
    public EditText editText;
    SharedPreferences m_Text;
    ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_activity);
        cnt = this;
        int theme;
        if (Build.VERSION.SDK_INT < 23) theme = AlertDialog.THEME_HOLO_DARK;
        else theme = android.R.style.Theme_Holo_Light;
        final EditText input = new EditText(this);
        final SharedPreferences.Editor editor = getSharedPreferences("name", MODE_PRIVATE).edit();
        SharedPreferences prefs = getSharedPreferences("name", MODE_PRIVATE);

        if(isFirstTime()){
            ContextThemeWrapper wrapper = new ContextThemeWrapper(cnt ,theme);
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
                String value = input.getText().toString();
                editor.putString("myname",input.getText().toString());
                editor.commit();

            }

        });

        builder.show();}
        //--Name from the input + date--//
        long date = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("MM dd, yyyy");
        String dateString = sdf.format(date);
        //--Setting zodiac sign value--//
        String sign = "";
        Calendar myCalendar = Calendar.getInstance();
        int month = myCalendar.get(Calendar.MONTH);
        int day = myCalendar.get(Calendar.DAY_OF_MONTH);
        month = month + 1;
        if ((month == 12 && day >= 22 && day <= 31) || (month == 1 && day >= 1 && day <= 19)){
            sign = "Capricorn";
        }
        else if ((month == 1 && day >= 20 && day <= 31) || (month == 2 && day >= 1 && day <= 17)){
            sign = "Aquarius";
        }
        else if ((month == 2 && day >= 18 && day <= 29) || (month == 3 && day >= 1 && day <= 19)) {
            sign = "Pisces";
        }
        else if ((month == 3 && day >= 20 && day <= 31) || (month == 4 && day >= 1 && day <= 19)) {
            sign = "Aries";
        }
        else if ((month == 4 && day >= 20 && day <= 30) || (month == 5 && day >= 1 && day <= 20)) {
            sign = "Taurus";
        }
        else if ((month == 5 && day >= 21 && day <= 31) || (month == 6 && day >= 1 && day <= 20)) {
            sign = "Gemini";
        }
        else if ((month == 6 && day >= 21 && day <= 30) || (month == 7 && day >= 1 && day <= 22)) {
            sign = "Cancer";
        }
        else if ((month == 7 && day >= 23 && day <= 31) || (month == 8 && day >= 1 && day <= 22)) {
            sign = "Leo";
        }
        else if ((month == 8 && day >= 23 && day <= 31) || (month == 9 && day >= 1 && day <= 22)) {
            sign = "Virgo";
        }
        else if ((month == 9 && day >= 23 && day <= 30) || (month == 10 && day >= 1 && day <= 22)) {
            sign = "Libra";
        }
        else if ((month == 10 && day >= 23 && day <= 31) || (month == 11 && day >= 1 && day <= 21)) {
            sign = "Scorpio";
        }
        else if ((month == 11 && day >= 22 && day <= 30) || (month == 12 && day >= 1 && day <= 21)) {
            sign = "Sagittarius";
        }

        String name = prefs.getString("myname","");
        TextView txtv1 = (TextView) findViewById(R.id.textView);
       // TextView txtv2 = (TextView) findViewById(R.id.textView1);
        txtv1.setText("Hello " + name + " welcome to Daily Horoscope, the current date is: " + dateString + ". " +
                "The current zociac sign is " + sign);
        //---Initiallizing the properties used in profile activity---//

        ImageButton btn1 = (ImageButton) findViewById(R.id.btn1);
        ImageButton btn2 = (ImageButton) findViewById(R.id.btn2);
        ImageButton btn3 = (ImageButton) findViewById(R.id.btn3);


        //---Initiallizing functions for each button--//
        btn1.setOnClickListener(saveButtonListener);
        btn2.setOnClickListener(aboutButtonListener);
        btn3.setOnClickListener(exitButtonLitener);






    }

    //--//
    public void makeTag(String tag) {
        String or = m_Text.getString(tag, null);
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("tag", tag);
        editor.apply();

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

            public View.OnClickListener saveButtonListener = new View.OnClickListener(){
                public void onClick(View v) {
                    //---Setting requirements for editText property---//
                    Intent main_activity = new Intent(profile_activity.this,
                        MainActivity.class);
                    startActivity(main_activity);
            }



        };


}
