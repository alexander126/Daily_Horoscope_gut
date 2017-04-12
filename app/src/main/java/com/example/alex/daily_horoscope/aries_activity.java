/**
 * The aries_activity class is used for displaying
 * information provided from BasicZodiacActivity
 * about the specific zodiac sign.
 *
 *
 * @author  Aleksandar Kalapsazov
 * @version 1.0
 * @since   2017-03-18
 */
package com.example.alex.daily_horoscope;

import android.os.Bundle;

public class aries_activity extends BasicZodiacActivity {

    @Override
    //---On create function which displays the formated string---//
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aries_activity);
        String link = "https://www.cafeastrology.com/dailyhoroscopes/arieshorocode.php";
        super.loadHoroscope(link);
    }
    protected int getRId() {
        return R.id.webViewAries;
    }

}
