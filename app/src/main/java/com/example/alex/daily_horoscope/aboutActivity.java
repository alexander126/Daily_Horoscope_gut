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
import android.view.View;
import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class aboutActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Element versionElement = new Element();
        versionElement.setTitle("Version 1.0.1");

        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .addItem(versionElement)
                .setImage(R.drawable.adsoft)
                .setDescription("Daily Horoscope is an application developed by ADev Software to provide day to day horoscope.")
                .addGroup("Contact us")
                .addEmail("aboutadgroup@gmail.com")
                .create();

        setContentView(aboutPage);
    }
}