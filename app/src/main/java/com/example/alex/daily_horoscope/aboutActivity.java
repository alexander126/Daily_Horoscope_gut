/**
 * The aboutActivity class is used for providing information
 * * about Daily Horoscope Application using raw
 * document file to display it
 *
 * @author  Aleksandar Kalapsazov
 * @version 1.0
 * @since   2017-03-18
 */
package com.example.alex.daily_horoscope;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import java.io.*;

public class aboutActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        try {
            PlayWithRawFiles();
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(),
                    "Problems: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
    //---Function that get file from raw foder in resorces---//
    public void PlayWithRawFiles() throws IOException {
        String str="";
        StringBuffer buf = new StringBuffer();
        InputStream is = this.getResources().openRawResource(R.raw.hello);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        if (is!=null) {
            while ((str = reader.readLine()) != null) {
                buf.append(str + "\n" );
            }
        }
        is.close();
        TextView output = (TextView) findViewById(R.id.textViewFile);
        output.setText(buf);


    }
}