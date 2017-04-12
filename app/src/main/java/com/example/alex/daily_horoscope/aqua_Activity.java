/**
 * The aqua_activity class is used for displaying
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

public class aqua_Activity extends BasicZodiacActivity {

    @Override
    //---On create function which displays the formated string---//
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aqua_);
        String link = "https://www.cafeastrology.com/dailyhoroscopes/aquariushorocode.php";
        super.loadHoroscope(link);
    }

    protected int getRId() {
        return R.id.webViewAqua;
    }
}
