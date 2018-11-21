package com.example.alex.daily_horoscope;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        RequestQueue queue = Volley.newRequestQueue(this);

        all = (Button)findViewById(R.id.all);
        textView = (TextView)findViewById(R.id.textView);
        dateZodiac = (TextView)findViewById(R.id.currentDate);

        //Typeface Textviews
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/AdventPro-Light.ttf");
        textView.setTypeface(typeface);
        dateZodiac.setTypeface(typeface);

        //sharedPrefs getting name of the image
        SharedPreferences sharedPref = getSharedPreferences("prefs", MODE_PRIVATE);
        profile = (ImageView)findViewById(R.id.profile);
        info = sharedPref.getString("sign","null");

        //set the imageView
        if(info=="aqua" || info.equals("aqua")){
            profile.setImageResource(R.drawable.aquarius);
        }
        if(info.equals("pisces") || info == "pisces"){
            profile.setImageResource(R.drawable.pisces);
        }
        if(info.equals("aries") || info=="aries"){
            profile.setImageResource(R.drawable.aries);
        }
        if(info.equals("taurus") || info=="taurus"){
            profile.setImageResource(R.drawable.taurus);
        }
        if(info.equals("gemini") || info=="gemini"){
            profile.setImageResource(R.drawable.gemini);
        }
        if(info.equals("cancer") || info=="cancer"){
            profile.setImageResource(R.drawable.cancer);
        }
        if(info.equals("leo") || info=="leo"){
            profile.setImageResource(R.drawable.leo);
        }
        if(info.equals("virgo") || info=="virgo"){
            profile.setImageResource(R.drawable.virgo);
        }
        if(info.equals("libra") || info=="libra"){
            profile.setImageResource(R.drawable.libra);
        }
        if(info.equals("scorpio") || info=="scorpio"){
            profile.setImageResource(R.drawable.scorpio);
        }
        if(info.equals("sagittarius") || info=="sagittarius"){
            profile.setImageResource(R.drawable.sagittarius);
        }

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(info=="aqua" || info.equals("aqua")){
                    profile.setImageResource(R.drawable.aquarius);
                    startActivity(new Intent(opening.this,aqua_Activity.class));
                }
                if(info.equals("pisces") || info == "pisces"){
                    profile.setImageResource(R.drawable.pisces);
                    startActivity(new Intent(opening.this,pisces_activity.class));
                }
                if(info.equals("aries") || info=="aries"){
                    profile.setImageResource(R.drawable.aries);
                    startActivity(new Intent(opening.this,aries_activity.class));
                }
                if(info.equals("taurus") || info=="taurus"){
                    profile.setImageResource(R.drawable.taurus);
                    startActivity(new Intent(opening.this,taurus_activity.class));
                }
                if(info.equals("gemini") || info=="gemini"){
                    profile.setImageResource(R.drawable.gemini);
                    startActivity(new Intent(opening.this,gemini_activity.class));
                }
                if(info.equals("cancer") || info=="cancer"){
                    profile.setImageResource(R.drawable.cancer);
                    startActivity(new Intent(opening.this,cancer_activity.class));
                }
                if(info.equals("leo") || info=="leo"){
                    profile.setImageResource(R.drawable.leo);
                    startActivity(new Intent(opening.this,leo_activity.class));
                }
                if(info.equals("virgo") || info=="virgo"){
                    profile.setImageResource(R.drawable.virgo);
                    startActivity(new Intent(opening.this,virgo_activity.class));
                }
                if(info.equals("libra") || info=="libra"){
                    profile.setImageResource(R.drawable.libra);
                    startActivity(new Intent(opening.this,libra_activity.class));
                }
                if(info.equals("scorpio") || info=="scorpio"){
                    profile.setImageResource(R.drawable.scorpio);
                    startActivity(new Intent(opening.this,scorpio_activity.class));
                }
                if(info.equals("sagittarius") || info=="sagittarius"){
                    profile.setImageResource(R.drawable.sagittarius);
                    startActivity(new Intent(opening.this,sagittarius_activity.class));
                }
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
