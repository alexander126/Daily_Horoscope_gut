package com.example.alex.daily_horoscope;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

import static android.content.Context.MODE_PRIVATE;

public class oneForAll extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_for_all);
        RequestQueue queue = Volley.newRequestQueue(this);
        final TextView textView = (TextView) findViewById(R.id.textview);
        final TextView extra = (TextView)findViewById(R.id.extra);
        final ImageView image = (ImageView)findViewById(R.id.beggining);
        ImageView imageZodiac = (ImageView)findViewById(R.id.image);

        //preferences for activity
        SharedPreferences sharedPref = getSharedPreferences("prefs", MODE_PRIVATE);
        String zodiacSign = sharedPref.getString("key",null);
        //set the image of the zodiacSignImage
        Context c = getApplicationContext();
        int id = c.getResources().getIdentifier("drawable/"+zodiacSign, null, c.getPackageName());
        imageZodiac.setImageResource(id);

        //Typeface Textviews
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/AdventPro-Light.ttf");
        textView.setTypeface(typeface);
        extra.setTypeface(typeface);

        String url = "https://aztro.sameerkumar.website/?sign="+zodiacSign+"&day=today";
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.d("Response", response);
                        try {

                            JSONObject jObj = new JSONObject(response);
                            String horoscope = jObj.getString("current_date") + "\n\n" + jObj.getString("description") + "\n";
                            String extraInformation = "Lucky number: " + jObj.getString("lucky_number")+ "\n" + "Color: " + jObj.getString("color") + "\n" + "Compatibility: " + jObj.getString("compatibility") + "\n" + "Mood: " + jObj.getString("mood");
                            extra.setText(extraInformation);
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

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(aqua_Activity.this,MainActivity.class));
                String shareText = textView.getText().toString();
                String shareText2 = extra.getText().toString();
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, shareText+shareText2);
                sendIntent.setType("text/plain");
                startActivity(Intent.createChooser(sendIntent, "Share this using..."));
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(oneForAll.this,MainActivity.class);
        startActivity(intent);
    }


}
