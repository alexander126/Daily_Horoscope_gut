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

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.content.Intent;


public class MainActivity extends AppCompatActivity  {
    private static Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this.getApplicationContext();

// TODO: Add adView to your view hierarchy.
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

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}


