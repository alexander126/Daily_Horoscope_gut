/**
 * The BasicZodiacActivity class is used for putting
 * the text related to the zodiac signs into desirable
 * string value in order to be displayed in the
 * Daily Horoscope Application
 *
 * @author  Aleksandar Kalapsazov
 * @version 1.0
 * @since   2017-03-18
 */
package com.example.alex.daily_horoscope;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import android.os.AsyncTask;

import android.webkit.WebView;

public class BasicZodiacActivity extends AppCompatActivity {
    String shareContent_;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    protected void loadHoroscope(String link) {
        new LoadArticleTask().execute(link);
    }

    protected int getRId() {
        return 0;
    }
    private class LoadArticleTask extends AsyncTask<String, Void, String> {

        protected String doInBackground(String... urls) {
            String result = "";

            try {
                //---Connecting to the quiery---//
                URL url = new URL(urls[0]);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(10000 /* milliseconds */);
                conn.setConnectTimeout(15000 /* milliseconds */);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                //---Starts the query---//
                conn.connect();

                InputStream stream = conn.getInputStream();
                BufferedReader r = new BufferedReader(new InputStreamReader(stream));
                StringBuilder total = new StringBuilder();
                String line;
                while ((line = r.readLine()) != null) {
                    total.append(line);
                }
                //---Put the text into string---//
                result = total.toString();
                String linkCss1 = "<link rel='stylesheet' href='design.css' type='text/css'>";
                result = "<html><header>" + linkCss1 + "</header><body>" + parseText(result) + "</body></html>";

            } catch (Exception e) {
                e.printStackTrace();
            }

            return result;
        }

        //---Placing the text in the webview---//
        protected void onPostExecute(String content) {
            WebView wView = (WebView) findViewById(getRId());
            shareContent_ = content;
            wView.loadDataWithBaseURL("file:///android_asset/", content, "text/html", "utf8", null);
        }
    }

    private String parseText(String origin) {
        //---Clearing the php stuff---//
        String newString;
        newString = replace(origin, "document.write(\"", null);
        newString = replace(newString, "https://www.cafeastrology.com/images/", null);
        newString = replace(newString, "https://cafeastrology.com/images/", null);
        newString = replace(newString, "\")", null);
        newString = replace(newString, "\\'", null);
        newString = replace(newString, "from Cafe Astrology", null);
        newString = replace(newString, "10pt","20pt");
        newString = replace(newString, "13pt","26pt");
        newString = replace(newString, "15px","30px");
        newString = replace(newString, "width='500'","width='360'");

        int endBad = newString.indexOf("<div");
        if (endBad > 0)
            newString = newString.substring(endBad);
        else
            return null;

        System.out.println("----------" + newString);
        return newString;
    }
        //--Support string for parseText string--//
    public static String replace(String s, String f, String r) {
        if (s == null)
            return s;
        if (f == null)
            return s;
        if (r == null)
            r = "";

        int index01 = s.indexOf(f);
        while (index01 != -1) {
            s = s.substring(0, index01) + r + s.substring(index01 + f.length());
            index01 += r.length();
            index01 = s.indexOf(f, index01);
        }

        return s;
    }
    protected void shareLink(){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, shareContent_);
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent, parseText(getResources().getText(R.string.send_to).toString())));
    }
}
