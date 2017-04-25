/**
 * The MainActivity class is used for providing
 * functionality to the Main Page of Daily
 * Horoscope Application. The Main Activity
 * class inherits some properties from
 * profile_activity class
 *
 * @author Aleksandar Kalapsazov
 * @version 1.0
 * @since 2017-03-18
 */
package com.example.alex.daily_horoscope;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageButton;
import android.widget.Toast;
import android.content.Intent;
import android.widget.TextView;
import android.view.Gravity;
import android.graphics.Typeface;

import java.io.IOException;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private static Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this.getApplicationContext();
        //---Setting property for greeting message and styling it a bit---//

        //---Initiallize properties for all of the buttons used in the Main Activity Page ---/
        ImageButton aquaButton;
        aquaButton = (ImageButton) findViewById(R.id.bAquarius);
        ImageButton piscesButton;
        piscesButton = (ImageButton) findViewById(R.id.bPisces);
        ImageButton ariesButton;
        ariesButton = (ImageButton) findViewById(R.id.bAries);
        ImageButton taurusButton;
        taurusButton = (ImageButton) findViewById(R.id.bTaurs);
        ImageButton geminiButton;
        geminiButton = (ImageButton) findViewById(R.id.bGemini);
        ImageButton cancerButton;
        cancerButton = (ImageButton) findViewById(R.id.bCancer);
        ImageButton leoButton;
        leoButton = (ImageButton) findViewById(R.id.bLeo);
        ImageButton virgoButton;
        virgoButton = (ImageButton) findViewById(R.id.bVirgo);
        ImageButton libraButton;
        libraButton = (ImageButton) findViewById(R.id.bLibra);
        ImageButton scorpioButton;
        scorpioButton = (ImageButton) findViewById(R.id.bScorpio);
        ImageButton sagittariusButton;
        sagittariusButton = (ImageButton) findViewById(R.id.bSagittarius);
        ImageButton capriButton;
        capriButton = (ImageButton) findViewById(R.id.bCapricorn);

        //---Setting actions for each button when pressed---/

        aquaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aquaActivity = new Intent(MainActivity.this,
                        aqua_Activity.class);
                startActivity(aquaActivity);
            }
        });
        piscesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent piscesActivity = new Intent(MainActivity.this,
                        pisces_activity.class);
                startActivity(piscesActivity);
            }
        });
        ariesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ariesActivity = new Intent(MainActivity.this,
                        aries_activity.class);
                startActivity(ariesActivity);
            }
        });
        taurusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent taurusActivity = new Intent(MainActivity.this,
                        taurus_activity.class);
                startActivity(taurusActivity);
            }
        });
        geminiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent geminiActivity = new Intent(MainActivity.this,
                        gemini_activity.class);
                startActivity(geminiActivity);
            }
        });
        cancerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cancerActivity = new Intent(MainActivity.this,
                        cancer_activity.class);
                startActivity(cancerActivity);
            }
        });
        leoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent leoActivity = new Intent(MainActivity.this,
                        leo_activity.class);
                startActivity(leoActivity);
            }
        });
        virgoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent virgoActivity = new Intent(MainActivity.this,
                        virgo_activity.class);
                startActivity(virgoActivity);
            }
        });
        libraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent libraActivity = new Intent(MainActivity.this,
                        libra_activity.class);
                startActivity(libraActivity);
            }
        });
        scorpioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent scorpioActivity = new Intent(MainActivity.this,
                        scorpio_activity.class);
                startActivity(scorpioActivity);
            }
        });
        sagittariusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sagittActivity = new Intent(MainActivity.this,
                        sagittarius_activity.class);
                startActivity(sagittActivity);
            }
        });
        capriButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent capriActivity = new Intent(MainActivity.this,
                        capricorn_activity.class);
                startActivity(capriActivity);
            }
        });
    }
    //--Initializing static methods for navigation--//
    public static void goToCapriAct() {
        Intent capriacti = new Intent(mContext, capricorn_activity.class);
        capriacti.addFlags(capriacti.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(capriacti);

    }

    private static void goToAquaAct() {
        Intent aquaacti = new Intent(mContext, aqua_Activity.class);
        aquaacti.addFlags(aquaacti.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(aquaacti);
    }

    private static void goToPiscAct() {
        Intent piscacti = new Intent(mContext, pisces_activity.class);
        piscacti.addFlags(piscacti.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(piscacti);
    }

    private static void goToAriesAct() {
        Intent ariesacti = new Intent(mContext, aries_activity.class);
        ariesacti.addFlags(ariesacti.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(ariesacti);
    }

    public static void goToTaurAct() {
        Intent taursacti = new Intent(mContext, taurus_activity.class);
        taursacti.addFlags(taursacti.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(taursacti);
    }

    private static void goToGeminiAct() {
        Intent geminiacti = new Intent(mContext, gemini_activity.class);
        geminiacti.addFlags(geminiacti.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(geminiacti);
    }

    private static void goToCancAct() {
        Intent cancacti = new Intent(mContext, cancer_activity.class);
        cancacti.addFlags(cancacti.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(cancacti);
    }

    private static void goToLeoAct() {
        Intent leoacti = new Intent(mContext, leo_activity.class);
        leoacti.addFlags(leoacti.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(leoacti);
    }

    private static void goToVirgoAct() {
        Intent virgoacti = new Intent(mContext, virgo_activity.class);
        mContext.startActivity(virgoacti);
    }

    private static void goToLibraAct() {
        Intent libraacti = new Intent(mContext, libra_activity.class);
        libraacti.addFlags(libraacti.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(libraacti);
    }

    private static void goToScorpAct() {
        Intent scorpacti = new Intent(mContext, scorpio_activity.class);
        scorpacti.addFlags(scorpacti.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(scorpacti);
    }

    private static void goToSaggAct() {
        Intent saggacti = new Intent(mContext, sagittarius_activity.class);
        saggacti.addFlags(saggacti.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(saggacti);
    }

    //--Setting DatePickerFragment--//
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
            theme = android.R.style.Theme_Holo_Dialog;
            return new DatePickerDialog(getActivity(), theme, this, year, month, day);

        }

        //--Checks about every single sign and navigation--//
        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            month = month + 1;
            if ((month == 12 && day >= 22 && day <= 31) || (month == 1 && day >= 1 && day <= 19)) {
                goToCapriAct();
            } else if ((month == 1 && day >= 20 && day <= 31) || (month == 2 && day >= 1 && day <= 17)) {
                goToAquaAct();
            } else if ((month == 2 && day >= 18 && day <= 29) || (month == 3 && day >= 1 && day <= 19)) {
                goToPiscAct();
            } else if ((month == 3 && day >= 20 && day <= 31) || (month == 4 && day >= 1 && day <= 19)) {
                goToAriesAct();
            } else if ((month == 4 && day >= 20 && day <= 30) || (month == 5 && day >= 1 && day <= 20)) {
                goToTaurAct();
            } else if ((month == 5 && day >= 21 && day <= 31) || (month == 6 && day >= 1 && day <= 20)) {
                goToGeminiAct();
            } else if ((month == 6 && day >= 21 && day <= 30) || (month == 7 && day >= 1 && day <= 22)) {
                goToCancAct();
            } else if ((month == 7 && day >= 23 && day <= 31) || (month == 8 && day >= 1 && day <= 22)) {
                goToLeoAct();
            } else if ((month == 8 && day >= 23 && day <= 31) || (month == 9 && day >= 1 && day <= 22)) {
                goToVirgoAct();
            } else if ((month == 9 && day >= 23 && day <= 30) || (month == 10 && day >= 1 && day <= 22)) {
                goToLibraAct();
            } else if ((month == 10 && day >= 23 && day <= 31) || (month == 11 && day >= 1 && day <= 21)) {
                goToScorpAct();
            } else if ((month == 11 && day >= 22 && day <= 30) || (month == 12 && day >= 1 && day <= 21)) {
                goToSaggAct();
            } else {
                System.out.println("Illegal date");
            }
        }
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new MainActivity.DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
}


