package com.example.alex.daily_horoscope;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

public class opening extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ImageView profile;
    private String info;
    private TextView textView;
    private TextView dateZodiac;
    private Button all;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);


        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(GravityCompat.START);
            }
        });
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        RequestQueue queue = Volley.newRequestQueue(this);

        all = (Button)findViewById(R.id.all);
        textView = (TextView)findViewById(R.id.textView);
        dateZodiac = (TextView)findViewById(R.id.currentDate);


        //alarmReceiver
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 17);
        calendar.set(Calendar.MINUTE, 25);
        calendar.set(Calendar.SECOND, 0);

        Intent notifyIntent = new Intent(this,AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,  calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, pendingIntent);

        //Typeface Textviews
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/AdventPro-Light.ttf");
        textView.setTypeface(typeface);
        dateZodiac.setTypeface(typeface);

        //sharedPrefs getting name of the image
        SharedPreferences sharedPref = getSharedPreferences("prefs", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPref.edit();
        profile = (ImageView)findViewById(R.id.profile);
        info = sharedPref.getString("sign","null");

        //set the imageView
        Context c = getApplicationContext();
        int id = c.getResources().getIdentifier("drawable/"+info, null, c.getPackageName());
        profile.setImageResource(id);

        //going in the profile's zodiac activity
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editor.putString("key",info);
                editor.commit();
                startActivity(new Intent(opening.this,oneForAll.class));

            }
        });

        //set the button functionality
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(opening.this,MainActivity.class));
            }
        });
        //set the textView
        String url = "https://aztro.sameerkumar.website/?sign="+info+"&day=today";
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.d("Response", response);
                        try {

                            JSONObject jObj = new JSONObject(response);
                            String horoscope = jObj.getString("date_range") + "\n\n";
                            String dateZ = "Today is: " + jObj.getString("current_date") + "\n\n" + "Your zodiac sign is:";
                            dateZodiac.setText(dateZ);
                            textView.setText(horoscope);

                        } catch (JSONException e) {
                            Log.e("MYAPP", "unexpected JSON exception", e);
                            // Do something to recover ... or kill the app.
                        }

                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.d("Error.Response", error.toString());
                    }
                }
        );
        queue.add(postRequest);


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME );
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.opening, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = R.id.action_settings;

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {


        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

       if (id == R.id.zodiacSign) {
            Intent intent = new Intent(opening.this,carouselPicker.class);
            startActivity(intent);
        } else if (id == R.id.notifications) {
            Intent intent = new Intent(opening.this,AutoSettings.class);
            startActivity(intent);
        } else if (id == R.id.rate) {
            Uri uri = Uri.parse("market://details?id=" + this.getPackageName());
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
                        Uri.parse("http://play.google.com/store/apps/details?id=" + this.getPackageName())));
            }
            return true;
        } else if (id == R.id.aboutus) {
            Intent aboutIntent = new Intent(this,
                    aboutActivity.class);
            startActivity(aboutIntent);
            return true;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
