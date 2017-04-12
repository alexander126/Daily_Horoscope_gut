/**
 * The cancer_activity class is used for displaying
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

public class cancer_activity extends BasicZodiacActivity {

    @Override
    //---On create function which displays the formated string---//
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancer_activity);
        String link = "https://www.cafeastrology.com/dailyhoroscopes/cancerhorocode.php";
        super.loadHoroscope(link);
    }
    protected int getRId() {
        return R.id.webViewCancer;
    }
}
