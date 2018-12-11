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
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.content.Intent;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity  {
    private static Context mContext;
    private LinearLayout l1,l2,l3,l4;
    private ImageButton info;
    Animation uptodown,downtoup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this.getApplicationContext();
        Typeface typeface = Typeface.createFromAsset(this.getAssets(), "fonts/AdventPro-Light.ttf");



        l1 = (LinearLayout)findViewById(R.id.line1);
        l2 = (LinearLayout)findViewById(R.id.line2);
        l3 = (LinearLayout)findViewById(R.id.line3);
        l4 = (LinearLayout)findViewById(R.id.line4);

        uptodown = AnimationUtils.loadAnimation(this, R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this, R.anim.downtoup);

        l1.setAnimation(uptodown);
        l2.setAnimation(uptodown);
        l3.setAnimation(downtoup);
        l4.setAnimation(downtoup);


// TODO: Add adView to your view hierarchy.
        //---Setting property for greeting message and styling it a bit---//

        //---Initiallize properties for all of the buttons used in the Main Activity Page ---/
        info = (ImageButton) findViewById(R.id.info);
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

        //prefferences for activities
        SharedPreferences sharedPref = getSharedPreferences("prefs",MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPref.edit();
        //---Setting actions for each button when pressed---/
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, getString(R.string.zodiacDates  ), Toast.LENGTH_LONG).show();

            }
        });

        aquaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("key","aquarius");
                editor.commit();
                Intent aquaActivity = new Intent(MainActivity.this,
                        oneForAll.class);
                startActivity(aquaActivity);
            }
        });
        piscesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("key","pisces");
                editor.commit();
                Intent piscesActivity = new Intent(MainActivity.this,
                        oneForAll.class);
                startActivity(piscesActivity);
            }
        });
        ariesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("key","aries");
                editor.commit();
                Intent ariesActivity = new Intent(MainActivity.this,
                        oneForAll.class);
                startActivity(ariesActivity);
            }
        });
        taurusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("key","taurus");
                editor.commit();
                Intent taurusActivity = new Intent(MainActivity.this,
                        oneForAll.class);
                startActivity(taurusActivity);
            }
        });
        geminiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("key","gemini");
                editor.commit();
                Intent geminiActivity = new Intent(MainActivity.this,
                        oneForAll.class);
                startActivity(geminiActivity);
            }
        });
        cancerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("key","cancer");
                editor.commit();
                Intent cancerActivity = new Intent(MainActivity.this,
                        oneForAll.class);
                startActivity(cancerActivity);
            }
        });
        leoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("key","leo");
                editor.commit();
                Intent leoActivity = new Intent(MainActivity.this,
                        oneForAll.class);
                startActivity(leoActivity);
            }
        });
        virgoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("key","virgo");
                editor.commit();
                Intent virgoActivity = new Intent(MainActivity.this,
                        oneForAll.class);
                startActivity(virgoActivity);
            }
        });
        libraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("key","libra");
                editor.commit();
                Intent libraActivity = new Intent(MainActivity.this,
                        oneForAll.class);
                startActivity(libraActivity);
            }
        });
        scorpioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("key","scorpio");
                editor.commit();
                Intent scorpioActivity = new Intent(MainActivity.this,
                        oneForAll.class);
                startActivity(scorpioActivity);
            }
        });
        sagittariusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("key","sagittarius");
                editor.commit();
                Intent sagittActivity = new Intent(MainActivity.this,
                        oneForAll.class);
                startActivity(sagittActivity);
            }
        });
        capriButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("key","capricorn");
                editor.commit();
                Intent capriActivity = new Intent(MainActivity.this,
                        oneForAll.class);
                startActivity(capriActivity);
            }
        });
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MainActivity.this,opening.class);
        startActivity(intent);
    }



}


