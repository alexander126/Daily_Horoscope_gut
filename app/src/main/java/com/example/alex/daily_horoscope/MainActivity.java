/**
 * The MainActivity class is used for providing
 * functionality to the Main Page of Daily
 * Horoscope Application. The Main Activity
 * class inherits some properties from
 * profile_activity class
 *
 * @author  Aleksandar Kalapsazov
 * @version 1.0
 * @since   2017-03-18
 */
package com.example.alex.daily_horoscope;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageButton;
import android.widget.Toast;
import android.content.Intent;
import android.widget.TextView;
import android.view.Gravity;
import android.graphics.Typeface;

public class MainActivity extends profile_activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //---Setting property for greeting message and styling it a bit---//
        TextView textOut;
        textOut = (TextView) findViewById(R.id.textView2);
        textOut.setTextColor(Color.parseColor("#FFFFFF"));
        textOut.setGravity(Gravity.CENTER);
        textOut.setTextSize(getResources().getDimension(R.dimen.textsize));
        textOut.setTypeface(null, Typeface.BOLD_ITALIC);
        textOut.setText("Hello " + editText.getText() + ", pick one of the zodiac symbols below " +
                "to find out what the stars are holding for you today!");
        //---Initiallize properties for all of the buttons used in the Main Activity Page ---/
               ImageButton aquaButton;
        aquaButton =  (ImageButton) findViewById(R.id.bAquarius);
        ImageButton piscesButton;
        piscesButton = (ImageButton) findViewById(R.id.bPisces);
        ImageButton ariesButton;
        ariesButton = (ImageButton) findViewById(R.id.bAries);
        ImageButton taurusButton;
        taurusButton =  (ImageButton) findViewById(R.id.bTaurs);
        ImageButton geminiButton;
        geminiButton =  (ImageButton) findViewById(R.id.bGemini);
        ImageButton cancerButton;
        cancerButton =  (ImageButton) findViewById(R.id.bCancer);
        ImageButton leoButton;
        leoButton =  (ImageButton) findViewById(R.id.bLeo);
        ImageButton virgoButton;
        virgoButton =  (ImageButton) findViewById(R.id.bVirgo);
        ImageButton libraButton;
        libraButton =  (ImageButton) findViewById(R.id.bLibra);
        ImageButton scorpioButton;
        scorpioButton =  (ImageButton) findViewById(R.id.bScorpio);
        ImageButton sagittariusButton;
        sagittariusButton =  (ImageButton) findViewById(R.id.bSagittarius);
        ImageButton capriButton;
        capriButton =  (ImageButton) findViewById(R.id.bCapricorn);

        //---Setting actions for each button when pressed---/

        aquaButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent aquaActivity = new Intent(MainActivity.this,
                        aqua_Activity.class);
                startActivity(aquaActivity);
            }
        });
        piscesButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent piscesActivity = new Intent(MainActivity.this,
                        pisces_activity.class);
                startActivity(piscesActivity);
            }
        });
        ariesButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent ariesActivity = new Intent(MainActivity.this,
                        aries_activity.class);
                startActivity(ariesActivity);
            }
        });
        taurusButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent taurusActivity = new Intent(MainActivity.this,
                        taurus_activity.class);
                startActivity(taurusActivity);
            }
        });
        geminiButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent geminiActivity = new Intent(MainActivity.this,
                        gemini_activity.class);
                startActivity(geminiActivity);
            }
        });
        cancerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent cancerActivity = new Intent(MainActivity.this,
                        cancer_activity.class);
                startActivity(cancerActivity);
            }
        });
        leoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent leoActivity = new Intent(MainActivity.this,
                        leo_activity.class);
                startActivity(leoActivity);
            }
        });
        virgoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent virgoActivity = new Intent(MainActivity.this,
                        virgo_activity.class);
                startActivity(virgoActivity);
            }
        });
        libraButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent libraActivity = new Intent(MainActivity.this,
                        libra_activity.class);
                startActivity(libraActivity);
            }
        });
        scorpioButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent scorpioActivity = new Intent(MainActivity.this,
                        scorpio_activity.class);
                startActivity(scorpioActivity);
            }
        });
        sagittariusButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent sagittActivity = new Intent(MainActivity.this,
                        sagittarius_activity.class);
                startActivity(sagittActivity);
            }
        });
        capriButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent capriActivity = new Intent(MainActivity.this,
                        capricorn_activity.class);
                startActivity(capriActivity);
            }
        });




    }


}
